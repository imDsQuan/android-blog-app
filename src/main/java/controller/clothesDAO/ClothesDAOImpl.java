package controller.clothesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.MySQLConnUtils;
import model.clothes.Clothes;

public class ClothesDAOImpl {
	private int noOfRecords;
	Statement stmt;
	private static final String SELECT_ALL_CLOTHES = "select * from clothes";
	private static final String SELECT_CLOTHES_BY_CODE = "select * from clothes where id = ?;";
	private static final String SELECT_IMG_BY_CODE = "select * from clothesimage where clothesID =?";
	
	public ClothesDAOImpl() {
		
	}
	
	protected Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection connection = MySQLConnUtils.getMySQLConnection();
		return connection;
	}
	
	public List<String> getImghByClothCode(String code) throws ClassNotFoundException, SQLException {
		List<String> imgs = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_IMG_BY_CODE);
		preparedStatement.setString(1, code);
		System.err.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			String urlImg  = rs.getString("Url");
			imgs.add(urlImg);
		}
		return imgs;
	}
	
	
	
	public List<Clothes> getAllClothes() throws ClassNotFoundException, SQLException{
		List<Clothes> clothes = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLOTHES);
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
//			//String id, String name, String description, String material, int discount, double price,
//			String typeClothes, String brand
			String id = rs.getString("ID");
			String description = rs.getString("description");
			double price = rs.getDouble("price");
			String name = rs.getString("name");
			String typeClothes = rs.getString("typeClothes");
			String brand = rs.getString("brand");
			int discount = rs.getInt("discount");
			String material = rs.getString("material");
			System.out.println(name);
			clothes.add(new Clothes(id, name, description, material, discount, price, typeClothes, brand));
		}
		return clothes;
	}

	public List<Clothes> getFourRandomClothes() throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM clothes ORDER BY RAND() LIMIT 4;";
		List<Clothes> list = new ArrayList<>();
		Connection con = getConnection();
		stmt = con.createStatement();
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			//clothesCode, description, price, material
			String id = rs.getString("ID");
			String description = rs.getString("description");
			double price = rs.getDouble("price");
			String name = rs.getString("name");
			String typeClothes = rs.getString("typeClothes");
			String brand = rs.getString("brand");
			int discount = rs.getInt("discount");
			String material = rs.getString("material");
			list.add(new Clothes(id, name, description, material, discount, price, typeClothes, brand));
		}
		rs.close();
		return list;
	}
	
	public Clothes getClothByCode(String code) throws ClassNotFoundException, SQLException {
		Clothes clothes = null;
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLOTHES_BY_CODE);
		preparedStatement.setString(1, code);
		System.err.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			String id = rs.getString("ID");
			String description = rs.getString("description");
			double price = rs.getDouble("price");
			String name = rs.getString("name");
			String typeClothes = rs.getString("typeClothes");
			String brand = rs.getString("brand");
			int discount = rs.getInt("discount");
			String material = rs.getString("material");
			clothes = new Clothes(id, name, description, material, discount, price, typeClothes, brand);

		}
		
		
		return clothes;
	}
	
	public List<Clothes> getClothesByKeyWord(String keyword, int start, int total, String option) throws ClassNotFoundException, SQLException{
		String query = null;
		if (option == null)
			query = "select * from clothes where name like '%" + keyword + "%' order by ClothesCode ASC limit " + start + "," + total;
		else if(option.equals("1"))
			query = "select * from clothes where name like '%" + keyword + "%' order by Price DESC limit " + start + "," + total;
		else if(option.equals("2"))
			query = "select * from clothes where name like '%" + keyword + "%' order by Price ASC limit " + start + "," + total;
		else if(option.equals("3"))
			query = "select * from clothes where name like '%" + keyword + "%' order by Name ASC limit " + start + "," + total;
		
		List<Clothes> clothes = new ArrayList<>();
		Connection connection = getConnection();
		stmt = connection.createStatement();
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			//clothesCode, description, price, material
			String id = rs.getString("ID");
			String description = rs.getString("description");
			double price = rs.getDouble("price");
			String name = rs.getString("name");
			String typeClothes = rs.getString("typeClothes");
			String brand = rs.getString("brand");
			int discount = rs.getInt("discount");
			String material = rs.getString("material");
			clothes.add(new Clothes(id, name, description, material, discount, price, typeClothes, brand));
		}
		rs.close();
		rs = stmt.executeQuery("SELECT FOUND_ROWS()");
		if(rs.next())
            this.noOfRecords = rs.getInt(1);
		
		return clothes;
	}
	
	public List<Clothes> getClothesByType(String typeClothes, int start, int total, String option) throws ClassNotFoundException, SQLException{
		String query = null;
		if (option == null)
			query = "select * from clothes where typeClothes = '" + typeClothes + "' order by id ASC limit " + start + "," + total;
		else if(option.equals("1"))
			query = "select * from clothes where typeClothes = '" + typeClothes + "' order by Price DESC limit " + start + "," + total;
		else if(option.equals("2"))
			query = "select * from clothes where typeClothes = '" + typeClothes + "' order by Price ASC limit " + start + "," + total;
		else if(option.equals("3"))
			query = "select * from clothes where typeClothes = '" + typeClothes + "' order by Name ASC limit " + start + "," + total;
		
		List<Clothes> clothes = new ArrayList<>();
		Connection connection = getConnection();
		stmt = connection.createStatement();
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			//clothesCode, description, price, material
			String id = rs.getString("ID");
			String description = rs.getString("description");
			double price = rs.getDouble("price");
			String name = rs.getString("name");
			String typeCloth = rs.getString("typeClothes");
			String brand = rs.getString("brand");
			int discount = rs.getInt("discount");
			String material = rs.getString("material");
			clothes.add(new Clothes(id, name, description, material, discount, price, typeCloth, brand));
		}
		rs.close();
		rs = stmt.executeQuery("SELECT FOUND_ROWS()");
		if(rs.next())
            this.noOfRecords = rs.getInt(1);
		
		return clothes;
	}
	
	
	public List<Clothes> getRecords(int start, int total, String option) throws ClassNotFoundException, SQLException{
		String query = null;
		if (option == null)
			 query = "select * from clothes order by id ASC limit " + start + "," + total;
		else if(option.equals("1"))
			 query = "select * from clothes order by Price DESC limit " + start + "," + total;
		else if(option.equals("2"))
			 query = "select * from clothes order by Price ASC limit " + start + "," + total;
		else if(option.equals("3"))
			 query = "select * from clothes order by Name ASC limit " + start + "," + total;

		List<Clothes> clothes = new ArrayList<>();
		Connection connection = getConnection();
		stmt = connection.createStatement();
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			//clothesCode, description, price, material
			String id = rs.getString("ID");
			String description = rs.getString("description");
			double price = rs.getDouble("price");
			String name = rs.getString("name");
			String typeClothes = rs.getString("typeClothes");
			String brand = rs.getString("brand");
			int discount = rs.getInt("discount");
			String material = rs.getString("material");
			clothes.add(new Clothes(id, name, description, material, discount, price, typeClothes, brand));
		}
		rs.close();
		rs = stmt.executeQuery("SELECT FOUND_ROWS()");
		if(rs.next())
            this.noOfRecords = rs.getInt(1);
		
		return clothes;
	}
	
	public int getNoOfRecords() {
        return noOfRecords;
    }
	
	public int totalClothes() throws SQLException, ClassNotFoundException {
		String query = "select COUNT(*) from clothes;";
		Connection connection = getConnection();
		stmt = connection.createStatement();
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		int total = 0;
		if (rs.next())
			total = rs.getInt(1);
		return total;
	}
	
	public int totalClothesForType(String typeClothes) throws SQLException, ClassNotFoundException {
		String query = "select COUNT(*) from clothes where typeClothes = '" + typeClothes +"';";
		Connection connection = getConnection();
		stmt = connection.createStatement();
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		int total = 0;
		if (rs.next())
			total = rs.getInt(1);
		return total;
	}
	
	public int totalClothesForSearch(String keyword) throws SQLException, ClassNotFoundException {
		String query = "select COUNT(*) from clothes where name like '%" + keyword +"%';";
		Connection connection = getConnection();
		stmt = connection.createStatement();
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		int total = 0;
		if (rs.next())
			total = rs.getInt(1);
		return total;
	}
}
