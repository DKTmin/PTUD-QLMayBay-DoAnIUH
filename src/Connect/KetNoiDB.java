package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class KetNoiDB {
    // Biến kết nối toàn cục
    private static Connection con = null;
    
    // Cài đặt mô hình Singleton
    private static KetNoiDB instance = new KetNoiDB();

    // Phương thức lấy instance duy nhất
    public static KetNoiDB getInstance() {
        return instance;
    }

    // Phương thức kết nối đến cơ sở dữ liệu
    public static void connect() {
        try {
            // Chuỗi kết nối đúng cho SQL Server
            String url = "jdbc:sqlserver://localhost:1433;databaseName=PTUD_DataBase"; // Đảm bảo 'databaseName'
            String user = "sa";
            String password = "1111";

            // Cố gắng kết nối
            if (con == null || con.isClosed()) {
                con = DriverManager.getConnection(url, user, password);
                System.out.println("Kết nối đến cơ sở dữ liệu thành công!");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối cơ sở dữ liệu: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Phương thức ngắt kết nối
    public void disconnect() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Đã ngắt kết nối!");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi ngắt kết nối: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Phương thức lấy kết nối (Singleton)
    public static Connection getConnection() throws SQLException {
        if (con == null || con.isClosed()) {
            connect();
        }
        return con;
    }

    // Phương thức main để kiểm tra kết nối
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
