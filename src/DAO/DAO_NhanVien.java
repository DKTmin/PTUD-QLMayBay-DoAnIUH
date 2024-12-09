package DAO;

import Connect.KetNoiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DAO_NhanVien {



    // Hàm thêm nhân viên và tài khoản
    public boolean addNhanVien(String maNV, String hoTen, String email, String diaChi,
            String soDienThoai, String gioiTinh, String imageFileName, String maTaiKhoan) {
String queryNhanVien = "INSERT INTO NhanVien (MaNhanVien, TenNhanVien, Email, DiaChi, SoDienThoai, GioiTinh, HinhAnh, MaTaiKhoan) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
String queryTaiKhoan = "INSERT INTO TaiKhoan (MaTaiKhoan, TenDangNhap, MatKhau, MaLoai) VALUES (?, NULL, NULL, NULL)"; // Các cột của bảng TaiKhoan sẽ có giá trị null

Connection conn = null;
PreparedStatement stmtNhanVien = null;
PreparedStatement stmtTaiKhoan = null;
try {
// Kết nối cơ sở dữ liệu
conn = KetNoiDB.getConnection();

// Bắt đầu transaction
conn.setAutoCommit(false);

// Thêm bản ghi vào bảng TaiKhoan
stmtTaiKhoan = conn.prepareStatement(queryTaiKhoan);
stmtTaiKhoan.setString(1, maTaiKhoan); // Sử dụng maTaiKhoan từ GUI
stmtTaiKhoan.executeUpdate();

// Thêm bản ghi vào bảng NhanVien
stmtNhanVien = conn.prepareStatement(queryNhanVien);
stmtNhanVien.setString(1, maNV);
stmtNhanVien.setString(2, hoTen);
stmtNhanVien.setString(3, email);
stmtNhanVien.setString(4, diaChi);
stmtNhanVien.setString(5, soDienThoai);
stmtNhanVien.setString(6, gioiTinh);
stmtNhanVien.setString(7, imageFileName);
stmtNhanVien.setString(8, maTaiKhoan); // Dùng maTaiKhoan từ GUI
stmtNhanVien.executeUpdate();

// Commit transaction
conn.commit();
return true;

} catch (SQLException e) {
// Rollback nếu có lỗi xảy ra
if (conn != null) {
try {
conn.rollback();
} catch (SQLException ex) {
ex.printStackTrace();
}
}
e.printStackTrace();
return false;
} finally {
// Đóng các kết nối và statement
try {
if (stmtNhanVien != null) stmtNhanVien.close();
if (stmtTaiKhoan != null) stmtTaiKhoan.close();
if (conn != null) conn.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
}

    // Lấy danh sách nhân viên và hiển thị trên bảng
    public DefaultTableModel loadDataToTable() {
        String[] columns = {"MaNhanVien", "TenNhanVien", "Email", "DiaChi", "SoDienThoai", "GioiTinh", "HinhAnh", "MaTaiKhoan"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        String sql = "SELECT * FROM NhanVien";
        try (Connection conn = KetNoiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String[] row = {
                    rs.getString("MaNhanVien"),
                    rs.getString("TenNhanVien"),
                    rs.getString("Email"),
                    rs.getString("DiaChi"),
                    rs.getString("SoDienThoai"),
                    rs.getString("GioiTinh"),
                    rs.getString("HinhAnh"),
                    rs.getString("MaTaiKhoan")
                };
                model.addRow(row); // Thêm một dòng vào table model
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }

 // Cập nhật thông tin nhân viên
    public boolean updateNhanVien(String maNhanVien, String tenNV, String email, String diaChi, String sdt, String gioiTinh, String hinhAnh) {
        // Cập nhật các thông tin khác mà không thay đổi mã nhân viên và mã tài khoản
        String sql = "UPDATE NhanVien SET TenNhanVien = ?, Email = ?, DiaChi = ?, SoDienThoai = ?, GioiTinh = ?, HinhAnh = ? WHERE MaNhanVien = ?";
        try (Connection conn = KetNoiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Set các giá trị muốn thay đổi
            ps.setString(1, tenNV);
            ps.setString(2, email);
            ps.setString(3, diaChi);
            ps.setString(4, sdt);
            ps.setString(5, gioiTinh);
            ps.setString(6, hinhAnh);

            // Set mã nhân viên để xác định bản ghi cần cập nhật
            ps.setString(7, maNhanVien);

            // Thực thi câu lệnh cập nhật
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // Nếu có dòng bị ảnh hưởng, trả về true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteNhanVien(String maNhanVien) {
        Connection conn = null;
        PreparedStatement psCheck = null;
        PreparedStatement psDelete = null;

        try {
            conn = KetNoiDB.getConnection();
            conn.setAutoCommit(false); // Bắt đầu giao dịch

            // Kiểm tra xem nhân viên có được tham chiếu trong bảng ChiTietHoaDon không
            String checkQuery = "SELECT COUNT(*) FROM ChiTietHoaDon WHERE MaNhanVien = ?";
            psCheck = conn.prepareStatement(checkQuery);
            psCheck.setString(1, maNhanVien);
            ResultSet rsCheck = psCheck.executeQuery();

            // Kiểm tra kết quả của truy vấn check
            if (rsCheck.next() && rsCheck.getInt(1) > 0) {
                // Nếu nhân viên được tham chiếu trong bảng ChiTietHoaDon, không cần cập nhật gì
                // Chỉ cần xóa nhân viên mà không thay đổi dữ liệu trong ChiTietHoaDon
                // Đảm bảo rằng các bảng khác không bị thay đổi giá trị MaNhanVien
            }

            // Xóa nhân viên khỏi bảng NhanVien
            String deleteQuery = "DELETE FROM NhanVien WHERE MaNhanVien = ?";
            psDelete = conn.prepareStatement(deleteQuery);
            psDelete.setString(1, maNhanVien);
            int rowsAffected = psDelete.executeUpdate();

            // Nếu xóa thành công, commit giao dịch
            if (rowsAffected > 0) {
                conn.commit();  // Commit giao dịch
                return true;
            } else {
                conn.rollback();  // Nếu không xóa được nhân viên, rollback
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();  // Nếu có lỗi, rollback giao dịch
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return false;
        } finally {
            try {
                if (psCheck != null) psCheck.close();
                if (psDelete != null) psDelete.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    // Kiểm tra xem mã nhân viên đã tồn tại trong cơ sở dữ liệu chưa
    public boolean isEmployeeExists(String maNhanVien) {
        String sql = "SELECT 1 FROM NhanVien WHERE MaNhanVien = ?";
        try (Connection conn = KetNoiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maNhanVien);
            ResultSet rs = ps.executeQuery();

            return rs.next(); // Nếu tìm thấy, trả về true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
