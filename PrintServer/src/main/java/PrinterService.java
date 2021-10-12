import java.rmi.RemoteException;
import java.rmi.Remote;

public interface PrinterService extends Remote {
	
	public String echo(String input) throws RemoteException;

}
