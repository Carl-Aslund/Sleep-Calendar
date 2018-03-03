package sleepData;

public class DataHandler {

	public SleepNight[] nights;
	
	/**
	 * Class constructor.
	 */
	public DataHandler() {
		CsvReader reader = new CsvReader(Preferences.dataFile);
		String[][] input = reader.readFile();
		nights = new SleepNight[input.length];
		for (int i=0; i<input.length; i++) {
			nights[i] = new SleepNight(input[i]);
		}
		reader.close();
	}
	
	public static void main(String[] args) {
		
	}

}
