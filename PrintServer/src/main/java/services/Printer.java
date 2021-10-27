package services;
import java.util.ArrayList;
import java.util.HashMap;

public class Printer {
	ArrayList<String> queue = new ArrayList<String>();
	HashMap<String, Object> status = new HashMap<String, Object>();
//	HashMap<String, Object> config = new HashMap<String, Object>();
	
	String printerName;
	boolean power;
	boolean isPrinting;
//	boolean colorPrinter;
	
	
	public Printer (boolean colorPrinter, int inklevel){
		
		power = true;
		isPrinting = false;
		this.status.put("power", power);
		this.status.put("isPrinting", isPrinting);
		
	//	this.colorPrinter = colorPrinter;
	//	this.config.put("color", colorPrinter);
	//	this.config.put("ink level", inklevel);
		
	
		
	}
	
	public String status() {
		
		return status.toString();
		
		
		
	}
	
	/*
	public String readConfig() {
		
		return config.toString();
	}
	
	public void setConfig() {
	
	}
	*/
	
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
