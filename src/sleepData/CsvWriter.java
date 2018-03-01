package sleepData;

import java.io.*;

public class CsvWriter {

	private BufferedWriter bufferedWriter;
	
	/**
	 * Class constructor.
	 * 
	 * @param fileName	the name of the .csv file to be written
	 */
	public CsvWriter(String fileName) {
		this(fileName, false);
	}
	
	/**
	 * Class constructor.
	 * 
	 * @param fileName	the name of the .csv file to be written
	 * @param append		whether the file exists already or not
	 */
	public CsvWriter(String fileName, boolean append) {
		try {
			FileWriter fileWriter = new FileWriter("data/"+fileName, append);
			this.bufferedWriter = new BufferedWriter(fileWriter);
		} catch (IOException e) {
			System.out.println("ERROR: Failed file writer creation.");
		}
	}
	
	/**
	 * Write a single comma-separated line to the end of the opened file.
	 * 
	 * @param	line	Values	an Object array of output values
	 */
	public void writeLine(Object[] lineValues) {
		String line = "";
		int numValues = lineValues.length;
		for (int i=0; i<numValues; i++) {
			if (i>0)
				line += ",";
			line += lineValues[i].toString();
		}
		try {
			this.bufferedWriter.write(line);
			this.bufferedWriter.newLine();
		} catch (IOException e) {
			System.out.println("ERROR: Failed writing to file.");
		}
	}
	
	/**
	 * Closes the BufferedWriter opened by this class.
	 */
	public void close() {
		try {
			this.bufferedWriter.close();
		} catch (IOException e) {
			System.out.println("ERROR: Failure to close file.");
		}
	}
	
	public static void main(String[] args) {
		CsvWriter writer = new CsvWriter("file.csv");
		Object[] obj = {1, 4, "5.0", "alpha", 'a'};
		writer.writeLine(obj);
		writer.close();
	}

}
