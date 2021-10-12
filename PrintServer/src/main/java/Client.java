import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		PrinterService service = (PrinterService) Naming.lookup("rmi://localhost:5097/printer");
		
		System.out.println("--- " + service.echo("hey printer"));
		
	}

}
