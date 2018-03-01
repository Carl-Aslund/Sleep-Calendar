package sleepData;

import datetime.*;

public class SleepNight {

	private DateTime sleepStart;
	private DateTime sleepEnd;
	private Date morningAfter;
	private Time timeElapsed;

	/**
	 * Getter for private variable.
	 * 
	 * @return	the DateTime of the bedtime
	 */
	public DateTime getSleepStart() {
		return sleepStart;
	}

	/**
	 * Setter for private variable.
	 * 
	 * @param	sleepStart		an input DateTime
	 */
	public void setSleepStart(DateTime sleepStart) {
		this.sleepStart = sleepStart;
	}
	
	/**
	 * Getter for private variable.
	 * 
	 * @return	the date of the morning after
	 */
	public DateTime getSleepEnd() {
		return sleepEnd;
	}

	/**
	 * Setter for private variable.
	 * 
	 * @param	sleepEnd		an input DateTime
	 */
	public void setSleepEnd(DateTime sleepEnd) {
		this.sleepEnd = sleepEnd;
	}
	
	/**
	 * Getter for private variable.
	 * 
	 * @return	the date of the morning after
	 */
	public Date getMorningAfter() {
		return morningAfter;
	}

	/**
	 * Setter for private variable.
	 * 
	 * @param	morningAfter		an input Date
	 */
	public void setMorningAfter(Date morningAfter) {
		this.morningAfter = morningAfter;
	}

	/**
	 * Getter for private variable.
	 * 
	 * @return	the duration of the night's sleep
	 */
	public Time getTimeElapsed() {
		return timeElapsed;
	}

	/**
	 * Setter for private variable.
	 * 
	 * @param	timeElapsed		an input Time
	 */
	public void setTimeElapsed(Time timeElapsed) {
		this.timeElapsed = timeElapsed;
	}
	
	/**
	 * Class constructor.
	 * 
	 * @param start	the DateTime for when the sleep starts
	 * @param end	the DateTime for when the sleep ends
	 */
	public SleepNight(DateTime start, DateTime end) {
		this.setSleepStart(start);
		this.setSleepEnd(end);
		this.setMorningAfter(this.sleepEnd.getDate());
		this.setTimeElapsed(this.sleepStart.timeBefore(sleepEnd));
	}
	
	/**
	 * Class constructor.
	 * 
	 * @param values		a String array read in from a csv file
	 */
	public SleepNight(String[] values) {
		this(new DateTime(values[0]), new DateTime(values[1]));
	}
	
	public static void main(String[] args) {
		
	}

}
