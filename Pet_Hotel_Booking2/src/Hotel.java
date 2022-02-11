import java.util.ArrayList;

public class Hotel implements Comparable<Hotel> {
	private int hotel_id;
	private String hotel_name;
	private String hotel_type;
	private String hotel_description;
	private int hotel_rating;
	private Address hotel_address;
	private ArrayList<Room> rooms;
	public Hotel(int hotel_id, String hotel_name, String hotel_type, String hotel_description, int hotel_rating,Address hotel_address, ArrayList<Room> rooms) {
		super();
		this.hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		this.hotel_type = hotel_type;
		this.hotel_description = hotel_description;
		this.hotel_rating = hotel_rating;
		this.hotel_address = hotel_address;
		this.rooms = rooms;
	}


	public Hotel(int hotel_id, String hotel_name, String hotel_type, String hotel_description, int hotel_rating,
			Address hotel_address) {
		super();
		this.hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		this.hotel_type = hotel_type;
		this.hotel_description = hotel_description;
		this.hotel_rating = hotel_rating;
		this.hotel_address = hotel_address;
	}


	public Hotel(int hotel_id, String hotel_name, String hotel_type, String hotel_description, int hotel_rating,
			ArrayList<Room> rooms) {
		super();
		this.hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		this.hotel_type = hotel_type;
		this.hotel_description = hotel_description;
		this.hotel_rating = hotel_rating;
		this.rooms = rooms;
	}


	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getHotel_type() {
		return hotel_type;
	}
	public void setHotel_type(String hotel_type) {
		this.hotel_type = hotel_type;
	}
	public String getHotel_description() {
		return hotel_description;
	}
	public void setHotel_description(String hotel_description) {
		this.hotel_description = hotel_description;
	}
	public int getHotel_rating() {
		return hotel_rating;
	}
	public void setHotel_rating(int hotel_rating) {
		this.hotel_rating = hotel_rating;
	}
	public Address getHotel_address() {
		return hotel_address;
	}
	public void setHotel_address(Address hotel_address) {
		this.hotel_address = hotel_address;
	}
	
	@Override
	public String toString() {
		return "Hotel [hotel_id=" + hotel_id + ", hotel_name=" + hotel_name + ", hotel_type=" + hotel_type
				+ ", hotel_description=" + hotel_description + ", hotel_rating=" + hotel_rating + ", hotel_address="
				+ hotel_address + ", rooms=" + rooms + "]";
	}
	
	@Override
	public int compareTo(Hotel o) {
		
		if(this.hotel_rating == o.hotel_rating) return 0;
		else if(this.hotel_rating > o.hotel_rating) return 1;
		else return -1;
	}
	
	public void addRoom(int room_id, int room_hotel_id, int room_price, String room_type, String room_description, String day,String month,String year,boolean isAvailable) {
		Date date=new Date(day, month, year, isAvailable);
		Room room=new Room(room_id, room_hotel_id, room_price, room_type,room_description, date );
		rooms.add(room);
	}
	public void updateRoom(int room_id, int room_hotel_id, int room_price, String room_type, String room_description, String day,String month,String year,boolean isAvailable) {
		searchRoom(room_id).setRoom_description(room_description);
		searchRoom(room_id).setRoom_type(room_type);
		searchRoom(room_id).setRoom_price(room_price);
		searchRoom(room_id).getDate().setDay(day);
		searchRoom(room_id).getDate().setMonth(month);
		searchRoom(room_id).getDate().setYear(year);
		searchRoom(room_id).getDate().setAvailable(isAvailable);
	}
	public Room searchRoom(int room_id) {
		for (int i = 0; i < rooms.size(); i++) {
			if(rooms.get(i).getRoom_id()==room_id)
				return rooms.get(i);	
		}
	    return rooms.get(0);
	}
	public void deleteRoom(int room_id) {
		rooms.remove(searchRoom(room_id));
	}
    

	public ArrayList<Room> getRooms() {
		return rooms;
	}


	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	
	public String printRooms() {
         String str = null;
        // Print the room from the list....
        for(Room room : rooms) {
        	str+=room.toString();
           // System.out.println(room.toString());
        }

        // Or like this...
       // for(int i = 0; i < rooms.size(); i++) {
            //System.out.println(rooms.get(i).toString());
        //}
        return str;
	}

	
}
