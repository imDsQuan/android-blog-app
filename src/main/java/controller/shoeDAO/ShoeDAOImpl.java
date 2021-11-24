package controller.shoeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.MySQLConnUtils;
import model.clothes.Clothes;
import model.shoe.Shoe;


public class ShoeDAOImpl {
	
	
		private int noOfRecords;
		Statement stmt;
		private static final String SELECT_ALL_SHOE = "select * from shoe";
		private static final String SELECT_SHOE_BY_CODE = "select * from shoe where id = ?;";
		private static final String SELECT_IMG_BY_CODE = "select * from shoeimage where shoeID =?";
		private static final String UPDATE_SHOE = "update shoe set name = ?, description = ?, material = ?, discount = ?, price = ?, typeShoe = ?,warrantlyperiod = ?, brand = ? where id = ?;";
		private static final String INSERT_SHOE = "INSERT INTO shoe (description, Material, Name, Discount, Price, TypeShoe,Warrantlyperiod, Brand, id) VALUES (? ,?, ?, ?, ?, ?, ? , ?);";
		private static final String INSERT_IMG = "INSERT INTO shoeimage (ShoeID, Url) VALUES (?, ?), (?, ?), (?, ?), (?, ?) ;";
		private static final String DELETE_SHOE = "DELETE FROM shoe WHERE (ID = ?);";
		private static final String DELETE_IMG = "DELETE FROM shoeimage WHERE (ShoeID = ?);";
		public ShoeDAOImpl() {
			
		}
		
		protected Connection getConnection() throws SQLException, ClassNotFoundException {
			Connection connection = MySQLConnUtils.getMySQLConnection();
			return connection;
		}
		
		public List<String> getImghByShoeCode(String code) throws ClassNotFoundException, SQLException {
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
		public void deleteShoe(String id) throws SQLException, ClassNotFoundException {
			Connection con = getConnection();
			PreparedStatement pre2 = con.prepareStatement(DELETE_IMG);
			pre2.setString(1, id);
			pre2.executeUpdate();
			System.out.println(pre2);
			PreparedStatement pre1 = con.prepareStatement(DELETE_SHOE);
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
		
		
		public void insertShoe(Shoe shoe) throws ClassNotFoundException, SQLException {
			Connection con = getConnection();
			PreparedStatement pre1 = con.prepareStatement(INSERT_SHOE);
			
			String query = "SELECT ID FROM shoe ORDER BY id+0 DESC LIMIT 1;";
			stmt = con.createStatement();
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			String thelast = "";
			if (rs.next())
				thelast = rs.getString(1);

			int lastRe = Integer.parseInt(thelast);
			lastRe += 1;

			pre1.setString(1, shoe.getDescription());
			pre1.setString(2, shoe.getMaterial());
			pre1.setString(3, shoe.getName());
			pre1.setInt(4, shoe.getDiscount());
			pre1.setDouble(5, shoe.getPrice());
			pre1.setString(6, shoe.getTypeShoe());
			pre1.setString(7, shoe.getWarrantlyperiod());
			pre1.setString(8, shoe.getBrand());
			pre1.setString(9, String.valueOf(lastRe));

			pre1.executeUpdate();
			System.out.println(pre1);

			PreparedStatement pre2 = con.prepareStatement(INSERT_IMG);
			List<String> img = shoe.getImage();
			pre2.setNString(1, String.valueOf(lastRe));
			pre2.setString(2, img.get(0));
			pre2.setNString(3, String.valueOf(lastRe));
			pre2.setString(4, img.get(1));
			pre2.setNString(5, String.valueOf(lastRe));
			pre2.setString(6, img.get(2));
			pre2.setNString(7, String.valueOf(lastRe));
			pre2.setString(8, img.get(3));
			pre2.setNString(9, String.valueOf(lastRe));

			pre2.executeUpdate();
			System.out.println(pre2);

		}
		
		
		public void updateShoe(Shoe shoe) throws SQLException, ClassNotFoundException {
			Connection con = getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(UPDATE_SHOE);
//			name = ?, description = ?, material = ?, discount = ?, price = ?, typeClothes = ?, brand = ? where id = ?
			preparedStatement.setString(1, shoe.getName());
			preparedStatement.setString(2, shoe.getDescription());
			preparedStatement.setString(3, shoe.getMaterial());
			preparedStatement.setInt(4, shoe.getDiscount());
			preparedStatement.setDouble(5, shoe.getPrice());
			preparedStatement.setString(6, shoe.getTypeShoe());
			preparedStatement.setString(7, shoe.getWarrantlyperiod());
			preparedStatement.setString(8, shoe.getBrand());
			preparedStatement.setString(9, shoe.getId());

			preparedStatement.executeUpdate();
			System.out.println(preparedStatement);

		}

		
		
		
		public List<Shoe> getAllShoe() throws ClassNotFoundException, SQLException{
			List<Shoe> shoe = new ArrayList<>();
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SHOE);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
//				//String id, String name, String description, String material, int discount, double price,
//				String typeClothes, String brand
				String id = rs.getString("ID");
				String description = rs.getString("description");
				double price = rs.getDouble("price");
				String name = rs.getString("name");
				String typeShoe = rs.getString("typeShoe");
				String brand = rs.getString("brands");
				int discount = rs.getInt("discount");
				String material = rs.getString("material");
				String warrantlyperiod = rs.getString("warrantlyperiod");
				System.out.println(name);
				shoe.add(new Shoe(id, name, description, material, discount, price, typeShoe, brand, warrantlyperiod));
			}
			return shoe;
		}

		public List<Shoe> getFourRandomShoe() throws SQLException, ClassNotFoundException {
			String query = "SELECT * FROM shoe ORDER BY RAND() LIMIT 4;";
			List<Shoe> list = new ArrayList<>();
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
				String typeShoe = rs.getString("typeShoe");
				String brand = rs.getString("brands");
				int discount = rs.getInt("discount");
				String material = rs.getString("material");
				String warrantlyperiod = rs.getString("warrantlyperiod");
				list.add(new Shoe(id, name, description, material, discount, price, typeShoe, brand,warrantlyperiod));
			}
			rs.close();
			return list;
		}
		
		public Shoe getShoeByCode(String code) throws ClassNotFoundException, SQLException {
			Shoe shoe = null;
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SHOE_BY_CODE);
			preparedStatement.setString(1, code);
			System.err.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String id = rs.getString("ID");
				String description = rs.getString("description");
				double price = rs.getDouble("price");
				String name = rs.getString("name");
				String typeShoe = rs.getString("typeShoe");
				String brand = rs.getString("brands");
				int discount = rs.getInt("discount");
				String material = rs.getString("material");
				String warrantlyperiod = rs.getString("warrantlyperiod");
				shoe = new Shoe(id, name, description, material, discount, price, typeShoe, brand, warrantlyperiod);

			}
			
			
			return shoe;
		}
		
		public List<Shoe> getShoeByKeyWord(String keyword, int start, int total, String option) throws ClassNotFoundException, SQLException{
			String query = null;
			if (option == null)
				query = "select * from shoe where name like '%" + keyword + "%' order by ShoeCode ASC limit " + start + "," + total;
			else if(option.equals("1"))
				query = "select * from shoe where name like '%" + keyword + "%' order by Price DESC limit " + start + "," + total;
			else if(option.equals("2"))
				query = "select * from shoe where name like '%" + keyword + "%' order by Price ASC limit " + start + "," + total;
			else if(option.equals("3"))
				query = "select * from shoe where name like '%" + keyword + "%' order by Name ASC limit " + start + "," + total;
			
			List<Shoe> shoe = new ArrayList<>();
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
				String typeShoe = rs.getString("typeShoe");
				String brand = rs.getString("brand");
				int discount = rs.getInt("discount");
				String material = rs.getString("material");
				String warrantlyperiod = rs.getString("warrantlyperiod");
				shoe.add(new Shoe(id, name, description, material, discount, price, typeShoe, brand,warrantlyperiod));
			}
			rs.close();
			rs = stmt.executeQuery("SELECT FOUND_ROWS()");
			if(rs.next())
	            this.noOfRecords = rs.getInt(1);
			
			return shoe;
		}
		
		public List<Shoe> getShoeByType(String typeShoe, int start, int total, String option) throws ClassNotFoundException, SQLException{
			String query = null;
			if (option == null)
				query = "select * from shoe where typeShoe = '" + typeShoe + "' order by id ASC limit " + start + "," + total;
			else if(option.equals("1"))
				query = "select * from shoe where typeShoe = '" + typeShoe + "' order by Price DESC limit " + start + "," + total;
			else if(option.equals("2"))
				query = "select * from shoe where typeShoe = '" + typeShoe + "' order by Price ASC limit " + start + "," + total;
			else if(option.equals("3"))
				query = "select * from shoe where typeShoe = '" + typeShoe + "' order by Name ASC limit " + start + "," + total;
			
			List<Shoe> shoe = new ArrayList<>();
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
				String typeSho = rs.getString("typeShoe");
				String brand = rs.getString("brand");
				int discount = rs.getInt("discount");
				String material = rs.getString("material");
				String warrantlyperiod = rs.getString("warrantlyperiod");
				shoe.add(new Shoe(id, name, description, material, discount, price, typeSho, brand,warrantlyperiod));
			}
			rs.close();
			rs = stmt.executeQuery("SELECT FOUND_ROWS()");
			if(rs.next())
	            this.noOfRecords = rs.getInt(1);
			
			return shoe;
		}
		
		
		public List<Shoe> getRecords(int start, int total, String option) throws ClassNotFoundException, SQLException{
			String query = null;
			if (option == null)
				 query = "select * from shoe order by id ASC limit " + start + "," + total;
			else if(option.equals("1"))
				 query = "select * from shoe order by Price DESC limit " + start + "," + total;
			else if(option.equals("2"))
				 query = "select * from shoe order by Price ASC limit " + start + "," + total;
			else if(option.equals("3"))
				 query = "select * from shoe order by Name ASC limit " + start + "," + total;

			List<Shoe> shoe = new ArrayList<>();
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
				String typeShoe = rs.getString("typeShoe");
				String brand = rs.getString("brands");
				int discount = rs.getInt("discount");
				String material = rs.getString("material");
				String warrantlyperiod = rs.getString("warrantlyperiod");
				shoe.add(new Shoe(id, name, description, material, discount, price, typeShoe, brand,warrantlyperiod));
			}
			rs.close();
			rs = stmt.executeQuery("SELECT FOUND_ROWS()");
			if(rs.next())
	            this.noOfRecords = rs.getInt(1);
			
			return shoe;
		}
		
		public int getNoOfRecords() {
	        return noOfRecords;
	    }
		
		public int totalShoe() throws SQLException, ClassNotFoundException {
			String query = "select COUNT(*) from shoe;";
			Connection connection = getConnection();
			stmt = connection.createStatement();
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			int total = 0;
			if (rs.next())
				total = rs.getInt(1);
			return total;
		}
		
		public int totalShoeForType(String typeShoe) throws SQLException, ClassNotFoundException {
			String query = "select COUNT(*) from shoe where typeShoe = '" + typeShoe +"';";
			Connection connection = getConnection();
			stmt = connection.createStatement();
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			int total = 0;
			if (rs.next())
				total = rs.getInt(1);
			return total;
		}
		
		public int totalShoeForSearch(String keyword) throws SQLException, ClassNotFoundException {
			String query = "select COUNT(*) from shoe where name like '%" + keyword +"%';";
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


