import java.util.ArrayList;

public class Room implements Comparable<Room> {
	//create an object of SingleObject
	private static Room instance = new Room();
	
	//make the constructor private so that this class cannot be
	//instantiated
	private Room() {}
	
	//Get the only object available
	public static Room getInstance(){
	return instance;
	}
	public String showMessage(){
	return "Welcome Room!";
	}
	
	private int room_id;
	private int room_hotel_id;
	private int room_price;
	private String room_type;
	private String room_description;
	private Date date;
	public Room(int room_id, int room_hotel_id, int room_price, String room_type, String room_description, Date date) {
		super();
		this.room_id = room_id;
		this.room_hotel_id = room_hotel_id;
		this.room_price = room_price;
		this.room_type = room_type;
		this.room_description = room_description;
		this.date = date;
	}
	
	public Room(int room_id, int room_hotel_id, int room_price, String room_type, String room_description) {
		super();
		this.room_id = room_id;
		this.room_hotel_id = room_hotel_id;
		this.room_price = room_price;
		this.room_type = room_type;
		this.room_description = room_description;
	}





	public Room(int room_id) {
		super();
		this.room_id = room_id;
	}

	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public int getRoom_hotel_id() {
		return room_hotel_id;
	}
	public void setRoom_hotel_id(int room_hotel_id) {
		this.room_hotel_id = room_hotel_id;
	}
	public int getRoom_price() {
		return room_price;
	}
	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public String getRoom_description() {
		return room_description;
	}
	public void setRoom_description(String room_description) {
		this.room_description = room_description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	


	@Override
	public String toString() {
		return "Room [room_id=" + room_id + ", room_hotel_id=" + room_hotel_id + ", room_price=" + room_price
				+ ", room_type=" + room_type + ", room_description=" + room_description + ", date=" + date + "]";
	}
	
	@Override
	public int compareTo(Room o) {
		
		if(this.room_price == o.room_price) return 0;
		else if(this.room_price > o.room_price) return 1;
		else return -1;
	}
	public Object[] strArray() {
		 Object[] row = new Object[4];
		 row[0]=room_id;
		 row[1]=room_hotel_id;
		 row[2]=room_price;
	return row;
	}


}
