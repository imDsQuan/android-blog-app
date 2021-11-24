package model.shoe;


import java.util.ArrayList;
import java.util.List;


public class Shoe {
	
	private String id;
	private String name;
	private String description;
	private String material;
	private int discount;
	private double price;
	private String typeShoe;
	private String brand;
	private String warrantlyperiod;
	private String size;
	private int amount;
	List<String> image = new ArrayList<>();
	List<String> color = new ArrayList<>();
	
	public Shoe() {
		super();
	}
	public Shoe(String id, String name, String description, String material, int discount, double price,
			String typeShoe, String brand, String warrantlyperiod ) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.material = material;
		this.discount = discount;
		this.price = price;
		this.typeShoe = typeShoe;
		this.brand = brand;
		this.warrantlyperiod = warrantlyperiod;
		
	}
	
	public Shoe(String name, String description, String material, int discount, double price, String typeShoe,
			String brand, String warrantlyperiod) {
		super();
		this.name = name;
		this.description = description;
		this.material = material;
		this.discount = discount;
		this.price = price;
		this.typeShoe = typeShoe;
		this.brand = brand;
		this.warrantlyperiod = warrantlyperiod;
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
	public String getTypeShoe() {
		return typeShoe;
	}
	public void setTypeShoe(String typeShoe) {
		this.typeShoe = typeShoe;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getWarrantlyperiod() {
		return warrantlyperiod;
	}
	public void setWarrantlyperiod(String warrantlyperiod) {
		this.warrantlyperiod = warrantlyperiod;
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
