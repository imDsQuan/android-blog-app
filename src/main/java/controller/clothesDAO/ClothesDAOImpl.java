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
	private static final String SELECT_ALL_CLOTHES = "select * from clothes order by id+0 desc";
	private static final String SELECT_CLOTHES_BY_CODE = "select * from clothes where id = ?;";
	private static final String SELECT_IMG_BY_CODE = "select * from clothesimage where clothesID =?";
	private static final String UPDATE_CLOTHES = "update clothes set name = ?, description = ?, material = ?, discount = ?, price = ?, typeClothes = ?, brand = ? where id = ?;";
	private static final String INSERT_CLOTHES = "INSERT INTO clothes (description, Material, Name, Discount, Price, TypeClothes, Brand, id) VALUES (? ,?, ?, ?, ?, ?, ? , ?);";
	private static final String INSERT_IMG = "INSERT INTO clothesimage (ClothesID, Url) VALUES (?, ?), (?, ?), (?, ?), (?, ?) ;";
	private static final String DELETE_CLOTHES = "DELETE FROM clothes WHERE (ID = ?);";
	private static final String DELETE_IMG = "DELETE FROM clothesimage WHERE (ClothesID = ?);";

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
			String urlImg = rs.getString("Url");
			imgs.add(urlImg);
		}
		return imgs;
	}
	
	public void deleteClothes(String id) throws SQLException, ClassNotFoundException {
		Connection con = getConnection();
		PreparedStatement pre2 = con.prepareStatement(DELETE_IMG);
		pre2.setString(1, id);
		pre2.executeUpdate();
		System.out.println(pre2);
		PreparedStatement pre1 = con.prepareStatement(DELETE_CLOTHES);
		pre1.setString(1, id);
		pre1.executeUpdate();
		System.out.println(pre1);
		
		
	}

	public String getTheLastRecords() throws ClassNotFoundException, SQLException {
		String query = "SELECT ID FROM clothes ORDER BY id+0 DESC LIMIT 1;";
		Connection connection = getConnection();
		stmt = connection.createStatement();
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		String thelast = "";
		if (rs.next())
			thelast = rs.getString(1);
		return thelast;
	}

	public void insertClothes(Clothes cloth) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement pre1 = con.prepareStatement(INSERT_CLOTHES);
		// clothes (description, Material, Name, Discount, Price, TypeClothes, Brand)
		String query = "SELECT ID FROM clothes ORDER BY id+0 DESC LIMIT 1;";
		stmt = con.createStatement();
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		String thelast = "";
		if (rs.next())
			thelast = rs.getString(1);

		int lastRe = Integer.parseInt(thelast);
		lastRe += 1;

		pre1.setString(1, cloth.getDescription());
		pre1.setString(2, cloth.getMaterial());
		pre1.setString(3, cloth.getName());
		pre1.setInt(4, cloth.getDiscount());
		pre1.setDouble(5, cloth.getPrice());
		pre1.setString(6, cloth.getTypeClothes());
		pre1.setString(7, cloth.getBrand());
		pre1.setString(8, String.valueOf(lastRe));

		pre1.executeUpdate();
		System.out.println(pre1);

		PreparedStatement pre2 = con.prepareStatement(INSERT_IMG);
		List<String> img = cloth.getImage();
		pre2.setNString(1, String.valueOf(lastRe));
		pre2.setString(2, img.get(0));
		pre2.setNString(3, String.valueOf(lastRe));
		pre2.setString(4, img.get(1));
		pre2.setNString(5, String.valueOf(lastRe));
		pre2.setString(6, img.get(2));
		pre2.setNString(7, String.valueOf(lastRe));
		pre2.setString(8, img.get(3));

		pre2.executeUpdate();
		System.out.println(pre2);

	}

	public void updateClothes(Clothes clothes) throws SQLException, ClassNotFoundException {
		Connection con = getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(UPDATE_CLOTHES);
//		name = ?, description = ?, material = ?, discount = ?, price = ?, typeClothes = ?, brand = ? where id = ?
		preparedStatement.setString(1, clothes.getName());
		preparedStatement.setString(2, clothes.getDescription());
		preparedStatement.setString(3, clothes.getMaterial());
		preparedStatement.setInt(4, clothes.getDiscount());
		preparedStatement.setDouble(5, clothes.getPrice());
		preparedStatement.setString(6, clothes.getTypeClothes());
		preparedStatement.setString(7, clothes.getBrand());
		preparedStatement.setString(8, clothes.getId());

		preparedStatement.executeUpdate();
		System.out.println(preparedStatement);

	}

	public List<Clothes> getAllClothes() throws ClassNotFoundException, SQLException {
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
			// clothesCode, description, price, material
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

	public List<Clothes> getClothesByKeyWord(String keyword, int start, int total, String option)
			throws ClassNotFoundException, SQLException {
		String query = null;
		if (option == null)
			query = "select * from clothes where name like '%" + keyword + "%' order by ClothesCode ASC limit " + start
					+ "," + total;
		else if (option.equals("1"))
			query = "select * from clothes where name like '%" + keyword + "%' order by Price DESC limit " + start + ","
					+ total;
		else if (option.equals("2"))
			query = "select * from clothes where name like '%" + keyword + "%' order by Price ASC limit " + start + ","
					+ total;
		else if (option.equals("3"))
			query = "select * from clothes where name like '%" + keyword + "%' order by Name ASC limit " + start + ","
					+ total;

		List<Clothes> clothes = new ArrayList<>();
		Connection connection = getConnection();
		stmt = connection.createStatement();
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			// clothesCode, description, price, material
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
		if (rs.next())
			this.noOfRecords = rs.getInt(1);

		return clothes;
	}

	public List<Clothes> getClothesByType(String typeClothes, int start, int total, String option)
			throws ClassNotFoundException, SQLException {
		String query = null;
		if (option == null)
			query = "select * from clothes where typeClothes = '" + typeClothes + "' order by id ASC limit " + start
					+ "," + total;
		else if (option.equals("1"))
			query = "select * from clothes where typeClothes = '" + typeClothes + "' order by Price DESC limit " + start
					+ "," + total;
		else if (option.equals("2"))
			query = "select * from clothes where typeClothes = '" + typeClothes + "' order by Price ASC limit " + start
					+ "," + total;
		else if (option.equals("3"))
			query = "select * from clothes where typeClothes = '" + typeClothes + "' order by Name ASC limit " + start
					+ "," + total;

		List<Clothes> clothes = new ArrayList<>();
		Connection connection = getConnection();
		stmt = connection.createStatement();
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			// clothesCode, description, price, material
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
		if (rs.next())
			this.noOfRecords = rs.getInt(1);

		return clothes;
	}

	public List<Clothes> getRecords(int start, int total, String option) throws ClassNotFoundException, SQLException {
		String query = null;
		if (option == null)
			query = "select * from clothes order by id ASC limit " + start + "," + total;
		else if (option.equals("1"))
			query = "select * from clothes order by Price DESC limit " + start + "," + total;
		else if (option.equals("2"))
			query = "select * from clothes order by Price ASC limit " + start + "," + total;
		else if (option.equals("3"))
			query = "select * from clothes order by Name ASC limit " + start + "," + total;

		List<Clothes> clothes = new ArrayList<>();
		Connection connection = getConnection();
		stmt = connection.createStatement();
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			// clothesCode, description, price, material
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
		if (rs.next())
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
		String query = "select COUNT(*) from clothes where typeClothes = '" + typeClothes + "';";
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
		String query = "select COUNT(*) from clothes where name like '%" + keyword + "%';";
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
