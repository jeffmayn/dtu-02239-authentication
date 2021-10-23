package client;

import java.util.Scanner;

public class UI {
	
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
