package client;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import services.PrinterService;

public class Client {
	
	static UI ui = new UI();
	static Scanner input = new Scanner(System.in);  // Create a Scanner object
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		PrinterService service = (PrinterService) Naming.lookup("rmi://localhost:5227/printer");
		
		// boot up server: creates database & printers
		service.start(); 
		
		// login & authenticate user
		if(login(service)) {	
			// automated tests
			if(ui.initialOptions(input)) {
				service.print("text1.txt","office");
				service.print("text2.txt","office");
				service.print("text3.txt","office");
				service.print("text4.txt","office");
				service.print("text5.txt","office");
				service.queue("office");
				service.topQueue("office", 3);
				service.queue("office");

				service.print("text4.txt","home");
				service.queue("home");
				
				service.restart();
				service.print("passwords.txt","office");
				service.print("sometext.txt","office");
				service.queue("office");
			// manual
			} else {
				ui.printOptions();		
				ui.startLoop(input, service);
			}		
		}
	}

	
	public static boolean login(PrinterService service) {
	    System.out.println("Enter your username");
		String userName = input.nextLine();  
		
	    System.out.println("Enter your password");
		String password = input.nextLine();  
		
		boolean auth = false;
	    try {
	    	String salt = "22-10-2021:21.18zz";
			auth = service.authenticateUser(userName, password, salt);		
			
			if(auth) {
				System.out.println("Login succes!\n");
				return auth;
			} else {
				System.out.println("Wrong username or password!\n");
				return auth;
			}		
		} catch (RemoteException e) {
			System.out.println("Authentication failed!\n");
			e.printStackTrace();
			return auth;
		}	
	}
}
