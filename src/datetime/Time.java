package datetime;

public class Time {

	private int hour;
	private int minute;
	
	public static Time currentTime() {
		String timeStr = java.time.LocalTime.now().toString();
		return new Time(timeStr.substring(0, 5));
	}
	
	public Time(String timeStr) {
		String[] timeParts = timeStr.split(":");
		this.hour = Integer.parseInt(timeParts[0]);
		this.minute = Integer.parseInt(timeParts[1]);
	}
	
	public Time(int inHour, int inMinute) {
		this.hour = inHour;
		this.minute = inMinute;
	}
	
	public Time(Time other) {
		this.hour = other.hour;
		this.minute = other.minute;
	}
	
	public String toString() {
		return this.hour + ":" + this.minute;
	}
	
	public static void main(String[] args) {

	}

}
