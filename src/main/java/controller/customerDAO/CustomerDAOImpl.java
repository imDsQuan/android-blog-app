package controller.customerDAO;

import java.sql.Connection;
import java.util.Date;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import controller.accountDAO.AccountDAOImpl;
import model.customer.Account;
import model.customer.Address;
import model.customer.Customer;
import model.customer.FullName;
import util.MySQLConnUtils;

public class CustomerDAOImpl {

	public CustomerDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	protected Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection connection = MySQLConnUtils.getMySQLConnection();
		return connection;
	}
	
	public void insertCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		String query = "INSERT INTO customer" + " (tel, dob, gender)" + " VALUES (?,?,?);";
		Connection con = getConnection();
		PreparedStatement pre = con.prepareStatement(query);
		System.out.println(customer.getGender());
		System.out.println(customer.getTel());
		System.out.println(customer.getDob());

		pre.setString(1, customer.getGender());
		pre.setString(2, customer.getDob());
		pre.setString(3, customer.getGender());
		pre.executeUpdate();
		System.out.println(query);

	}
	
	public void insertAccount(int customerID, Account account) throws SQLException, ClassNotFoundException {
		String query = "INSERT INTO account" + " (customerID, username, password)" + " VALUES (?,?,?);";
		Connection con = getConnection();
		PreparedStatement pre = con.prepareStatement(query);
		pre.setInt(1, customerID);
		pre.setString(2, account.getUsername());
		pre.setString(3, account.getPassword());
		pre.executeUpdate();
		System.out.println(query);

	}
	
	public void insertFullName(int customerID, FullName fullname) throws SQLException, ClassNotFoundException {
		String query = "INSERT INTO fullname" + " (customerID, firstname, lastname)" + " VALUES (?,?,?);";
		Connection con = getConnection();
		PreparedStatement pre = con.prepareStatement(query);
		pre.setInt(1, customerID);
		pre.setString(2, fullname.getFirstName());
		pre.setString(3, fullname.getLastName());
		pre.executeUpdate();
		System.out.println(query);

	}
	
	
	public void insertAddress(int customerID, Address address) throws SQLException, ClassNotFoundException {
		String query = "INSERT INTO address" + " (customerID, homeNo, street, city, district)" + " VALUES (?,?,?,?,?);";
		Connection con = getConnection();
		PreparedStatement pre = con.prepareStatement(query);
		pre.setInt(1, customerID);
		pre.setInt(2, address.getHomeNo());
		pre.setString(3, address.getStreet());
		pre.setString(4, address.getCity());
		pre.setString(5, address.getDistrict());
		pre.executeUpdate();
		System.out.println(query);

	}
	
	public Customer getCustomerByID(int customerID) throws ClassNotFoundException, SQLException {
		String query = "select * from customer where id = ?;";
		Connection con = getConnection();
		PreparedStatement pre = con.prepareStatement(query);
		pre.setInt(1, customerID);
		ResultSet rs = pre.executeQuery();
		Customer cus = null;
		while(rs.next()) {
			int id = rs.getInt("id");
			String tel = rs.getString("Tel");
			String dob = rs.getString("dob");
			String gender = rs.getString("gender");
			cus = new Customer(id, tel, dob, gender);
		}
		Date date = null;
		try {
			 date = new SimpleDateFormat("dd-MM-yyyy").parse(cus.getDob());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cus.setDob(new SimpleDateFormat("dd/MM/yyyy").format(date));
		return cus;
	}
	
	public void getCustomerByUsername(String username) throws ClassNotFoundException, SQLException {
		AccountDAOImpl dao = new AccountDAOImpl();
		int cusID = dao.getCustomerIDByUsername(username);
		
		
	}
	
	public int getTheLastRecords() throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		int thelast = 0;
		String query = "SELECT id FROM store_online.customer order by id desc limit 1";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		if (rs.next()) {
			thelast = rs.getInt(1);
		}
		return thelast;
	}
	
	public FullName getFullNameByCusID(int cusID) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		FullName fn = null;
		String query = "select * from fullname where customerID = ?";
		PreparedStatement pre = con.prepareStatement(query);
		ResultSet rs = pre.executeQuery();
		while (rs.next()) {
			fn = new FullName(rs.getString("firstname"), rs.getString("lastname"));
		}
		return fn;
	}
	
	public Address getAddressByCusID(int cusID) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		Address fn = null;
		String query = "select * from fullname where customerID = ?";
		PreparedStatement pre = con.prepareStatement(query);
		ResultSet rs = pre.executeQuery();
		while (rs.next()) {
			fn = new Address(rs.getInt("homeNo"), rs.getString("street"), rs.getString("city"), rs.getString("district"));
		}
		return fn;
	}

}
