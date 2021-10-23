package services;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import logic.Crypto;
import logic.Database;
import logic.Log;

public class PrinterServant  extends UnicastRemoteObject implements PrinterService {
	
	ArrayList<Printer> printers = new ArrayList<Printer>();
	Database db = new Database();
	Log log = new Log();
	Crypto crypto = new Crypto();
	
	public PrinterServant() throws RemoteException {
		super();	
	}

	public void print(String filename, String printer) throws RemoteException {
		
		for (Printer p : printers) {
			if(p.printerName.equals(printer)) {
				p.addToQueue(filename);
				//break;
			} 
		}
		//System.out.println("Printer " + printer + " not found!");	
	}

	public void queue(String printer)throws RemoteException {
		
		for (Printer p : printers) {
			if(p.printerName.equals(printer)) {
				System.out.println("Queue for printer: " + printer);
			
				int i = 1;
				for (String job : p.getQueue()) {			
					System.out.println("[" + i + "]" + job);
					i++;
				}
			} 
		}
		System.out.println("");
	}

	public void topQueue(String printer, int job)  throws RemoteException{
		for(Printer p : printers) {
			if(p.printerName.equals(printer)) {
				p.topQueue(job);
			}
		}
	}

	public void start() throws RemoteException{
		db.initialiseDatabase();
		initialisePrinters(); 
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
	
	private void initialisePrinters() {
		
        Printer office = new Printer();
        office.setPrinterName("office");
        printers.add(office);
        
        Printer home = new Printer();
        home.setPrinterName("home");
        printers.add(home);

	}

	public boolean authenticateUser(String uid, String password, String salt) throws RemoteException {
		
		String h1 = db.queryPasswordFromDatabase(uid);
		String h2 = crypto.hash(password, salt);
		
		return crypto.compareHashes(h1, h2);
	}
}
