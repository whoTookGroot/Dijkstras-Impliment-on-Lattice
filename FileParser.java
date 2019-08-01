package shortestPath;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileParser {
	
	protected static int[] parseFile(String txt) throws Exception{
			
			FileReader file = new FileReader(txt);
			BufferedReader reader = new BufferedReader(file);
			final int SIZE = 231; 
			//231 instead of 233 because top left and bottom right corner of lattice are redundant
			int i = 0;
			int[] lattice = new int[SIZE];
			
			//skips first/last line which would be top left/bottom right corner.
			reader.readLine();
			String text = reader.readLine();
			 while (text != null && i < SIZE){
				 lattice[i++] = Integer.parseInt(text.substring(text.indexOf(" "),text.length()).trim());
				 text = reader.readLine();
			 }
			reader.close();
		return lattice;
	}
}
