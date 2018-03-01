package sleepData;

import java.util.*;
import java.io.*;

public class CsvReader {

	private BufferedReader bufferedReader;
	
	/**
	 * Class constructor.
	 * 
	 * @param fileName	the name of the .csv file to be read
	 */
	public CsvReader(String fileName) {
		try {
			FileReader fileReader = new FileReader("data/"+fileName);
			this.bufferedReader = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found.");
		}
	}
	
	/**
	 * Reads the target file in its entirety.
	 * 
	 * @return	a 2D String array, first by line, then by column
	 */
	public String[][] readFile() {
		String line = null;
		ArrayList<String[]> outList = new ArrayList<String[]>();
		try {
			while ((line = this.bufferedReader.readLine()) != null) {
				outList.add(line.split(","));
			}
		} catch (IOException e) {
			System.out.println("ERROR: Read failure.");
		}
		return (String[][]) outList.toArray();
	}
	
	/**
	 * Closes the BufferedReader opened by this class.
	 */
	public void close() {
		try {
			this.bufferedReader.close();
		} catch (IOException e) {
			System.out.println("ERROR: Failure to close file.");
		}
	}
	
	public static void main(String[] args) {
		
	}

}
