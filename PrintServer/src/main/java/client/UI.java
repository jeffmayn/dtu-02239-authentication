package client;

import java.rmi.RemoteException;
import java.util.Scanner;

import services.PrinterService;

public class UI {
	
	public void startLoop(Scanner input, PrinterService service) throws RemoteException {
		
		while (!input.hasNext("exit")) {
			
			String i = input.nextLine();
			//System.out.println("i: " + i);
			//printOptions();
			//String n = input.next();
			
			if(i.equals("print")) { printLogic(input); } 
			  else if (i.equals("1")) { printOptions(); } 
			  else if (i.equals("queue")) { printOptions(); }
			  else if (i.equals("topQueue")) { topQueueLogic(service, input); }
			  else if (i.equals("start")) { service.start(); }
			  else if (i.equals("stop")) { }
			  else if (i.equals("restart")) {  }
			  else if (i.equals("status")) {  }
		}
	}
	
	public void topQueueLogic(PrinterService service, Scanner input) throws RemoteException {
		
		System.out.println("Write name of printer");
		String printerName = input.nextLine();
		
		System.out.println("Write job#");
		String job = input.nextLine();
		
		service.topQueue(job, 0);
		
	}
	
	public void printLogic(Scanner input) {
		System.out.println("Please write name of printer");
		String printerName = input.nextLine();
		
		System.out.println("Please write name of file");
		String fileName = input.nextLine();
		
		System.out.println("> print(" + printerName + ", " + fileName + "); ");
		System.out.println("printing ...");
	}
	

	public boolean initialOptions(Scanner input) {
		 System.out.println("Press (1) for automated tests\nPress (2) for manuel");	 
		 String choice = input.nextLine();
		 if(choice.equals("1")) {
			 return true;
		 } else {
			 return false;
		 }
	}
	
	
	public void printOptions() {
		
	    System.out.println("+--- MENU ------------------------------------------------------+");
	    System.out.println("'                                                               '");
	    System.out.println("'      See options(1)       Login / Logout(2)        Exit(3)    '");
	    System.out.println("'                                                               '");
	    System.out.println("+---COMMAND --------------DESCRIPTION---------------------------+");
	    System.out.println("' print         │ prints file filename on the specified printer '");
	    System.out.println("' queue         │ lists the print queue for a given printer     '");
	    System.out.println("' topQueue      │ moves job to the top of the queue             '");
	    System.out.println("' start         │ starts the print server                       '");
	    System.out.println("' stop          │ stops the print se                            '");
	    System.out.println("' restart       │ stops, clears and restart server              '");
	    System.out.println("' status        │ prints status of printer                      '");
	    System.out.println("' forgot        │ return users password                         '");
	    System.out.println("' exit          │ exits application                             '");
	    System.out.println("+---------------------------------------------------------------+");
	}



	

}
