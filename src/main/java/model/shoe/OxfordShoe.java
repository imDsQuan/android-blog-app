package model.shoe;



public class OxfordShoe extends Shoe {
	private float heelHeight;
	private float heelMeasure;
	private String leatherType;
	
	public OxfordShoe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OxfordShoe(String id, String name, String description, String material, int discount, double price,
			String typeShoe, String brand, String warrantypeirod) {
		super(id, name, description, material, discount, price, typeShoe, brand, warrantypeirod);
		// TODO Auto-generated constructor stub
	}

	public float getHeelHeight() {
		return heelHeight;
	}

	public void setHeelHeight(float heelHeight) {
		this.heelHeight = heelHeight;
	}

	public float getHeelMeasure() {
		return heelMeasure;
	}

	public void setHeelMeasure(float heelMeasure) {
		this.heelMeasure = heelMeasure;
	}

	public String getLeatherType() {
		return leatherType;
	}

	public void setLeatherType(String leatherType) {
		this.leatherType = leatherType;
	}
	
	
	

}
