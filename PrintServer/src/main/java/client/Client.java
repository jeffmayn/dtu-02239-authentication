package client;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import services.PrinterService;

public class Client {
	
	static Scanner input = new Scanner(System.in);  // Create a Scanner object
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		PrinterService service = (PrinterService) Naming.lookup("rmi://localhost:5165/printer");
		//System.out.println("--- " + service.echo("hey printer"));
		
		// creates database & printers
		service.start(); 
		
		// login & authenticate user
		if(login(service)) {		
			
			// print(filename, printername)
			service.print("text1.txt","p1");
		}
	}
	
	public static void printLogic() {
		System.out.println("Please write name of printer");
		String printerName = input.nextLine();
		
		System.out.println("Please write name of file");
		String fileName = input.nextLine();
		
		System.out.println("> print(" + printerName + ", " + fileName + "); ");
		System.out.println("printing ...");
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
				System.out.println("Login succes!");
				return auth;
			} else {
				System.out.println("Wrong username or password!");
				return auth;
			}
			
		} catch (RemoteException e) {
			System.out.println("Authentication failed!");
			e.printStackTrace();
			return auth;
		}
		
	}
	



}
