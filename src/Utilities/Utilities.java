package Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utilities {

	public static String loadFileAsString(String path) {
		//adds characters to a string 
		StringBuilder builder= new StringBuilder();
		
		try {
			BufferedReader br= new BufferedReader(new FileReader(path));
			String line;
			//While file hasn't reached its end
			while((line = br.readLine()) != null){
				//add to string
				builder.append(line+"\n");
			}
			
			br.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return builder.toString();
	}

	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		//if string isn't a number
		}catch(NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
