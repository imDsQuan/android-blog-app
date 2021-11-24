package model.shoe;



public class Boot extends Shoe {
	
	private String leatherType; 
	private float shaftMeasure;
	private float heelHeightL;
	public Boot() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Boot(String id, String name, String description, String material, int discount, double price,
			String typeShoe, String brand, String warrantypeirod) {
		super(id, name, description, material, discount, price, typeShoe, brand, warrantypeirod );
		// TODO Auto-generated constructor stub
	}
	public String getLeatherType() {
		return leatherType;
	}
	public void setLeatherType(String leatherType) {
		this.leatherType = leatherType;
	}
	public float getShaftMeasure() {
		return shaftMeasure;
	}
	public void setShaftMeasure(float shaftMeasure) {
		this.shaftMeasure = shaftMeasure;
	}
	public float getHeelHeightL() {
		return heelHeightL;
	}
	public void setHeelHeightL(float heelHeightL) {
		this.heelHeightL = heelHeightL;
	}
	
	

}
