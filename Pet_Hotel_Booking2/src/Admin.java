
public class Admin extends User {


	public Admin( String name, String username, String email, String password) {
		super(name, username, email, password);
		// TODO Auto-generated constructor stub
	}

	public Admin(int id, String name, String username, String email, String password, Address address, String type) {
		super(id, name, username, email, password, address, type);
		// TODO Auto-generated constructor stub
	}

	public Admin(){
	type = "Admin";
	}
	
	

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return "Inside Admin Page"; 
		
	}





}
