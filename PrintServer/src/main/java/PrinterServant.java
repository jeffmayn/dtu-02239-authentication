import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class PrinterServant  extends UnicastRemoteObject implements PrinterService {
	
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

	public String start() throws RemoteException{
	    ArrayList<String> printers = new ArrayList<String>();
	    printers.add("Printer #1");
	    printers.add("Printer #2");
	    printers.add("Printer #3");
	    printers.add("Printer #4");
	    
	    System.out.println(printers);
		
		return "All printers are started!";
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
	
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("the-file-name.txt", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println("The first line");
		writer.println("The second line");
		writer.close();
		
	}

}
