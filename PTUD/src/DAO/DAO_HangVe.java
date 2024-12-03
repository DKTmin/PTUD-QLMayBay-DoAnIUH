package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connect.KetNoiDB;
import ENTITY.HangVe;

public class DAO_HangVe {
	// Dao

	private ArrayList<HangVe> dsHangVe;

	// Trả về hết một danh sách hãng Ve
	public ArrayList<HangVe> getalltbHangVe() {
		dsHangVe = new ArrayList<HangVe>();
		try {
			KetNoiDB.getInstance();
			Connection con = KetNoiDB.getConnection();
			String sql = "Select * from HangVe";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {

				String maHangBay = rs.getString("MaHangVe");
				String tenHangBay = rs.getString("TenHangVe");

				HangVe hv = new HangVe(maHangBay, tenHangBay); 
				dsHangVe.add(hv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHangVe;
	}

	// Trả về một đối tượng theo mã
	public HangVe getOneObjHangVe(String maObj) {
		HangVe hangVe = null;
		try {
			KetNoiDB.getInstance();
			Connection con = KetNoiDB.getConnection();
			String sql = "Select * from HangVe where MaHangVe = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maObj);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				String maHangVe = rs.getString("MaHangVe");
				String tenHangVe = rs.getString("TenHangVe");

				hangVe = new HangVe(maHangVe, tenHangVe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hangVe;
	}

	public String in() {
		return dsHangVe.toString();
	}
}
