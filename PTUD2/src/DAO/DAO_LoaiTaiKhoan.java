package DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connect.KetNoiDB;
import ENTITY.LoaiTaiKhoan;

public class DAO_LoaiTaiKhoan {
	private ArrayList<LoaiTaiKhoan> dsLoaiTaiKhoan;

	public ArrayList<LoaiTaiKhoan> getalltbLoaiTaiKhoan(){
		dsLoaiTaiKhoan = new ArrayList<LoaiTaiKhoan>();
		try {
			KetNoiDB.getInstance();
			Connection con = KetNoiDB.getConnection();
			String sql = "Select * from LoaiTaiKhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maLoaiTaiKhoan = rs.getString("MaLoai");
				String tenLoaiTaiKhoan  = rs.getString("TenLoai");
				
				LoaiTaiKhoan ltk = new LoaiTaiKhoan(maLoaiTaiKhoan, tenLoaiTaiKhoan); 
				
				dsLoaiTaiKhoan.add(ltk);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLoaiTaiKhoan;
	}
	
	public String in(){ 
		return dsLoaiTaiKhoan.toString(); 
	}
}
