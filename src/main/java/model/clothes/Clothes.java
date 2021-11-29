package model.clothes;

import java.util.ArrayList;
import java.util.List;

public class Clothes {
	private String id;
	private String name;
	private String description;
	private String material;
	private int discount;
	private double price;
	private String typeClothes;
	private String brand;
	List<String> image = new ArrayList<>();
	List<String> color = new ArrayList<>();
	
	public Clothes() {
		super();
	}

	public Clothes(String id, String name, String description, String material, int discount, double price,
			String typeClothes, String brand) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.material = material;
		this.discount = discount;
		this.price = price;
		this.typeClothes = typeClothes;
		this.brand = brand;
	}
	
	public Clothes(String name, String description, String material, int discount, double price,
			String typeClothes, String brand) {
		super();
		this.name = name;
		this.description = description;
		this.material = material;
		this.discount = discount;
		this.price = price;
		this.typeClothes = typeClothes;
		this.brand = brand;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTypeClothes() {
		return typeClothes;
	}

	public void setTypeClothes(String typeClothes) {
		this.typeClothes = typeClothes;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public List<String> getImage() {
		return image;
	}

	public void setImage(List<String> image) {
		this.image = image;
	}

	public List<String> getColor() {
		return color;
	}

	public void setColor(List<String> color) {
		this.color = color;
	}

	
	
	
}
