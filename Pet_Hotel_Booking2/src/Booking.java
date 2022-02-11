import java.util.ArrayList;

public class Booking {
	private String duration;
	private String customer_name;
    UserFactory userFactory = new UserFactory();
    //get an object of Customer and call its draw method.
    User user = userFactory.getUser("CUSTOMER");
	public Room room;
	
	public Booking( String duration,User user, Room room) {
		super();
		this.duration = duration;
		this.user = user;
		this.room = room;
	}

	public Booking(String duration, String customer_name, Room room) {
		super();
		this.duration = duration;
		this.customer_name = customer_name;
		this.room = room;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Booking [ duration=" + duration + ", customer=" + user + ", room="
				+ room + "]";
	}
	public User getCustomer() {
		return user;
	}
	public void setCustomer(Customer customer) {
		this.user = customer;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	
	

	
}
