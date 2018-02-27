package datetime;

public class DateTime {

	private Date date;
	private int hour;
	private int minute;
	
	public static DateTime currentDateTime() {
		String timeStr = java.time.LocalTime.now().toString();
		return new DateTime(Date.currentDate(), timeStr);
	}
	
	public DateTime(Date inDate, int inHour, int inMinute) {
		this.date = inDate;
		this.hour = inHour;
		this.minute = inMinute;
	}
	
	public DateTime(int inYear, int inMonth, int inDay, int inHour, int inMinute) {
		this.date = new Date(inYear, inMonth, inDay);
		this.hour = inHour;
		this.minute = inMinute;
	}
	
	public DateTime(String dateStr, int inHour, int inMinute) {
		this.date = new Date(dateStr);
		this.hour = inHour;
		this.minute = inMinute;
	}
	
	public DateTime(String dateTimeStr) {
		String[] dateTimeParts = dateTimeStr.split(" ");
		this.date = new Date(dateTimeParts[0]);
		String[] timeParts = dateTimeParts[0].split(":");
		this.hour = Integer.parseInt(timeParts[0]);
		this.minute = Integer.parseInt(timeParts[1]);
	}
	
	public DateTime(String dateStr, String timeStr) {
		this.date = new Date(dateStr);
		String[] timeParts = timeStr.split(":");
		this.hour = Integer.parseInt(timeParts[0]);
		this.minute = Integer.parseInt(timeParts[1]);
	}
	
	public DateTime(Date inDate, String timeStr) {
		this.date = inDate;
		String[] timeParts = timeStr.split(":");
		this.hour = Integer.parseInt(timeParts[0]);
		this.minute = Integer.parseInt(timeParts[1]);
	}
	
	public String toString() {
		return this.date.toString() + " " + this.hour + ":" + this.minute;
	}
	
	public static void main(String[] args) { 
		System.out.println(java.time.LocalTime.now().toString());
	}

}
