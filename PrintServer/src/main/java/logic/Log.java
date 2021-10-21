package logic;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class Log {
	
	public void writeToDisk(String txt) {
	
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("log.txt", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println("Logfile:");
		writer.println(txt);

		writer.close();
		
	}
	
	public void readFromDisk(String filename) {
		//TODO
	}

}
