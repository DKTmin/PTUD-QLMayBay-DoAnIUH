package ENTITY;

import java.util.Objects;

public class TrangThaiGhe {
	private String MaChiTietTrangThai; 
	private Ghe MaGhe;
	private LichBay MaLichBay;
	private boolean TrangThai;
	
	
	
	public TrangThaiGhe(String maChiTietTrangThai) {
		super();
		MaChiTietTrangThai = maChiTietTrangThai;
	}



	public TrangThaiGhe(String maChiTietTrangThai, Ghe maGhe, LichBay maLichBay, boolean trangThai) {
		super();
		MaChiTietTrangThai = maChiTietTrangThai;
		MaGhe = maGhe;
		MaLichBay = maLichBay;
		TrangThai = trangThai;
	}



	public String getMaChiTietTrangThai() {
		return MaChiTietTrangThai;
	}



	public void setMaChiTietTrangThai(String maChiTietTrangThai) {
		MaChiTietTrangThai = maChiTietTrangThai;
	}



	public Ghe getMaGhe() {
		return MaGhe;
	}



	public void setMaGhe(Ghe maGhe) {
		MaGhe = maGhe;
	}



	public LichBay getMaLichBay() {
		return MaLichBay;
	}



	public void setMaLichBay(LichBay maLichBay) {
		MaLichBay = maLichBay;
	}



	public boolean isTrangThai() {
		return TrangThai;
	}



	public void setTrangThai(boolean trangThai) {
		TrangThai = trangThai;
	}



	@Override
	public int hashCode() {
		return Objects.hash(MaChiTietTrangThai);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrangThaiGhe other = (TrangThaiGhe) obj;
		return Objects.equals(MaChiTietTrangThai, other.MaChiTietTrangThai);
	}



	@Override
	public String toString() {
		return "TrangThaiGhe [MaChiTietTrangThai=" + MaChiTietTrangThai + ", MaGhe=" + MaGhe + ", MaLichBay="
				+ MaLichBay + ", TrangThai=" + TrangThai + "]";
	} 
	
	
}
