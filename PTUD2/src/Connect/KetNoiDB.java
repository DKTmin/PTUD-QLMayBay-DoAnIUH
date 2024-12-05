/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class KetNoiDB {
	public static Connection con = null;
	private static KetNoiDB instance = new KetNoiDB();

	public static KetNoiDB getInstance() {
		return instance;
	}

	public static void connect() {
		try {
			String url = "jdbc:sqlserver://localhost:1433;databasename=PTUD_DataBase";
			String user = "sa";
			String password = "1111";
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if (con == null) {
			connect();
		}
		return con;
	}
	
	public static void main(String[] args) {
        try {
            // Lấy instance của KetNoiDB
            KetNoiDB ketNoiDB = KetNoiDB.getInstance();

            // Kết nối đến cơ sở dữ liệu
            ketNoiDB.connect();

            // Kiểm tra kết nối
            Connection connection = KetNoiDB.getConnection();
            if (connection != null && !connection.isClosed()) {
                System.out.println("Kết nối đến cơ sở dữ liệu thành công!");
            } else {
                System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
            }

            // Đóng kết nối
            ketNoiDB.disconnect();
            
        } catch (SQLException e) {
            System.out.println("Lỗi xảy ra: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
