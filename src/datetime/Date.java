package datetime;

public class Date {

	private static final int[] MAX_DAYS = {31,28,31,30,31,30,31,31,30,31,30,31};
	private static final int[] MAX_DAYS_LEAP = {31,29,31,30,31,30,31,31,30,31,
			30,31};
	private static final String[] WEEKDAYS = {"Monday", "Tuesday", "Wednesday",
			"Thursday", "Friday", "Saturday", "Sunday"};
	
	private static final int USUAL_DAYS = 365;
	private static final int LEAP_DAYS = 366;
	
	private int year;
	private int month;
	private int day;
	private int weekday;
	
	/**
	 * Getter for the current day of the week.
	 * 
	 * @return	the date's day of the week as an int
	 */
	public int getWeekday() {
		return this.weekday;
	}
	
	/**
	 * Getter for a day of the week as an integer.
	 * 
	 * @param	dayName	the name of the day of the week
	 * @return			the corresponding integer
	 */
	public static int getWeekday(String dayName) {
		for (int i=0; i<7; i++) {
			if (WEEKDAYS[i].equals(dayName))
				return i;
		}
		return -1;
	}
	
	/**
	 * Getter for the current day of the week.
	 * 
	 * @return	the date's day of the week as an int
	 */
	public String getWeekdayName() {
		return WEEKDAYS[this.weekday];
	}
	
	/**
	 * Sets the weekday to the appropriate day.
	 */

	public void setWeekday() {
		int diff = ((new Date(2018,1,1)).daysBefore(this))%7;
		if (diff < 0) diff += 7;
		this.weekday = diff;
	}
	

	/**
	 * Returns the current date as a Date object.
	 * WARNING: This has only been tested in PST.
	 * 
	 * @return	the current Date
	 */
	public static Date currentDate() {
		String dateStr = java.time.LocalDate.now().toString();
		dateStr = dateStr.replaceAll("-", "/");
		return new Date(dateStr);
	}
	
	/**
	 * Class constructor.
	 * 
	 * @param inYear		the year of the Date object
	 * @param inMonth	the month of the Date object
	 * @param inDay		the day of the Date object
	 */
	public Date(int inYear, int inMonth, int inDay) {
		this.year = inYear;
		this.month = inMonth;
		this.day = inDay;
		this.setWeekday();
	}
	
	/**
	 * Class constructor.
	 * 
	 * @param	dateStr	a String representing equivalent toString() output
	 */
	public Date(String dateStr) {
		String[] dateParts = dateStr.split("/");
		this.year = Integer.parseInt(dateParts[0]);
		this.month = Integer.parseInt(dateParts[1]);
		this.day = Integer.parseInt(dateParts[2]);
		this.setWeekday();
	}
	
	/**
	 * Class copy constructor.
	 * 
	 * @param other	a Date object containing all desired attributes
	 */
	public Date(Date other) {
		this.year = other.year;
		this.month = other.month;
		this.day = other.day;
		this.setWeekday();
	}
	
	/**
	 * Overrides the default Object.toString() method.
	 * 
	 * @return	a String representation of the Date object
	 */
	public String toString() {
		return this.year + "/" + this.month + "/" + this.day;
	}
	
	/**
	 * Determines if a given Date object falls on a leap year.
	 * 
	 * @return	true or false, whether the date's year is a leap year
	 */
	public boolean isLeapYear() {
		if (this.year % 400 == 0) {
			return true;
		}
		else if (this.year % 100 == 0){
			return false;
		}
		else {
			return (this.year % 4 == 0);
		}
	}
	
	/**
	 * Determines if the Date object represents a valid time of day.
	 * 
	 * @return	true or false, whether the given date is valid
	 */
	public boolean isValid() {
		if (this.month < 1 || this.month > 12) {
			return false;
		}
		else if (this.day < 1) {
			return false;
		}
		else if (this.isLeapYear()) {
			return (MAX_DAYS_LEAP[this.month-1] >= this.day);
		}
		else {
			return (MAX_DAYS[this.month-1] >= this.day);
		}
	}
	
	/**
	 * Determines if two Date objects (this and other) represent the same thing.
	 * 
	 * @param other	another Date object in question
	 * @return		true or false, whether this and other are equivalent
	 */
	public boolean equals(Date other) {
		return (this.year == other.year) && (this.month == other.month) && (this.day == other.day);
	}
	
	/**
	 * Determines if one Date object occurs before another.
	 * 
	 * @param other	another Date object in question
	 * @return		true or false, whether this occurs before other
	 */
	public boolean before(Date other) {
		if (this.equals(other)) {
			return false;
		}
		else if (this.year == other.year) {
			if (this.month == other.month) {
				return this.day < other.day;
			}
			else {
				return this.month < other.month;
			}
		}
		else {
			return this.year < other.year;
		}
	}
	
	/**
	 * Determines if one Date object occurs after another.
	 * 
	 * @param other	another Date object in question
	 * @return		true or false, whether this occurs after other
	 */
	public boolean after(Date other) {
		if (this.equals(other)) {
			return false;
		}
		else {
			return !this.before(other);
		}
	}
	
	/**
	 * Calculates and returns a Date object representing one day later.
	 * 
	 * @return	the next day, as a Date object
	 */
	public Date nextDay() {
		Date nextDay = new Date(this.year, this.month, this.day+1);
		if (!nextDay.isValid()) {
			nextDay.month++;
			nextDay.day = 1;
			if (!nextDay.isValid()) {
				nextDay.year++;
				nextDay.month = 1;
			}
		}
		return nextDay;
	}
	
	/**
	 * Determines how many days before another a given Date is.
	 * 
	 * @param other	another Date object in question
	 * @return		an integer representation of the days between dates
	 */
	public int daysBefore(Date other) {
		Date copy = new Date(this);
		if (this.equals(other)) {
			return 0;
		}
		else if (this.after(other)) {
			return -1 * other.daysBefore(this);
		}
		else if (this.year == other.year){
			if (this.month == other.month) {
				return other.day - this.day;
			}
			else {
				int monthTotal = 0;
				while (copy.month < other.month) {
					if (copy.isLeapYear()) {
						monthTotal += MAX_DAYS_LEAP[copy.month-1];
					}
					else {
						monthTotal += MAX_DAYS[copy.month-1];
					}
					copy.month++;
				}
				return monthTotal + copy.daysBefore(other);
			}
		}
		else {
			int yearTotal = 0;
			while (copy.year < other.year) {
				if (copy.isLeapYear()) {
					yearTotal += LEAP_DAYS;
				}
				else {
					yearTotal += USUAL_DAYS;
				}
				copy.year++;
			}
			return yearTotal + copy.daysBefore(other);
		}
	}
	
	public static void main(String[] args) {
		Date d1 = new Date("1998/6/16");
		System.out.println(d1);
		Date d2 = new Date("2018/2/26");
		System.out.println(d2);
		System.out.println(d1.daysBefore(d2));
	}

}
