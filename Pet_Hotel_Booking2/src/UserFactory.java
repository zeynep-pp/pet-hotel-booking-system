public class UserFactory {
//use getUser method to get object of type user
	public User getUser(String userType){
		if(userType == null){
		return null;
		}
		if(userType.equalsIgnoreCase("ADMIN")){
		return new Admin();
		} else if(userType.equalsIgnoreCase("CUSTOMER")){
		return new Customer();
		} 
	return null;
	}
}
