package server;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import services.PrinterServant;

public class ApplicationServer {
	
	public static void main(String[] args) throws RemoteException {
		
		Registry registry = LocateRegistry.createRegistry(5188);
		registry.rebind("printer", new PrinterServant());
		
		
		
		/*
		System.out.println("stopping rmi server.");
	    UnicastRemoteObject.unexportObject(registry, true);
	    System.exit(0);
	    */
		
	}

}
