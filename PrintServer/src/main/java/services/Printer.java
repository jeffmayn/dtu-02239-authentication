package services;
import java.util.ArrayList;

public class Printer {
	ArrayList<String> queue = new ArrayList<String>();
	String printerName;
	
	public Printer (){}
	
    public ArrayList<String> getQueue() {
        return queue;
    }
    
    public void addToQueue(String job) {
        queue.add(job);
    }
    
    public String getPrinterName() {
    	return printerName;
    }
    
    public void setPrinterName(String name) {
    	printerName = name;
    }
    
    public void topQueue(int job) {
    	String temp = queue.get(job);
    	queue.remove(job);
    	queue.add(0, temp);	
    }
    
    public void clearQueue() {
    	queue.clear();
    }
}
