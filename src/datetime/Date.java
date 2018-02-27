package datetime;

public class Date {

	private static final int[] MAX_DAYS = {31,28,31,30,31,30,31,31,30,31,30,31};
	private static final int[] MAX_DAYS_LEAP = {31,29,31,30,31,30,31,31,30,31,30,31};
	
	private static final int USUAL_DAYS = 365;
	private static final int LEAP_DAYS = 366;
	
	private int year;
	private int month;
	private int day;
	
	public static Date currentDate() {
		String dateStr = java.time.LocalDate.now().toString();
		dateStr = dateStr.replaceAll("-", "/");
		return new Date(dateStr);
	}
	
	public Date(int inYear, int inMonth, int inDay) {
		this.year = inYear;
		this.month = inMonth;
		this.day = inDay;
	}
	
	public Date(String dateStr) {
		String[] dateParts = dateStr.split("/");
		this.year = Integer.parseInt(dateParts[0]);
		this.month = Integer.parseInt(dateParts[1]);
		this.day = Integer.parseInt(dateParts[2]);
	}
	
	public Date(Date other) {
		this.year = other.year;
		this.month = other.month;
		this.day = other.day;
	}
	
	public String toString() {
		return this.year + "/" + this.month + "/" + this.day;
	}
	
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
	
	public boolean equals(Date other) {
		return (this.year == other.year) && (this.month == other.month) && (this.day == other.day);
	}
	
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
	
	public boolean after(Date other) {
		if (this.equals(other)) {
			return false;
		}
		else {
			return !this.before(other);
		}
	}
	
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
