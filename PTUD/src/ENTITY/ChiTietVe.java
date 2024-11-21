package ENTITY;

import java.util.Objects;

public class ChiTietVe {
	private TrangThaiGhe MaTrangThaiGhe; 
	private LoaiVe MaLoaiVe; 
	private KhachHang MaKhachHang; 
	private NhanVien MaNhanVien;
	
	
	
	
	public ChiTietVe(TrangThaiGhe maTrangThaiGhe) {
		super();
		MaTrangThaiGhe = maTrangThaiGhe;
	}




	public ChiTietVe(TrangThaiGhe maTrangThaiGhe, LoaiVe maLoaiVe, KhachHang maKhachHang, NhanVien maNhanVien) {
		super();
		MaTrangThaiGhe = maTrangThaiGhe;
		MaLoaiVe = maLoaiVe;
		MaKhachHang = maKhachHang;
		MaNhanVien = maNhanVien;
	}




	public TrangThaiGhe getMaTrangThaiGhe() {
		return MaTrangThaiGhe;
	}




	public void setMaTrangThaiGhe(TrangThaiGhe maTrangThaiGhe) {
		MaTrangThaiGhe = maTrangThaiGhe;
	}




	public LoaiVe getMaLoaiVe() {
		return MaLoaiVe;
	}




	public void setMaLoaiVe(LoaiVe maLoaiVe) {
		MaLoaiVe = maLoaiVe;
	}




	public KhachHang getMaKhachHang() {
		return MaKhachHang;
	}




	public void setMaKhachHang(KhachHang maKhachHang) {
		MaKhachHang = maKhachHang;
	}




	public NhanVien getMaNhanVien() {
		return MaNhanVien;
	}




	public void setMaNhanVien(NhanVien maNhanVien) {
		MaNhanVien = maNhanVien;
	}




	@Override
	public int hashCode() {
		return Objects.hash(MaTrangThaiGhe);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietVe other = (ChiTietVe) obj;
		return Objects.equals(MaTrangThaiGhe, other.MaTrangThaiGhe);
	}




	@Override
	public String toString() {
		return "ChiTietVe [MaTrangThaiGhe=" + MaTrangThaiGhe + ", MaLoaiVe=" + MaLoaiVe + ", MaKhachHang=" + MaKhachHang
				+ ", MaNhanVien=" + MaNhanVien + "]";
	}
	
	
	
	
	
}
