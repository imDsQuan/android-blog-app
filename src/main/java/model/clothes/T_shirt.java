package model.clothes;

public class T_shirt extends Clothes {
	private int moistureWicking;
	private int tapedNeck;
	private float sleeveHem;

	public T_shirt() {

	}

	public T_shirt(int moistureWicking, int tapedNeck, float sleeveHem) {
		this.moistureWicking = moistureWicking;
		this.tapedNeck = tapedNeck;
		this.sleeveHem = sleeveHem;
	}

	public T_shirt(String id, String name, String description, String material, int discount, double price,
			String typeClothes, String brand) {
		super(id, name, description, material, discount, price, typeClothes, brand);
		// TODO Auto-generated constructor stub
	}

	public int getMoistureWicking() {
		return moistureWicking;
	}

	public void setMoistureWicking(int moistureWicking) {
		this.moistureWicking = moistureWicking;
	}

	public int getTapedNeck() {
		return tapedNeck;
	}

	public void setTapedNeck(int tapedNeck) {
		this.tapedNeck = tapedNeck;
	}

	public float getSleeveHem() {
		return sleeveHem;
	}

	public void setSleeveHem(float sleeveHem) {
		this.sleeveHem = sleeveHem;
	}

}
