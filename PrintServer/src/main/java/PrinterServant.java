import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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

	public void start()  throws RemoteException{
		// TODO Auto-generated method stub
		
	}

	public void stop() throws RemoteException {
		System.out.println("stopping rmi server.");
	    UnicastRemoteObject.unexportObject(registry, true);
	    System.exit(0);
		
	}

	public void restart()  throws RemoteException{
		// TODO Auto-generated method stub
		
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
