package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.BusChedule_StopPlace;
import entities.BusSchedule;
import entities.BusStopPlace;

public class BusAction {
	private Connection conn = null;

	public BusAction() {
		ConnectSQL connectSQL = new ConnectSQL();
		conn = connectSQL.getConnecttion();
	}

	 public ArrayList<BusSchedule> getListBusByName(String name) {
		 ArrayList<BusSchedule> listBus = new ArrayList<>();
		 BusSchedule busSchedule = new BusSchedule();
		 try {
			 Statement stmt = conn.createStatement();
			 String sql = "Select * From tbltuyenxe Where ten Like '%" + name + "%'";
			 ResultSet rs = stmt.executeQuery(sql);
			
			 while (rs.next()) {
				 busSchedule.setId(rs.getInt(1));
				 busSchedule.setName(rs.getString(2));
				 busSchedule.setTimeStart(rs.getString(3));
				 busSchedule.setTimeFinish(rs.getString(4));
				 busSchedule.setFrequence(rs.getString(5));
				 busSchedule.setDescription(rs.getString(6));
				 listBus.add(busSchedule);
				 busSchedule = new BusSchedule();
			 }
			 return listBus;
		 } catch (SQLException e) {
		 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
		 return null;
	 }
	
	 public BusStopPlace getNearestBusStop(Double longtitude, Double latitude) {
		 
		 BusStopPlace busStopPlace = new BusStopPlace();
		 try {
			 Statement stmt = conn.createStatement();
//			 String sql = "select * "
//			 		+ "from tbldiemdung as d order by (select sqrt(power(d.kinhDo - " + longtitude + ",2) + power(d.viDo - " + latitude + ",2))) limit 1";
			 String sql = "select * "
			 		+ "order by (select sqrt(power(d.kinhDo - "+longtitude+",2) + power(d.viDo - "+latitude+",2)))  limit 1";
			 ResultSet rs = stmt.executeQuery(sql);
			
			 while (rs.next()) {
				 busStopPlace.setId(rs.getInt(1));
				 busStopPlace.setName(rs.getString(2));
				 busStopPlace.setDescription(rs.getString(3));
				 busStopPlace.setLongitude(rs.getFloat(4));
				 busStopPlace.setLatitude(rs.getFloat(5));
				 return busStopPlace;
			 }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return null;
	 }

	 public BusStopPlace getBusStopByName(String name){
		 BusStopPlace busStopPlace = new BusStopPlace();
		 try {
			Statement stmt = conn.createStatement();
			String sql = "Select * From tbldiemdung Where name = '" + name + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				busStopPlace.setId(rs.getInt(1));
				 busStopPlace.setName(rs.getString(2));
				 busStopPlace.setDescription(rs.getString(3));
				 busStopPlace.setLongitude(rs.getFloat(4));
				 busStopPlace.setLatitude(rs.getFloat(5));
				 return busStopPlace;
			}
		} catch (Exception e) {
		}
		 return null;
	 }
	 
	public ArrayList<BusSchedule> getListBusBy2Position(String name1, String name2) {
		BusSchedule busSchedule = new BusSchedule();
		BusStopPlace busStopPlace = new BusStopPlace();
		ArrayList<BusSchedule> listBus = new ArrayList<>();

		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT tx.id, tx.ten, tx.thoiGianBatDau, tx.thoiGianKetThuc, tx.tanSuat, tx.mieuTa "
					+ "From tbltuyenxe as tx, tbldiemdungxe as ddx1, tbldiemdungxe as ddx2, tbldiemdung as dd1, tbldiemdung as dd2 "
					+ "WHERE tx.id = ddx1.idTuyenXe "
							+ "and ddx1.idDiemDung = dd1.id "
							+ "and dd1.ten = '"+name1+"' "
							+ "and tx.id = ddx2.idTuyenXe "
							+ "and ddx2.idDiemDung = dd2.id "
							+ "and dd2.ten = '"+name2+"'"
							+ "and ddx2.sttBen > ddx1.sttBen "
							+ "and ddx1.chieuDi = ddx2.chieuDi";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				busSchedule.setId(rs.getInt(1));
				busSchedule.setName(rs.getString(2));
				busSchedule.setTimeStart(rs.getString(3));
				busSchedule.setTimeFinish(rs.getString(4));
				busSchedule.setFrequence(rs.getString(5));
				busSchedule.setDescription(rs.getString(6));
				listBus.add(busSchedule);
				busSchedule = new BusSchedule();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (listBus.size() >= 1) {
			return listBus;
		}		
		
		// truong hop 2: đổi điểm name1 sang điểm đối diện
		String name1_1 = getBusStopOpposite(name1);
		
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT tx.id, tx.ten, tx.thoiGianBatDau, tx.thoiGianKetThuc, tx.tanSuat, tx.mieuTa "
					+ "From tbltuyenxe as tx, tbldiemdungxe as ddx1, tbldiemdungxe as ddx2, tbldiemdung as dd1, tbldiemdung as dd2 "
					+ "WHERE tx.id = ddx1.idTuyenXe "
							+ "and ddx1.idDiemDung = dd1.id "
							+ "and dd1.ten = '"+name1_1+"' "
							+ "and tx.id = ddx2.idTuyenXe "
							+ "and ddx2.idDiemDung = dd2.id "
							+ "and dd2.ten = '"+name2+"'"
							+ "and ddx2.sttBen > ddx1.sttBen "
							+ "and ddx1.chieuDi = ddx2.chieuDi";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				busSchedule.setId(rs.getInt(1));
				busSchedule.setName(rs.getString(2));
				busSchedule.setTimeStart(rs.getString(3));
				busSchedule.setTimeFinish(rs.getString(4));
				busSchedule.setFrequence(rs.getString(5));
				busSchedule.setDescription(rs.getString(6));
				listBus.add(busSchedule);
				busSchedule = new BusSchedule();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (listBus.size() >= 1) {
			return listBus;
		}
		
		//truong hop 3: đổi điểm dối diện của name2
		String name2_1 = getBusStopOpposite(name2);
		
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT tx.id, tx.ten, tx.thoiGianBatDau, tx.thoiGianKetThuc, tx.tanSuat, tx.mieuTa "
					+ "From tbltuyenxe as tx, tbldiemdungxe as ddx1, tbldiemdungxe as ddx2, tbldiemdung as dd1, tbldiemdung as dd2 "
					+ "WHERE tx.id = ddx1.idTuyenXe "
							+ "and ddx1.idDiemDung = dd1.id "
							+ "and dd1.ten = '"+name1+"' "
							+ "and tx.id = ddx2.idTuyenXe "
							+ "and ddx2.idDiemDung = dd2.id "
							+ "and dd2.ten = '"+name2_1+"'"
							+ "and ddx2.sttBen > ddx1.sttBen "
							+ "and ddx1.chieuDi = ddx2.chieuDi";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				busSchedule.setId(rs.getInt(1));
				busSchedule.setName(rs.getString(2));
				busSchedule.setTimeStart(rs.getString(3));
				busSchedule.setTimeFinish(rs.getString(4));
				busSchedule.setFrequence(rs.getString(5));
				busSchedule.setDescription(rs.getString(6));
				listBus.add(busSchedule);
				busSchedule = new BusSchedule();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (listBus.size() >= 1) {
			return listBus;
		}
		
				
		// truong hop 4: đổi sang 2 điểm đối diện
		String name1_2 = getBusStopOpposite(name1);
		String name2_2 = getBusStopOpposite(name2);
		
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT tx.id, tx.ten, tx.thoiGianBatDau, tx.thoiGianKetThuc, tx.tanSuat, tx.mieuTa "
					+ "From tbltuyenxe as tx, tbldiemdungxe as ddx1, tbldiemdungxe as ddx2, tbldiemdung as dd1, tbldiemdung as dd2 "
					+ "WHERE tx.id = ddx1.idTuyenXe "
							+ "and ddx1.idDiemDung = dd1.id "
							+ "and dd1.ten = '"+name2_2+"' "
							+ "and tx.id = ddx2.idTuyenXe "
							+ "and ddx2.idDiemDung = dd2.id "
							+ "and dd2.ten = '"+name1_2+"'"
							+ "and ddx2.sttBen > ddx1.sttBen "
							+ "and ddx1.chieuDi = ddx2.chieuDi";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				busSchedule.setId(rs.getInt(1));
				busSchedule.setName(rs.getString(2));
				busSchedule.setTimeStart(rs.getString(3));
				busSchedule.setTimeFinish(rs.getString(4));
				busSchedule.setFrequence(rs.getString(5));
				busSchedule.setDescription(rs.getString(6));
				listBus.add(busSchedule);
				busSchedule = new BusSchedule();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (listBus.size() >= 1) {
			return listBus;
		}
		
		return null;
	}
	
	public String getBusStopOpposite(String name){
		
		int chieuDi = -1;
		double longtitude = -1;
		double latitude = -1;
		String tenDiaDiemDoiDien;
		int id = -1;
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT ddx.chieuDi, dd.kinhDo, dd.viDo, dd.id FROM tbldiemdungxe as ddx, tbldiemdung as dd WHERE dd.id = ddx.idDiemDung and dd.ten = '" + name + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				chieuDi = rs.getInt(1);
				longtitude = rs.getDouble(2);
				latitude = rs.getDouble(3);
				id = rs.getInt(4);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			Statement stmt = conn.createStatement();
//			String sql = "select dd.ten "
//			 		+ "from tbldiemdung as dd, tbldiemdungxe as ddx WHERE ddx.chieuDi <> "+chieuDi+" and dd.id <> "+id+" order by (select sqrt(power(dd.kinhDo - " + longtitude + ",2) + power(dd.viDo - " + latitude + ",2))) limit 1";
			String sql = "select d.ten "
			 		+ "from tbldiemdung as d, tbldiemdungxe as ddx "
			 		+ "WHERE ddx.chieuDi <> "+chieuDi+" and d.id <>"+id+" "
			 		+ "order by (select sqrt(power(d.kinhDo - "+longtitude+",2) + power(d.viDo - "+latitude+",2)))  limit 1";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				tenDiaDiemDoiDien = rs.getString(1);
				System.out.println(name + " ten dia diem doi dien:" + tenDiaDiemDoiDien);
				return tenDiaDiemDoiDien;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
