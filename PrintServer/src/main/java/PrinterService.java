import java.rmi.RemoteException;
import java.awt.List;
import java.rmi.Remote;

public interface PrinterService extends Remote {
	
	public String echo(String input) throws RemoteException;
	
	public String print(String filename, String printer) throws RemoteException;
	
	public List queue(String printer) throws RemoteException;
	
	public void topQueue(String printer, int job) throws RemoteException;
	
	public void start() throws RemoteException;
	
	public void stop() throws RemoteException;
	
	public void restart() throws RemoteException;
	
	public String status(String printer) throws RemoteException;
	
	public String readConfig(String parameter) throws RemoteException;
	
	public void setConfig(String parameter, String value) throws RemoteException;
	
	public void writeTestFile(String txt) throws RemoteException;

}
