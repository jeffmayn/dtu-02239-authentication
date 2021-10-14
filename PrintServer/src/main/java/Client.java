import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
	
	static Scanner input = new Scanner(System.in);  // Create a Scanner object
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		PrinterService service = (PrinterService) Naming.lookup("rmi://localhost:5063/printer");
		
		//System.out.println("--- " + service.echo("hey printer"));
		
		login();
		printMenu();

		while (!input.hasNext("exit")) {
			
			String i = input.nextLine();
			//System.out.println("i: " + i);
			printMenu();
			//String n = input.next();
			
			if(i.equals("print")) { 
				printLogic();

			} else if (i.equals("1")) {
				printOptions();
			}

		}
		

		// start all printers
		// service.start();
		
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
	    System.out.println("Enter username");
		String userName = input.nextLine();  // Read user input
	    System.out.println("Welcome to Printer Service, " + userName);  // Output user input
	}
	
	public static void printMenu() {
	    System.out.println("+--- MENU ------------------------------------------------------+");
	    System.out.println("│      See options(1)       Login / Logout(2)        Exit(3)    │");
	    System.out.println("+---------------------------------------------------------------+");
	}
	
	public static void printOptions() {
	    System.out.println("+---COMMAND --------------DESCRIPTION---------------------------+");
	    System.out.println("│ print         │ prints file filename on the specified printer │");
	    System.out.println("│ queue         │ lists the print queue for a given printer     │");
	    System.out.println("│ topQueue      │ moves job to the top of the queue             │");
	    System.out.println("│ start         │ starts the print server                       │");
	    System.out.println("│ stop          │ stops the print se                            │");
	    System.out.println("│ restart       │ stops, clears and restart server              │");
	    System.out.println("│ status        │ prints status of printer                      │");
	    System.out.println("│ exit          │ exits application                             │");
	    System.out.println("+---------------------------------------------------------------+");
	}

}
