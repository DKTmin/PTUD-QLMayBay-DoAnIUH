package ENTITY;

import java.time.LocalDate;

public class ChiTietHoaDon {
	private HoaDon MaHoaDon; 
	private VeMayBay MaVe; 
	private NhanVien MaNhanVien; 
	private double TongTien; 
	private LocalDate NgayLapHoaDon;
	
	
	
	public ChiTietHoaDon(HoaDon maHoaDon, VeMayBay maVe, NhanVien maNhanVien, double tongTien,
			LocalDate ngayLapHoaDon) {
		super();
		MaHoaDon = maHoaDon;
		MaVe = maVe;
		MaNhanVien = maNhanVien;
		TongTien = tongTien;
		NgayLapHoaDon = ngayLapHoaDon;
	}



	public HoaDon getMaHoaDon() {
		return MaHoaDon;
	}



	public void setMaHoaDon(HoaDon maHoaDon) {
		MaHoaDon = maHoaDon;
	}



	public VeMayBay getMaVe() {
		return MaVe;
	}



	public void setMaVe(VeMayBay maVe) {
		MaVe = maVe;
	}



	public NhanVien getMaNhanVien() {
		return MaNhanVien;
	}



	public void setMaNhanVien(NhanVien maNhanVien) {
		MaNhanVien = maNhanVien;
	}



	public double getTongTien() {
		return TongTien;
	}



	public void setTongTien(double tongTien) {
		TongTien = tongTien;
	}



	public LocalDate getNgayLapHoaDon() {
		return NgayLapHoaDon;
	}



	public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
		NgayLapHoaDon = ngayLapHoaDon;
	}



	@Override
	public String toString() {
		return "ChiTietHoaDon [MaHoaDon=" + MaHoaDon + ", MaVe=" + MaVe + ", MaNhanVien=" + MaNhanVien + ", TongTien="
				+ TongTien + ", NgayLapHoaDon=" + NgayLapHoaDon + "]";
	} 
	
	
	
}
