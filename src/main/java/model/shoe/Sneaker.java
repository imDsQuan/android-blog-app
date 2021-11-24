package model.shoe;



public class Sneaker extends Shoe {
	private int nightReflect;
	private String type;
	private int shockAbsord;
	
	public Sneaker() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Sneaker(String id, String name, String description, String material, int discount, double price,
			String typeShoe, String brand, String warrantypeirod) {
		super(id, name, description, material, discount, price, typeShoe, brand,warrantypeirod);
		// TODO Auto-generated constructor stub
	}


	public Sneaker(int nightReflect, String type, int shockAbsord) {
		super();
		this.nightReflect = nightReflect;
		this.type = type;
		this.shockAbsord = shockAbsord;
	}

	public int getNightReflect() {
		return nightReflect;
	}

	public void setNightReflect(int nightReflect) {
		this.nightReflect = nightReflect;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getShockAbsord() {
		return shockAbsord;
	}

	public void setShockAbsord(int shockAbsord) {
		this.shockAbsord = shockAbsord;
	}
	
	
	
	

}
