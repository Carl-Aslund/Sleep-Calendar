package datetime;

public class Time {

	private int hour;
	private int minute;
	
	/**
	 * Returns the current time of day as a Time object.
	 * WARNING: This has only been tested in PST.
	 * 
	 * @return	the current Time
	 */
	public static Time currentTime() {
		String timeStr = java.time.LocalTime.now().toString();
		return new Time(timeStr.substring(0, 5));
	}
	
	/**
	 * Class constructor.
	 * 
	 * @param inHour		the hour of the Time object
	 * @param inMinute	the minute of the Time object
	 */
	public Time(int inHour, int inMinute) {
		this.hour = inHour;
		this.minute = inMinute;
	}
	
	/**
	 * Class constructor.
	 * 
	 * @param	timeStr	a String representing equivalent toString() output
	 */
	public Time(String timeStr) {
		String[] timeParts = timeStr.split(":");
		this.hour = Integer.parseInt(timeParts[0]);
		this.minute = Integer.parseInt(timeParts[1]);
	}
	
	/**
	 * Class copy constructor.
	 * 
	 * @param other	a Time object containing all desired attributes
	 */
	public Time(Time other) {
		this.hour = other.hour;
		this.minute = other.minute;
	}
	
	/**
	 * Overrides the default Object.toString() method.
	 * 
	 * @return	a String representation of the Time object
	 */
	public String toString() {
		String block1 = "";
		String block2 = "";
		if (this.hour<10) {
			block1 = "0";
		}
		if (this.minute<10) {
			block2 = "0";
		}
		return block1 + this.hour + ":" + block2 + this.minute;
	}
	
	/**
	 * Determines if the Time object represents a valid time of day.
	 * 
	 * @return	true or false, whether the given time is valid
	 */
	public boolean isValid() {
		return (this.minute<60 && this.minute>=0 && this.hour<24 && this.hour>=0);
	}
	
	/**
	 * Determines if two Time objects (this and other) represent the same thing.
	 * 
	 * @param other	another Time object in question
	 * @return		true or false, whether this and other are equivalent
	 */
	public boolean equals(Time other) {
		return (this.minute == other.minute) && (this.hour == other.hour);
	}
	
	/**
	 * Determines if one Time object occurs before another.
	 * 
	 * @param other	another Time object in question
	 * @return		true or false, whether this occurs before other
	 */
	public boolean before(Time other) {
		if (this.equals(other)) {
			return false;
		}
		else if (this.hour == other.hour) {
			return this.minute < other.minute;
		}
		else {
			return this.hour < other.hour;
		}
	}
	
	/**
	 * Determines if one Time object occurs after another.
	 * 
	 * @param other	another Time object in question
	 * @return		true or false, whether this occurs after other
	 */
	public boolean after(Time other) {
		if (this.equals(other)) {
			return false;
		}
		else {
			return !this.before(other);
		}
	}
	
	/**
	 * Determines how many minutes before another a given Time is.
	 * 
	 * @param other	another Time object in question
	 * @return		an integer representation of the minutes between times
	 */
	public int minsBefore(Time other) {
		Time copy = new Time(this);
		if (this.equals(other)) {
			return 0;
		}
		else if (this.after(other)) {
			return -1 * other.minsBefore(this);
		}
		else if (this.hour == other.hour) {
			return other.minute - this.minute;
		}
		else {
			int hourTotal = 60*(other.hour - this.hour);
			copy.hour = other.hour;
			return hourTotal + copy.minsBefore(other);
		}
	}
	
	/**
	 * Determines how much time before another a given Time this is.
	 * 
	 * @param other	another Time object in question
	 * @return		a Time object representing the difference in times
	 */
	public Time timeBefore(Time other) {
		int mins = this.minsBefore(other);
		return new Time(mins/60, mins%60);
	}
	
	/**
	 * Combines the values of two Time objects.
	 * 
	 * @param other	another Time object to be added
	 * @return		a Time object representing the sum of both times
	 */
	public Time addTime(Time other) {
		return new Time(this.hour+other.hour, this.minute+other.minute);
	}
	
	public static void main(String[] args) {
		Time t1 = new Time("5:00");
		Time t2 = new Time("12:15");
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t1.minsBefore(t2));
	}

}
