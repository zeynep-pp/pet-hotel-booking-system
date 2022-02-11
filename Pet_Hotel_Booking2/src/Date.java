
public class Date {
    public String day;
    public String month;
    public String year;
    public boolean isAvailable;
	public Date(String day, String month, String year, boolean isAvailable) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
		this.isAvailable = isAvailable;
	}
	public String getDay() {
		return day;
	}
	public String getMonth() {
		return month;
	}
	public String getYear() {
		return year;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + ", isAvailable=" + isAvailable + "]";
	}
    
    
}
