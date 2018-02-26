package datetime;

public class Date {

	private static int[] MAX_DAYS_LEAP = {31,28,31,30,31,30,31,31,30,31,30,31};
	private static int[] MAX_DAYS = {31,29,31,30,31,30,31,31,30,31,30,31};
	
	private int year;
	private int month;
	private int day;
	
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
	
	public void setDate(int inYear, int inMonth, int inDay) {
		this.year = inYear;
		this.month = inMonth;
		this.day = inDay;
	}
	
	public void setDate(String dateStr) {
		String[] dateParts = dateStr.split("/");
		this.year = Integer.parseInt(dateParts[0]);
		this.month = Integer.parseInt(dateParts[1]);
		this.day = Integer.parseInt(dateParts[2]);
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
	
	public static void main(String[] args) {
		Date d1 = new Date(2018, 2, 25);
		System.out.println(d1);
		Date d2 = new Date("2018/2/26");
		System.out.println(d2);
		Date d3 = d1.nextDay();
		System.out.println(d3);
		Date d4 = d3.nextDay();
		System.out.println(d4);
		System.out.println(d1.before(d2));
		System.out.println(d4.after(d2));
		System.out.println(d4.before(d2));
		System.out.println(d2.equals(d3));
	}

}
