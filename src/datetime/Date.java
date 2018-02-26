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
	
	public static void main(String[] args) {
		Date d1 = new Date(2018, 2, 25);
		System.out.println(d1);
		String s1 = d1.toString();
		Date d2 = new Date(s1);
		System.out.println(d2);
	}

}
