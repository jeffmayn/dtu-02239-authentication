package client;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.Scanner;

import services.PrinterService;

public class Client {
	
	PrinterService service;
	
	static UI ui = new UI();
	static Scanner input = new Scanner(System.in);  // Create a Scanner object
	
	public void begin(int portnumber) throws RemoteException {
		
		try {
			 service = (PrinterService) Naming.lookup("rmi://localhost:" + portnumber + "/printer");
		} 
		catch (MalformedURLException e) { e.printStackTrace(); } 
		catch (RemoteException e) 		{ e.printStackTrace(); } 
		catch (NotBoundException e) 	{ e.printStackTrace(); }
		
		
				
				// boot up server: creates database & printers
				service.start(); 
				
				// login & authenticate user
				if(login(service)) {	
					// automated tests
					if(ui.initialOptions(input)) {
						
						System.out.println(service.status("office"));
						service.print("text1.txt","office");
						service.print("text2.txt","office");
						service.print("text3.txt","office");
						service.print("text4.txt","office");
						service.print("text5.txt","office");
						System.out.println(service.queue("office"));
						service.topQueue("office", 3);
						System.out.println(service.queue("office"));
		
						service.print("text4.txt","home");
						System.out.println(service.queue("home"));
						
						service.restart();
						service.print("passwords.txt","office");
						service.print("sometext.txt","office");
						System.out.println(service.queue("office"));
					// manual
					} else {
						ui.printOptions();		
						ui.startLoop(input, service);
					}		
				}
	}
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
	}

	
	public boolean login(PrinterService service) throws RemoteException {
	
		String yo = "";
		
		while (!yo.equals("Login succesful!")) {
			
		    System.out.println("Enter your username");
			String userName = input.nextLine();  
			
		    System.out.println("Enter your password");
			String password = input.nextLine();  
			
			yo = service.authenticateUser(userName, password);		
			
			System.out.println(yo);
		}

		return true;
	
	}
}
