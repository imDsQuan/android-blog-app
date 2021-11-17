package model.clothes;

public class Pants extends Clothes{
	private float waist;
	private float upperThigh;
	private float legOpening;
	private float inseam;
	public Pants() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pants(String id, String name, String description, String material, int discount, double price,
			String typeClothes, String brand) {
		super(id, name, description, material, discount, price, typeClothes, brand);
		// TODO Auto-generated constructor stub
	}
	public Pants(float waist, float upperThigh, float legOpening, float inseam) {
		this.waist = waist;
		this.upperThigh = upperThigh;
		this.legOpening = legOpening;
		this.inseam = inseam;
	}
	public float getWaist() {
		return waist;
	}
	public void setWaist(float waist) {
		this.waist = waist;
	}
	public float getUpperThigh() {
		return upperThigh;
	}
	public void setUpperThigh(float upperThigh) {
		this.upperThigh = upperThigh;
	}
	public float getLegOpening() {
		return legOpening;
	}
	public void setLegOpening(float legOpening) {
		this.legOpening = legOpening;
	}
	public float getInseam() {
		return inseam;
	}
	public void setInseam(float inseam) {
		this.inseam = inseam;
	}
	
	
	
	
}
