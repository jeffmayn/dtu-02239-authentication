package server;
import java.awt.List;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import logic.Database;
import logic.Log;
import logic.UI;

public class PrinterServant  extends UnicastRemoteObject implements PrinterService {

	Database db = new Database();
	Log log = new Log();
	UI ui = new UI();
	
	public PrinterServant() throws RemoteException {
		super();
		
	}

	public String echo(String input) throws RemoteException {
		return "From printer server: " + input;
	}

	public String print(String filename, String printer)throws RemoteException {
		return "";
	}

	public List queue(String printer)throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void topQueue(String printer, int job)  throws RemoteException{
		// TODO Auto-generated method stub
		
	}

	public void start() throws RemoteException{
	
		
		db.initialiseDatabase();
		
	    ArrayList<String> printers = new ArrayList<String>();
	    printers.add("Printer #1");
	    printers.add("Printer #2");
	    printers.add("Printer #3");
	    printers.add("Printer #4");
	    
	    ui.printOptions();
	}

	public String stop() throws RemoteException {
		return "Printer server stopped!";
		
		/*
		System.out.println("stopping rmi server.");
	    UnicastRemoteObject.unexportObject(registry, true);
	    System.exit(0);
	    */
		
	}

	public String restart()  throws RemoteException{
		return "Printer server restarted!";
		
	}

	public String status(String printer) throws RemoteException {
		// TODO Auto-generated method stub
		return "";
	}

	public String readConfig(String parameter)  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public void setConfig(String parameter, String value) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void writeTestFile(String txt) throws RemoteException {
	
		
		log.writeToDisk(txt);
		
	}

	public void createUser(String uid, String pw) throws RemoteException {
		
		
	}

	public void deleteUser(String uid, String pw) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	private String hash(String password) {
		return password;
		
	}

	public void getUserPassword(String uid) throws RemoteException {
		
		System.out.println("Retrieving your password, " + uid);
		String password = db.queryPasswordFromDatabase(uid);
		
		
		
		
		
	}

	

}
