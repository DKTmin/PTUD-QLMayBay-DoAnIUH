package GUI;

import javax.swing.JFrame;
import DAO.DAO_LoaiTaiKhoan;

public class Run {
    public static void main(String[] args) {
        // Hiển thị giao diện đăng nhập
        
        GUI_DangNhap dangNhapGUI = new GUI_DangNhap();
       
        dangNhapGUI.setVisible(true);
        dangNhapGUI.setResizable(false);
        dangNhapGUI.setLocationRelativeTo(null);

        // Sau khi đăng nhập thành công (giả sử có logic đăng nhập), mở giao diện chính
        // Đây là ví dụ minh họa
        boolean isLoginSuccessful = true; // Thay bằng logic kiểm tra đăng nhập thực tế
        if (isLoginSuccessful) {
            // Đóng giao diện đăng nhập
            dangNhapGUI.dispose();

            // Hiển thị giao diện quản lý
            GUI_HOME_QuanLy homeQuanLyGUI = new GUI_HOME_QuanLy();
            homeQuanLyGUI.setVisible(true);
            homeQuanLyGUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
            homeQuanLyGUI.setUndecorated(true);
        }

        // Ví dụ: Thực hiện các thao tác DAO
        DAO_LoaiTaiKhoan daoLoaiTaiKhoan = new DAO_LoaiTaiKhoan();
        daoLoaiTaiKhoan.getalltbLoaiTaiKhoan();
        System.out.println(daoLoaiTaiKhoan.in());
    }
}
