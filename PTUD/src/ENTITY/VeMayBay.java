package ENTITY;

import java.util.Objects;

public class VeMayBay {
	private String MaVe; 
	private HangBay MaHangBay; 
	private HangVe MaHangVe; 
	private LichBay MaLichBay; 
	private double Gia;
	
	
	
	public VeMayBay(String maVe) {
		super();
		MaVe = maVe;
	}



	public VeMayBay(String maVe, HangBay maHangBay, HangVe maHangVe, LichBay maLichBay, double gia) {
		super();
		MaVe = maVe;
		MaHangBay = maHangBay;
		MaHangVe = maHangVe;
		MaLichBay = maLichBay;
		Gia = gia;
	}



	public String getMaVe() {
		return MaVe;
	}



	public void setMaVe(String maVe) {
		MaVe = maVe;
	}



	public HangBay getMaHangBay() {
		return MaHangBay;
	}



	public void setMaHangBay(HangBay maHangBay) {
		MaHangBay = maHangBay;
	}



	public HangVe getMaHangVe() {
		return MaHangVe;
	}



	public void setMaHangVe(HangVe maHangVe) {
		MaHangVe = maHangVe;
	}



	public LichBay getMaLichBay() {
		return MaLichBay;
	}



	public void setMaLichBay(LichBay maLichBay) {
		MaLichBay = maLichBay;
	}



	public double getGia() {
		return Gia;
	}



	public void setGia(double gia) {
		Gia = gia;
	}
	
	


	@Override
	public int hashCode() {
		return Objects.hash(MaVe);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VeMayBay other = (VeMayBay) obj;
		return Objects.equals(MaVe, other.MaVe);
	}



	@Override
	public String toString() {
		return "VeMayBay [MaVe=" + MaVe + ", MaHangBay=" + MaHangBay + ", MaHangVe=" + MaHangVe + ", MaLichBay="
				+ MaLichBay + ", Gia=" + Gia + "]";
	} 
	
	
	
}
