
public abstract class User implements Cloneable {
	private int id;
	private String name;
	private String username;
	private String email;
	private String password;
	private Address address;	
	protected String type;
	public User(String name, String username, String email, String password) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public User(int id) {
		super();
		this.id = id;
	}

	public User(int id, String name, String username, String email, String password, Address address, String type) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
		this.type = type;
	}

	abstract String print();
	public User() {
		super();
	}

	public User( String name, String username, String email, String password, Address address) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", type=" + type + "]";
	}

	public Object clone() {
		Object clone = null;
		try {
		clone = super.clone();
		} catch (CloneNotSupportedException e) {
		e.printStackTrace();
		}
		return clone;
		}
	
}
