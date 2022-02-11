
public class Cat implements Pet{

	private int cat_id;
	private String cat_name;
	private String cat_type;
	private boolean pet_description;
	
	public Cat(int cat_id, String cat_name, String cat_type, boolean pet_description) {	
		this.cat_id = cat_id;
		this.cat_name = cat_name;
		this.cat_type = cat_type;
		this.pet_description = pet_description;
	}

	@Override
	public int getPet_id() {
		// TODO Auto-generated method stub
		return cat_id;
	}

	@Override
	public void setPet_id(int pet_id) {
		this.cat_id=cat_id;
	}

	@Override
	public String getPet_name() {
		// TODO Auto-generated method stub
		return cat_name;
	}

	@Override
	public void setPet_name(String pet_name) {
		this.cat_name=cat_name;	
	}

	@Override
	public String getPet_type() {
		// TODO Auto-generated method stub
		return cat_type;
	}

	@Override
	public void setPet_type(String pet_type) {
		this.cat_type=cat_type;
		
	}

	@Override
	public boolean isPet_description() {
		return false;
	}

	@Override
	public void setPet_description(boolean pet_description) {
		this.pet_description=pet_description;
	}

	@Override
	public String Display() {
		return "Cat [cat_id=" + cat_id + ", cat_name=" + cat_name + ", cat_type=" + cat_type + ", pet_description="
				+ pet_description + "]";
	}
	
	
}
