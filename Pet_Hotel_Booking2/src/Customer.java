import java.util.ArrayList;

public class Customer extends User {

	public Customer(String name, String username, String email, String password) {
		super(name, username, email, password);
		// TODO Auto-generated constructor stub
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pet pet;
	public ArrayList<Booking> bookings= new ArrayList<Booking>();	

	
	
	@Override
	public String print() {
		// TODO Auto-generated method stub
		return "Inside Customer Page"; 
		
	}
	
	public void addBooking( String duration,Customer customer,Room room) {
		Booking booking=new Booking(duration,customer,room);
		bookings.add(booking);
	}
	public void deleteBooking(Room room) {
		bookings.remove(searchBooking(room));
	}
	
	public void updateBooking(String duration,Customer customer,Room room) {
		Booking booking=new Booking(duration,customer,room);
		searchBooking(room).setDuration(duration);
	}
	public Booking searchBooking(Room rm) {
		for (int i = 0; i < bookings.size(); i++) {
			if(bookings.get(i).room.equals(rm))
				return bookings.get(i);	
		}
	    return bookings.get(0);
	}
	@Override
	public String toString() {
		return "Customer [pet=" + pet + ", bookings=" + bookings + ", getName()=" + getName()
				+ ", getUsername()=" + getUsername() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
				+ ", getAddress()=" + getAddress() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	public ArrayList<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}


	

}
