package com.greatlearning.BBNGenerics;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;
public class CustomerTest {
	@Test
	public void mainMethodTest() {
		boolean output = false;
		try  
		{  
		File file=new File("src/main/java/com/greatlearning/BBNGenerics/Customer.java");    //creates a new file instance
		//file.getAbsoluteFile();
		FileReader fr=new FileReader(file);   //reads the file  
		BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
		StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
		String line;  
		while((line=br.readLine())!=null)  
		{  
			if(line.contains("extends User")) {
				output = true;
				break;
			}
							
		}  
		fr.close();    //closes the stream and release the resources  
		}  
		catch(IOException e)  
		{  
		e.printStackTrace();  
		}
		assertTrue("Cunstomer should Extends User ",output);
	}

}
