package model.clothesItem;

import model.clothes.Clothes;

public class ClothesItem {
	private int barcode;
	private String color;
	private int size;
	private double price;
	private int amount;
	private int discount;
	private Clothes clothes;

	public ClothesItem() {
	}

	public ClothesItem(int barcode, String color, int size, double price, int amount, int discount, Clothes clothes) {
		this.barcode = barcode;
		this.color = color;
		this.size = size;
		this.price = price;
		this.amount = amount;
		this.discount = discount;
		this.clothes = clothes;
	}

	public int getBarcode() {
		return barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Clothes getClothes() {
		return clothes;
	}

	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}

}
