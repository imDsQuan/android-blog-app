package model.clothes;

public class Shorts extends Clothes {
	private int breathable;
	private float inseam;
	private float outseam;
	public Shorts() {
	}
	public Shorts(int breathable, float inseam, float outseam) {
		this.breathable = breathable;
		this.inseam = inseam;
		this.outseam = outseam;
	}
	public Shorts(String id, String name, String description, String material, int discount, double price,
			String typeClothes, String brand) {
		super(id, name, description, material, discount, price, typeClothes, brand);
		// TODO Auto-generated constructor stub
	}
	public int getBreathable() {
		return breathable;
	}
	public void setBreathable(int breathable) {
		this.breathable = breathable;
	}
	public float getInseam() {
		return inseam;
	}
	public void setInseam(float inseam) {
		this.inseam = inseam;
	}
	public float getOutseam() {
		return outseam;
	}
	public void setOutseam(float outseam) {
		this.outseam = outseam;
	}
	
	
}
