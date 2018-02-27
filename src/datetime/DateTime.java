package datetime;

public class DateTime {

	private Date date;
	private Time time;
	
	public static DateTime currentDateTime() {
		return new DateTime(Date.currentDate(), Time.currentTime());
	}
	
	public DateTime(Date inDate, Time inTime) {
		this.date = inDate;
		this.time = inTime;
	}
	
	public DateTime(String dateTimeStr) {
		String[] dateTimeParts = dateTimeStr.split(" ");
		this.date = new Date(dateTimeParts[0]);
		this.time = new Time(dateTimeParts[1]);
	}
	
	public DateTime(DateTime other) {
		this.date = new Date(other.date);
		this.time = new Time(other.time);
	}
	
	public String toString() {
		return this.date.toString() + " " + this.time.toString();
	}
	
	public static void main(String[] args) { 
		System.out.println(currentDateTime());
	}

}
