package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Connect.KetNoiDB;
import ENTITY.LichBay;

public class DAO_LichBay {
	private ArrayList<LichBay> dsLichBay;

	
	////////////////////////////////////////HÀM
	
	
	// Trả về list Lịch Bay 
	public ArrayList<LichBay> getalltbLichBay() {
		dsLichBay = new ArrayList<LichBay>();
		try {
			KetNoiDB.getInstance();
			Connection con = KetNoiDB.getConnection();
			String sql = "Select * from LichBay";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maLichBay = rs.getString("MaLichBay");
				String noiDi = rs.getString("NoiDi");
				String noiDen = rs.getString("NoiDen");
				LocalDateTime thoiGianDi = rs.getTimestamp("ThoiGianDi").toLocalDateTime();
				LocalDateTime thoiGianDen = rs.getTimestamp("ThoiGianDen").toLocalDateTime();
				LichBay lb = new LichBay(maLichBay, noiDi, noiDen, thoiGianDi, thoiGianDen);

				dsLichBay.add(lb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLichBay;
	}
	
	// Trả về một đối tượng theo mã 
		public LichBay getOneObjLichBay(String maObj) { 
			LichBay lichBay = null;
		    try {
		        KetNoiDB.getInstance();
		        Connection con = KetNoiDB.getConnection();
		        String sql = "Select * from LichBay where MaLichBay = ?";
		        PreparedStatement preparedStatement = con.prepareStatement(sql);
		        preparedStatement.setString(1, maObj);
		        ResultSet rs = preparedStatement.executeQuery();
		        if (rs.next()) {
		        	String maLichBay = rs.getString("MaLichBay");
					String noiDi = rs.getString("NoiDi");
					String noiDen = rs.getString("NoiDen");
					LocalDateTime thoiGianDi = rs.getTimestamp("ThoiGianDi").toLocalDateTime();
					LocalDateTime thoiGianDen = rs.getTimestamp("ThoiGianDen").toLocalDateTime();
					lichBay = new LichBay(maLichBay, noiDi, noiDen, thoiGianDi, thoiGianDen);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return lichBay;
		}
	

	public String in() {
		return dsLichBay.toString();
	}
}
