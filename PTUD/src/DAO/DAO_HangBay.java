package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connect.KetNoiDB;
import ENTITY.HangBay;

public class DAO_HangBay {
	private ArrayList<HangBay> dsHangBay;

	// Trả về hết một danh sách hãng bay
	public ArrayList<HangBay> getalltbHangBay() {
		dsHangBay = new ArrayList<HangBay>();
		try {
			KetNoiDB.getInstance();
			Connection con = KetNoiDB.getConnection();
			String sql = "Select * from HangBay";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				
				String maHangBay = rs.getString("MaHangBay");
				String tenHangBay = rs.getString("TenHangBay");
				String quocGia = rs.getString("QuocGia"); 
				String hinhAnh = rs.getString("HinhAnh");
			
				HangBay hb = new HangBay(maHangBay, tenHangBay, quocGia, hinhAnh); 
				dsHangBay.add(hb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHangBay;
	}
	
	// Trả về một đối tượng theo mã 
	public HangBay getOneObjHangBay(String maObj) { 
		HangBay hangBay = null;
	    try {
	        KetNoiDB.getInstance();
	        Connection con = KetNoiDB.getConnection();
	        String sql = "Select * from HangBay where MaHangBay = ?";
	        PreparedStatement preparedStatement = con.prepareStatement(sql);
	        preparedStatement.setString(1, maObj);
	        ResultSet rs = preparedStatement.executeQuery();
	        if (rs.next()) {
	            String maHangBay = rs.getString("MaHangBay");
	            String tenHangBay = rs.getString("TenHangBay");
	            String quocGia = rs.getString("QuocGia");
	            String hinhAnh = rs.getString("HinhAnh");

	            hangBay = new HangBay(maHangBay, tenHangBay, quocGia, hinhAnh);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return hangBay;
	}

	public String in() {
		return dsHangBay.toString();
	}
}
