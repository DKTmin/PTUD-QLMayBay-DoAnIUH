package ENTITY;

import java.util.Objects;

public class HangBay {
	private String MaHangBay; 
	private String TenHangBay; 
	private String QuocGia; 
	private String HinhAnh;
	
	
	
	public HangBay(String maHangBay) {
		super();
		MaHangBay = maHangBay;
	}

	public HangBay(String maHangBay, String tenHangBay, String quocGia, String hinhAnh) {
		super();
		MaHangBay = maHangBay;
		TenHangBay = tenHangBay;
		QuocGia = quocGia;
		HinhAnh = hinhAnh;
	}
	
	public String getMaHangBay() {
		return MaHangBay;
	}
	public void setMaHangBay(String maHangBay) {
		MaHangBay = maHangBay;
	}
	public String getTenHangBay() {
		return TenHangBay;
	}
	public void setTenHangBay(String tenHangBay) {
		TenHangBay = tenHangBay;
	}
	public String getQuocGia() {
		return QuocGia;
	}
	public void setQuocGia(String quocGia) {
		QuocGia = quocGia;
	}
	public String getHinhAnh() {
		return HinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		HinhAnh = hinhAnh;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(HinhAnh);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HangBay other = (HangBay) obj;
		return Objects.equals(HinhAnh, other.HinhAnh);
	}

	@Override
	public String toString() {
		return "HangBay [MaHangBay=" + MaHangBay + ", TenHangBay=" + TenHangBay + ", QuocGia=" + QuocGia + ", HinhAnh="
				+ HinhAnh + "]";
	} 
	
	
}
