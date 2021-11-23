package model.customer;

import java.util.Date;

public class Customer {
	private int id;
	private String tel;
	private Date dob;
	private String gender;
	private FullName fullname;
	private Address address;
	private Account account;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String tel, Date dob, String gender) {
		this.tel = tel;
		this.dob = dob;
		this.gender = gender;
	}

	public Customer(int id, String tel, Date dob, String gender, FullName fullname, Address address) {
		this.id = id;
		this.tel = tel;
		this.dob = dob;
		this.gender = gender;
		this.fullname = fullname;
		this.address = address;
	}

	public Customer(String tel, Date dob, String gender, FullName fullname, Address address) {
		this.tel = tel;
		this.dob = dob;
		this.gender = gender;
		this.fullname = fullname;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public FullName getFullname() {
		return fullname;
	}

	public void setFullname(FullName fullname) {
		this.fullname = fullname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
