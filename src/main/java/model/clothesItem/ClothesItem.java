package model.clothesItem;

import model.clothes.Clothes;

public class ClothesItem {
	private String size;
	private double price;
	private int amount;
	private int discount;
	private Clothes clothes;

	public ClothesItem() {
	}

	public ClothesItem(String size, double price, int amount, int discount, Clothes clothes) {
		this.size = size;
		this.price = price;
		this.amount = amount;
		this.discount = discount;
		this.clothes = clothes;
	}


	public String getSize() {
		return size;
	}

	public void setSize(String size) {
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
