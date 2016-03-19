package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.PlaceSellTicket;

public class PlaceSellTicketAction {

	private java.sql.Connection conn;

	public String getPlaceSellTicket(String ten) throws ClassNotFoundException {

		PlaceSellTicket placeSellTicket = new PlaceSellTicket();

		try {
			ConnectSQL connectSQL = new ConnectSQL();
			conn = connectSQL.getConnecttion();
			Statement stmt = conn.createStatement();

			String sql = "Select * From tbldiembanve where ten LIKE '%" + ten + "%'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				placeSellTicket.setId(rs.getInt(1));
				placeSellTicket.setName(rs.getString(2));
				placeSellTicket.setLongitude(rs.getFloat(3));
				placeSellTicket.setLatitude(rs.getFloat(4));
				placeSellTicket.setHourOpen(rs.getString(5));
				placeSellTicket.setHourClose(rs.getString(6));
				// return placeSellTicket;
				return placeSellTicket.getName();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "-1";
	}

	public ArrayList<PlaceSellTicket> getListPlaceSellTicket(float longitude, float latitude) {

		List<PlaceSellTicket> listPlace = new ArrayList<>();
		PlaceSellTicket placeSellTicket = new PlaceSellTicket();

		ConnectSQL connectSQL = new ConnectSQL();
		conn = connectSQL.getConnecttion();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from tbldiembanve as d order by (select sqrt(power(d.kinhDo - " + longitude
					+ ",2) + power(d.viDo - " + latitude + ",2))) limit 5";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				placeSellTicket.setId(rs.getInt(1));
				placeSellTicket.setName(rs.getString(2));
				placeSellTicket.setLongitude(rs.getFloat(3));
				placeSellTicket.setLatitude(rs.getFloat(4));
				placeSellTicket.setHourOpen(rs.getString(5));
				placeSellTicket.setHourClose(rs.getString(6));

				listPlace.add(placeSellTicket);
				placeSellTicket = new PlaceSellTicket();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<PlaceSellTicket>) listPlace;
	}

}
