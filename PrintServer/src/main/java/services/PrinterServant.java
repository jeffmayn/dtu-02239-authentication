package services;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import logic.Crypto;
import logic.Database;
import logic.Log;

public class PrinterServant  extends UnicastRemoteObject implements PrinterService {
	
	ArrayList<Printer> printers = new ArrayList<Printer>();
	Database db = new Database();
	Log log = new Log();
	Crypto crypto = new Crypto();

	LocalDate localDate = LocalDate.now();
	String path = "log\\";
	boolean consoleLogServerPrints = false;
	
	String loggedInUser = "";
	int authAttempts = 0;
	boolean lock = false;
	
	long timestampBegin = System.currentTimeMillis();
	//long timestamp2 = System.currentTimeMillis();
	int lockoutTime = 10000;
	
	
	long timestamp1 = 0;
	long timestamp2 = 0;
	
	public PrinterServant() throws RemoteException {
		super();
	}

	public void print(String filename, String printer) throws RemoteException {
		for (Printer p : printers) {
			if(p.printerName.equals(printer)) {
				p.addToQueue(filename); // add print to printer queue
				writeLogEntry(filename, path + printer + ".log");
			} 
		}
	}
	
	public String queue(String printer)throws RemoteException {
		
		String queue = "Queue for printer: " + printer + "\n";
		for (Printer p : printers) {
			if(p.printerName.equals(printer)) {
				if(consoleLogServerPrints) System.out.println("Queue for printer: " + printer);
				writeLogEntry("[user]: Queue for printer: " + printer, path + "server.log");
				
				int i = 1;
				for (String job : p.getQueue()) {			
					if(consoleLogServerPrints) System.out.println("[" + i + "] " + job);
					queue += "<" + i + "> <" + job + ">\n";
				//	writeLogEntry("[" + i + "] " + job, path + "server.log");
					i++;
				}
			} 
		}
		if(consoleLogServerPrints) System.out.println("");
		return queue;
	}

	public void topQueue(String printer, int job)  throws RemoteException{
		for(Printer p : printers) {
			if(p.printerName.equals(printer)) {
				if(consoleLogServerPrints) System.out.println("[Server]: Moving job" + "[" + job + "] to top.\n");
				writeLogEntry("[Server]: Moving job" + "[" + job + "] to top.", path + "server.log");
				p.topQueue(job-1);
			}
		}
	}

	public void start() throws RemoteException{
		if(consoleLogServerPrints) System.out.println("[server]: starting.");
		writeLogEntry("[server]: starting..", path + "server.log");
		db.initialiseDatabase();
		//logPath = log.initialiseLog();
		initialisePrinters(); 
	}

	public void stop() throws RemoteException {
		if(consoleLogServerPrints) System.out.println("[server]: stopping.");
		writeLogEntry("[server]: stopping..", path + "server.log");
		//logPath = "";
		db.disconnect();
		
		/*
		System.out.println("stopping rmi server.");
	    UnicastRemoteObject.unexportObject(registry, true);
	    System.exit(0);
	    */
		
	}

	public void restart()  throws RemoteException{
		if(consoleLogServerPrints) System.out.println("[server]: restarting.");
		writeLogEntry("[server]: restarting..", path + "server.log");
		stop();
		printers.clear();
		start();
		
	}

	public String status(String printer) throws RemoteException {
		String returnMessage = "status for " + printer + ": ";
		for(Printer p : printers) {
			
			if(p.printerName.equals(printer)) {
				returnMessage = p.status();				
			} 
		}
		return returnMessage;
	}

	public String readConfig(String parameter)  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public void setConfig(String parameter, String value) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	private void initialisePrinters() {
		
		// printer(boolean color, integer ink level)
        Printer office = new Printer(true, 90);
        office.setPrinterName("office");
        printers.add(office);
        
        Printer home = new Printer(false, 2);
        home.setPrinterName("home");
        printers.add(home);
        
        Printer hallway = new Printer(true, 50);
        hallway.setPrinterName("hallway");
        printers.add(hallway);

	}
	
	private void writeLogEntry(String txt, String path) {
		try {
			log.writeLogEntry(txt, path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String authenticateUser(String uid, String password) throws RemoteException {
		
		if(System.currentTimeMillis() >= (timestamp1 + lockoutTime)) {
			lock = false;
			timestamp1 = 0;
		}
	
		String returnVal = "";
		boolean loggedIn = false;
		String[] credentials = db.getCredentials(uid); 	// users (password, salt) from DB
		
		String h1 = credentials[0];
		String h2 = crypto.hash(password, credentials[1]);
		
			
		authAttempts++;	
		if(!lock) {
			if(authAttempts < 3) {
				loggedIn = crypto.compareHashes(h1, h2);
				
				if(loggedIn) {
					returnVal = "Login succesful!";
				} else {
					returnVal = "Wrong password or username";
				}	
			} else {
				authAttempts = 0;
				lock = true;
				timestamp1 = System.currentTimeMillis();
				returnVal = "Too many attempts. Try again in " + lockoutTime / 1000 + "seconds";
			}
		} else {
			returnVal = "Too many attempts. Try again in " + (lockoutTime - (System.currentTimeMillis() - timestamp1)) / 1000 + " seconds";	
		}
		
		/*

		if(loggedIn) {
			authAttempts = 0;
			writeLogEntry("[" + uid + "]: logged in", path + "server.log");
			loggedInUser = uid;
		} else {
			
			authAttempts++;
			writeLogEntry("[" + uid + "]: failed login attempt #" + authAttempts, path + "server.log");
			loggedInUser = null;
		}
		*/
		
		return returnVal;
	
	}
}
