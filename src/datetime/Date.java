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
	
	public static void main(String[] args) {
		Date d1 = new Date(2018, 2, 25);
		System.out.println(d1);
		String s1 = d1.toString();
		Date d2 = new Date(s1);
		System.out.println(d2);
	}

}
