package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import entities.PlaceSellTicket;

public class daodiembanve {
	private java.sql.Connection conn;
	private List<PlaceSellTicket> lstSell = new ArrayList<>();
	
	public List<PlaceSellTicket> getLstSell() {
		return lstSell;
	}

	public void setLstSell(List<PlaceSellTicket> lstSell) {
		this.lstSell = lstSell;
	}
	
	public List<PlaceSellTicket> getSell(){
		PlaceSellTicket placeSellTicket = new PlaceSellTicket();
		
		try {
			ConnectSQL connectSQL = new ConnectSQL();
			conn = connectSQL.getConnecttion();
			Statement stmt = conn.createStatement();

			String sql = "Select * From tbldiembanve";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				placeSellTicket.setId(rs.getInt(1));
				placeSellTicket.setName(rs.getString(2));
				placeSellTicket.setLongitude(rs.getFloat(3));
				placeSellTicket.setLatitude(rs.getFloat(4));
				placeSellTicket.setHourOpen(rs.getString(5));
				placeSellTicket.setHourClose(rs.getString(6));
				lstSell.add(placeSellTicket);
				placeSellTicket = new PlaceSellTicket();
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstSell;
		
	}
	
	public void addsell(){
		PlaceSellTicket placeSellTicket = new PlaceSellTicket();
        String sql = "INSERT INTO tblDiembanve(id, name, longitude, latitude, hourOpen,hourClose) VALUES(?,?,?,?,?,?)";
        try{
        	ConnectSQL connectSQL = new ConnectSQL();
    		conn = connectSQL.getConnecttion();
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            
            ps.setInt(1, placeSellTicket.getId());
            ps.setString(2, placeSellTicket.getName());
            ps.setFloat(3, placeSellTicket.getLongitude());
            ps.setFloat(4, placeSellTicket.getLongitude());
            ps.setString(5, placeSellTicket.getHourOpen());
            ps.setString(6, placeSellTicket.getHourClose());  
            ps.executeUpdate();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }        
    }
	
	public void updatesell(){
		PlaceSellTicket placeSellTicket = new PlaceSellTicket();
        String sql = "UPDATE INTO tblDiembanve(id, name, longitude, latitude, hourOpen,hourClose) VALUES(?,?,?,?,?,?)";
        try{
        	ConnectSQL connectSQL = new ConnectSQL();
    		conn = connectSQL.getConnecttion();
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            
            ps.setInt(1, placeSellTicket.getId());
            ps.setString(2, placeSellTicket.getName());
            ps.setFloat(3, placeSellTicket.getLongitude());
            ps.setFloat(4, placeSellTicket.getLongitude());
            ps.setString(5, placeSellTicket.getHourOpen());
            ps.setString(6, placeSellTicket.getHourClose());  
            ps.executeUpdate();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }        
    }
}

