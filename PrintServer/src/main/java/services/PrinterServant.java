package services;
import java.awt.List;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import client.UI;
import logic.Crypto;
import logic.Database;
import logic.Log;

public class PrinterServant  extends UnicastRemoteObject implements PrinterService {

	Database db = new Database();
	Log log = new Log();
	Crypto crypto = new Crypto();
	
	public PrinterServant() throws RemoteException {
		super();
		
	}

	public String echo(String input) throws RemoteException {
		return "From printer server: " + input;
	}

	public void print(String filename, String printer)throws RemoteException {
		
		System.out.println(printer + " printin: KILL ALL HUMANS");
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

	public boolean authenticateUser(String uid, String password, String salt) throws RemoteException {
		
		String h1 = db.queryPasswordFromDatabase(uid);
		String h2 = crypto.hash(password, salt);
		
		return crypto.compareHashes(h1, h2);
		
		

	}

	

}
