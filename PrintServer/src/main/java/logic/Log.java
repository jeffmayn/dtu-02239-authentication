package logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;


public class Log {
	

	
	public void writeLogEntry(String txt, String path) throws IOException {
		
		LocalDateTime localDateTime = LocalDateTime.now();
		//String time = localDate.toString();
		
		File f = new File(path);
		if(f.exists() && !f.isDirectory()) { 
			try
			{
			  //  String filename= "MyFile.txt";
			    FileWriter fw = new FileWriter(path,true); //the true will append the new data
			    fw.write("<" + localDateTime + ">" + " <" + txt + ">" + "\n");//appends the string to the file
			    fw.close();
			}
			catch(IOException ioe)
			{
			    System.err.println("IOException: " + ioe.getMessage());
			}
		} else {
			FileWriter fw = new FileWriter(path,false); //the true will append the new data
			 fw.write("<" + localDateTime + ">" + " <" + txt + ">" + "\n");///appends the string to the file
		    fw.close();
		}
	
		
		
	}
		
	public void readFile(String path) {
		
		 try {
		      File myObj = new File(path);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}

}
