package model.clothes;

public class Jacket extends Clothes {
	private int waterResistant;
	private int moistureWicking;
	private int pocketNumber;

	public Jacket() {
		super();
	}

	public Jacket(String id, String name, String description, String material, int discount, double price,
			String typeClothes, String brand) {
		super(id, name, description, material, discount, price, typeClothes, brand);
		// TODO Auto-generated constructor stub
	}

	public Jacket(int waterResistant, int moistureWicking, int pocketNumber) {
		this.waterResistant = waterResistant;
		this.moistureWicking = moistureWicking;
		this.pocketNumber = pocketNumber;
	}

	public int getWaterResistant() {
		return waterResistant;
	}

	public void setWaterResistant(int waterResistant) {
		this.waterResistant = waterResistant;
	}

	public int getMoistureWicking() {
		return moistureWicking;
	}

	public void setMoistureWicking(int moistureWicking) {
		this.moistureWicking = moistureWicking;
	}

	public int getPocketNumber() {
		return pocketNumber;
	}

	public void setPocketNumber(int pocketNumber) {
		this.pocketNumber = pocketNumber;
	}

}
