package controller.accountDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.customer.Account;
import util.MySQLConnUtils;

public class AccountDAOImpl {
	protected Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection connection = MySQLConnUtils.getMySQLConnection();
		return connection;
	}
	public Account Login(String user, String pass) throws ClassNotFoundException, SQLException {
		String q = "Select * from account where Username = ? and `Password` = ?;";
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(q);
		ps.setString(1, user);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			return new Account(rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		return null;
	}
}
