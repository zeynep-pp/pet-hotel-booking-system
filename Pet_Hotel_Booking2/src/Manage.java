import java.util.ArrayList;
import java.util.LinkedList;

public class Manage {
   
	public ArrayList<User> admins;
	public ArrayList<Hotel> hotels;
	public ArrayList<User> customers;
	
	public void addHotel(int id,String name,String type,String desc,int rating,String address, String town, String city,ArrayList<Room> rooms) {
		Address adress=new Address(address,town,city);
		Hotel hotel=new Hotel(id, name, type, desc, rating,adress,rooms);
		hotels.add(hotel);
	}
	public void updateHotel(int id,String name,String type,String desc,int rating,Address adress) {
		searchHotel(name).setHotel_description(desc);
		searchHotel(name).setHotel_type(type);
		searchHotel(name).setHotel_rating(rating);
	}
	public void addCustomer( String name, String username, String email, String password) {
		Customer customer=new Customer(name,username,email,password);
		customers.add(customer);
	}
	public void updateCustomer(int id, String name, String username, String email, String password) {
        searchCustomer(name).setUsername(username);
        searchCustomer(name).setPassword(password);
        searchCustomer(name).setEmail(email);
	}
	public Customer searchCustomer(String name) {
		for (int i = 0; i < customers.size(); i++) {
			if(customers.get(i).getName().equals(name))
				return (Customer) customers.get(i);	
		}
	    return (Customer) customers.get(0);
	}
	public Hotel searchHotel(String name) {
		for (int i = 0; i < hotels.size(); i++) {
			if(hotels.get(i).getHotel_name().equals(name))
				return hotels.get(i);	
		}
	    return hotels.get(0);
	}
	
	public void deleteCustomer(String name) {
		customers.remove(searchCustomer(name));
	}
	public void deleteHotel(String name) {
		hotels.remove(searchHotel(name));
	}
	public ArrayList<User> getAdmins() {
		return admins;
	}
	
	public void addAdmins() {
	    UserFactory userFactory = new UserFactory();
	    //get an object of Admin and call its draw method.
	    User user1 = userFactory.getUser("ADMIN");
	    admins.add((Admin) user1);		
	}
	public void addCustomers() {
	    UserFactory userFactory = new UserFactory();
	    //get an object of Customer and call its draw method.
	    User user = userFactory.getUser("CUSTOMER");
	    customers.add((Customer) user);		
	}
	
	public ArrayList<Hotel> getHotels() {
		return hotels;
	}
	public void setHotels(ArrayList<Hotel> hotels) {
		this.hotels = hotels;
	}
	public ArrayList<User> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<User> customers) {
		this.customers = customers;
	}
	

}
