package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserAction {

	private Connection conn = null;

	public boolean existAccount(String username) {

		ConnectSQL connectSQL = new ConnectSQL();
		conn = connectSQL.getConnecttion();
		try {
			Statement stmt = conn.createStatement();
			String sql = "Select * From tbluser where username = '" + username + "'";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				return true; // ton tai nguoi dung
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false; // chua ton tai nguoi dung
	}

	public boolean checkLogin(String username, String password) {
		ConnectSQL connectSQL = new ConnectSQL();
		conn = connectSQL.getConnecttion();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String sql = "Select * From tbluser where username = '" + username + "'" + " and password = '" + password
					+ "'";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean register(String username, String password) {
		if (existAccount(username)) {
			return false; // dang ky khong thanh cong
		} else {
			ConnectSQL connectSQL = new ConnectSQL();
			conn = connectSQL.getConnecttion();
			try {
				String sql = "INSERT INTO tbluser" + "(username, password) VALUES" + "(?,?)";
				PreparedStatement preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, password);
				preparedStatement.executeUpdate();
				return true; // dang ky thanh cong
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false; // dang ky khong thanh cong
	}
	
	public boolean editAccount(String username, String newPasswod){
		try {
			Statement stmt = conn.createStatement();
			String sql = "UPDATE tbluser SET password = '"+newPasswod+"'WHERE username='"+username+"'";
			stmt.executeQuery(sql);
			return true;	// sua thanh cong
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;   // sua khong thanh cong
	}
}
