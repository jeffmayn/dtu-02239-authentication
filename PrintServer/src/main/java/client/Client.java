package client;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import server.PrinterService;

public class Client {
	
	static Scanner input = new Scanner(System.in);  // Create a Scanner object
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		PrinterService service = (PrinterService) Naming.lookup("rmi://localhost:5137/printer");
		
		//System.out.println("--- " + service.echo("hey printer"));
		
		

		/*
		while (!input.hasNext("exit")) {
			
			String i = input.nextLine();
			//System.out.println("i: " + i);
			//printOptions();
			//String n = input.next();
			
			if(i.equals("print")) { 
				printLogic();

			} else if (i.equals("1")) { printOptions(); } 
			  else if (i.equals("queue")) { printOptions(); }
			  else if (i.equals("topQueue")) { }
			  else if (i.equals("start")) { service.start(); }
			  else if (i.equals("stop")) { }
			  else if (i.equals("forgot")) { service.getUserPassword(i); }
			  else if (i.equals("restart")) {  }
			  else if (i.equals("status")) {  }

		}
		*/
		
		// authenticate user
		login();
		
		// creates database
		// creates printers
		service.start();
		
		// query 
		service.getUserPassword("jeff");

		// service.writeTestFile("test");
		
	}
	
	public static void printLogic() {
		System.out.println("Please write name of printer");
		String printerName = input.nextLine();
		
		System.out.println("Please write name of file");
		String fileName = input.nextLine();
		
		System.out.println("> print(" + printerName + ", " + fileName + "); ");
		System.out.println("printing ...");
	}
	
	public static void login() {
		
		//TODO: make server authenticate one username and password
		
	    System.out.println("Enter username");
		String userName = input.nextLine();  // Read user input
	    System.out.println("Welcome to Printer Service, " + userName);  // Output user input
	}
	



}
