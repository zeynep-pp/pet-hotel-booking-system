
public class FactoryPatternDemo {
	
	public static void main(String[] args) {
		UserFactory userFactory = new UserFactory();
		//get an object of Circle and call its draw method.
		User user1 = userFactory.getUser("ADMIN");
		//call draw method of Circle
		user1.print();
		//get an object of Rectangle and call its draw method.
		User user2 = userFactory.getUser("CUSTOMER");

		//call draw method of Rectangle
		user2.print();

	}
}
