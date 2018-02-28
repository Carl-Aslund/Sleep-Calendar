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
	
	public boolean isValid() {
		return (this.minute<60 && this.minute>=0 && this.hour<24 && this.hour>=0);
	}
	
	public boolean equals(Time other) {
		return (this.minute == other.minute) && (this.hour == other.hour);
	}
	
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
	
	public boolean after(Time other) {
		if (this.equals(other)) {
			return false;
		}
		else {
			return !this.before(other);
		}
	}
	
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
	
	public Time timeBefore(Time other) {
		int mins = this.minsBefore(other);
		return new Time(mins/60, mins%60);
	}
	
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
