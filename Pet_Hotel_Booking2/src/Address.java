
public class Address {
	private	String address;
	private String town;
	private String city;
	public Address(String address, String town, String city) {
		super();
		this.address = address;
		this.town = town;
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public String getTown() {
		return town;
	}
	public String getCity() {
		return city;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [address=" + address + ", town=" + town + ", city=" + city + "]";
	}
	
}
