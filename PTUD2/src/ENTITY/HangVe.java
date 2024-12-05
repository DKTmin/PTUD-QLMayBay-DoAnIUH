package ENTITY;

import java.util.Objects;

public class HangVe {
	private String MaHangVe; 
	private String TenHangVe;
	
	public HangVe(String maHangVe, String tenHangVe) {
		super();
		MaHangVe = maHangVe;
		TenHangVe = tenHangVe;
	}
	
	
	
	public HangVe(String maHangVe) {
		super();
		MaHangVe = maHangVe;
	}



	public String getMaHangVe() {
		return MaHangVe;
	}
	public void setMaHangVe(String maHangVe) {
		MaHangVe = maHangVe;
	}
	public String getTenHangVe() {
		return TenHangVe;
	}
	public void setTenHangVe(String tenHangVe) {
		TenHangVe = tenHangVe;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(MaHangVe);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HangVe other = (HangVe) obj;
		return Objects.equals(MaHangVe, other.MaHangVe);
	} 
	
	@Override
	public String toString() {
		return "HangVe [MaHangVe=" + MaHangVe + ", TenHangVe=" + TenHangVe + "]";
	}

	
}
