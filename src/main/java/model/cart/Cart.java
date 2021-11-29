package model.cart;

import java.sql.SQLException;
import java.util.*;

import controller.clothesDAO.ClothesDAOImpl;
import model.clothes.Clothes;
import model.clothesItem.ClothesItem;
import model.shoe.Shoe;
import controller.shoeDAO.ShoeDAOImpl;

public class Cart {
	private List<ClothesItem> clothesCart = new ArrayList<>();
	private List<Clothes> booksCart = new ArrayList<>();
	private List<Clothes> electionicCart = new ArrayList<>();
	private List<Shoe> shoeCart = new ArrayList<>();
	
	private double total;
	private int amount;
	
	public Cart() {
	}

	public List<ClothesItem> getClothesCart() {
		return clothesCart;
	}

	public void setClothesCart(List<ClothesItem> clothesCart) {
		this.clothesCart = clothesCart;
	}

	public List<Clothes> getBooksCart() {
		return booksCart;
	}

	public void setBooksCart(List<Clothes> booksCart) {
		this.booksCart = booksCart;
	}

	public List<Clothes> getElectionicCart() {
		return electionicCart;
	}

	public void setElectionicCart(List<Clothes> electionicCart) {
		this.electionicCart = electionicCart;
	}

	public List<Shoe> getShoeCart() {
		return shoeCart;
	}

	public void setShoeCart(List<Shoe> shoeCart) {
		this.shoeCart = shoeCart;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void addClothesToCart(ClothesItem clothes) {
		int c = 0;
		for (int i = 0; i < clothesCart.size(); i++) {
			if (clothesCart.get(i).getClothes().getId().equals(clothes.getClothes().getId()) && clothesCart.get(i).getSize().equals(clothes.getSize())) {
				clothesCart.get(i).setAmount(clothesCart.get(i).getAmount() + clothes.getAmount());
				c = 1;
			}
		}
		if (c == 0)
			clothesCart.add(clothes);
	}
	
	public void addShoeToCart(Shoe shoe) {
		int c = 0;
		for (int i = 0; i < shoeCart.size(); i++) {
			if (shoeCart.get(i).getId().equals(shoe.getId())) {
				shoeCart.get(i).setAmount(shoeCart.get(i).getAmount() + shoe.getAmount());
				c = 1;
			}
		}
		if (c == 0)
			shoeCart.add(shoe);
	}

	public ClothesItem getClothesItem(int i) {
		if (i < 0 || i > clothesCart.size() - 1)
			return null;
		else
			return clothesCart.get(i);
	}
	
	public Shoe getShoeItem(int i) {
		if (i < 0 || i > shoeCart.size() - 1)
			return null;
		else
			return shoeCart.get(i);
	}

	public boolean delClothesItem(String id, String size) throws ClassNotFoundException, SQLException {
		ClothesDAOImpl dao = new ClothesDAOImpl();
		Clothes clothes = dao.getClothByCode(id);
		for (int i = 0; i < clothesCart.size(); i++) {
			if (clothesCart.get(i).getClothes().getId().equals(id) && clothesCart.get(i).getSize().equals(size)) {
				clothesCart.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean delShoeItem(String id) throws ClassNotFoundException, SQLException {
		ShoeDAOImpl dao = new ShoeDAOImpl();
		Shoe shoe = dao.getShoeByCode(id);
		for (int i = 0; i < shoeCart.size(); i++) {
			if (shoeCart.get(i).getId().equals(shoe.getId())) {
				shoeCart.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean addQuantityClothesItem(String id, String size) {
		for (int i = 0; i < clothesCart.size(); i++) {
			if (clothesCart.get(i).getClothes().getId().equals(id) && clothesCart.get(i).getSize().equals(size)) {
				System.out.println("Already Add");
				clothesCart.get(i).setAmount(clothesCart.get(i).getAmount() + 1);
				return true;
			}
			System.out.println("No Add");
		}
		return false;
	}
	
	public boolean addQuantityShoe(String id) {
		for (int i = 0; i < shoeCart.size(); i++) {
			if (shoeCart.get(i).getId().equals(id)) {
				shoeCart.get(i).setAmount(shoeCart.get(i).getAmount() + 1);
				return true;
			}
		}
		return false;
	}

	public boolean subQuantityClothesItem(String id, String size) {
		for (int i = 0; i < clothesCart.size(); i++) {
			if (clothesCart.get(i).getClothes().getId().equals(id) && clothesCart.get(i).getSize().equals(size)) {
				if (clothesCart.get(i).getAmount() == 1) {
					clothesCart.remove(i);
					return true;
				} else {
					clothesCart.get(i).setAmount(clothesCart.get(i).getAmount() - 1);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean subQuantityShoe(String id) {
		for (int i = 0; i < shoeCart.size(); i++) {
			if (shoeCart.get(i).getId().equals(id)) {
				if (shoeCart.get(i).getAmount() == 1) {
					shoeCart.remove(i);
					return true;
				} else {
					shoeCart.get(i).setAmount(shoeCart.get(i).getAmount() - 1);
					return true;
				}
			}
		}
		return false;
	}


	public int numberOfClothes() {
		return clothesCart.size();
	}
	
	public int numberOfShoe() {
		return shoeCart.size();
	}

	public double totalMoney() {
		double moneyClothes = 0d;
		double moneyBook = 0d;
		double moneyElectronic = 0d;
		double moneyShoe = 0d;
		for (ClothesItem bk : clothesCart)
			moneyClothes += (bk.getPrice() * bk.getAmount());
		
//		for (Book bk : booksCart)
//			moneyClothes += (bk.getPrice() * bk.getAmount());
		for (Shoe bk : shoeCart)
			moneyShoe += (bk.getPrice() * bk.getAmount());
//		for (Clothes bk : clothesCart)
//			moneyClothes += (bk.getPrice() * bk.getAmount());
		this.setTotal(moneyClothes + moneyBook + moneyElectronic + moneyShoe);
		return moneyClothes + moneyBook + moneyElectronic + moneyShoe;
	}
	

}
