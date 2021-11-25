package model.customer;

import java.util.Date;

public class CustomerMember extends Customer {
	private String card;

	public CustomerMember() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerMember(int id, String tel, String dob, String gender, FullName fullname, Address address) {
		super(id, tel, dob, gender, fullname, address);
		// TODO Auto-generated constructor stub
	}

	public CustomerMember(String card) {
		this.card = card;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}
	
	
	
}
