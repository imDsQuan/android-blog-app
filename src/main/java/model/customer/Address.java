package model.customer;

public class Address {
	private int id;
	private int homeNo;
	private String city;
	private String street;
	private String district;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int id, int homeNo, String city, String street, String district) {
		this.id = id;
		this.homeNo = homeNo;
		this.city = city;
		this.street = street;
		this.district = district;
	}

	public Address(int homeNo, String city, String street, String district) {
		this.homeNo = homeNo;
		this.city = city;
		this.street = street;
		this.district = district;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHomeNo() {
		return homeNo;
	}

	public void setHomeNo(int homeNo) {
		this.homeNo = homeNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

}
