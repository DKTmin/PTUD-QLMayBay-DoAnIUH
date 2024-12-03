package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connect.KetNoiDB;
import ENTITY.Ghe;

public class DAO_Ghe {
	private ArrayList<Ghe> dsGhe;

	// Trả về hết một danh sách hãng bay
	public ArrayList<Ghe> getalltbGhe() {
		dsGhe = new ArrayList<Ghe>();
		try {
			KetNoiDB.getInstance();
			Connection con = KetNoiDB.getConnection();
			String sql = "Select * from Ghe";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {

				String maGhe = rs.getString("MaGhe");
				String tenGhe = rs.getString("TenGhe");

				Ghe g = new Ghe(maGhe, tenGhe);
				dsGhe.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsGhe;
	}

	public String in() {
		String in = null;
		for (Ghe ghe : dsGhe) {
			in = in + ghe.toString() + "\n";
		}
		return in; // Trả về chuỗi kết quả

	}
}
