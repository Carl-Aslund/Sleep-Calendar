package datetime;

public class DateTime {

	private Date date;
	private Time time;
	
	/**
	 * Returns the current date and time as a DateTime object.
	 * WARNING: This has only been tested in PST.
	 * 
	 * @return	the current DateTime
	 */
	public static DateTime currentDateTime() {
		return new DateTime(Date.currentDate(), Time.currentTime());
	}
	
	/**
	 * Class constructor.
	 * 
	 * @param inDate		the date of the DateTime object
	 * @param inTime		the time of the DateTime object
	 */
	public DateTime(Date inDate, Time inTime) {
		this.date = inDate;
		this.time = inTime;
	}
	
	/**
	 * Class constructor.
	 * 
	 * @param	dateTimeStr	a String representing equivalent toString() output
	 */
	public DateTime(String dateTimeStr) {
		String[] dateTimeParts = dateTimeStr.split(" ");
		this.date = new Date(dateTimeParts[0]);
		this.time = new Time(dateTimeParts[1]);
	}
	
	/**
	 * Class copy constructor.
	 * 
	 * @param other	a DateTime object containing all desired attributes
	 */
	public DateTime(DateTime other) {
		this.date = new Date(other.date);
		this.time = new Time(other.time);
	}
	
	/**
	 * Overrides the default Object.toString() method.
	 * 
	 * @return	a String representation of the DateTime object
	 */
	public String toString() {
		return this.date.toString() + " " + this.time.toString();
	}
	
	/**
	 * Determines how much time before another a given DateTime this is.
	 * 
	 * @param other	another DateTime object in question
	 * @return		a Time object representing the difference in times
	 */
	public Time timeBefore(DateTime other) {
		return (new Time(24*date.daysBefore(other.date),0)).addTime(
				this.time.timeBefore(other.time));
	}
	
	public static void main(String[] args) {
		
	}

}
