
public class Dog implements Pet {
	private int dog_id;
	private String dog_name;
	private String dog_type;
	private boolean pet_description;
	
	public Dog(int dog_id, String dog_name, String dog_type, boolean pet_description) {	
		this.dog_id = dog_id;
		this.dog_name = dog_name;
		this.dog_type = dog_type;
		this.pet_description = pet_description;
	}

	@Override
	public int getPet_id() {
		// TODO Auto-generated method stub
		return dog_id;
	}

	@Override
	public void setPet_id(int pet_id) {
		this.dog_id=dog_id;
	}

	@Override
	public String getPet_name() {
		// TODO Auto-generated method stub
		return dog_name;
	}

	@Override
	public void setPet_name(String pet_name) {
		this.dog_name=dog_name;	
	}

	@Override
	public String getPet_type() {
		// TODO Auto-generated method stub
		return dog_type;
	}

	@Override
	public void setPet_type(String pet_type) {
		this.dog_type=dog_type;
		
	}

	@Override
	public boolean isPet_description() {
		return true;
	}

	@Override
	public void setPet_description(boolean pet_description) {
		this.pet_description=pet_description;
	}

	@Override
	public String Display() {
		return "Dog [dog_id=" + dog_id + ", dog_name=" + dog_name + ", dog_type=" + dog_type + ", pet_description="
				+ pet_description + "]";
		
	}}
