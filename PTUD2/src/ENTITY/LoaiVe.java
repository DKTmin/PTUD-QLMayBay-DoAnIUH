package ENTITY;

import java.util.Objects;

public class LoaiVe {
	private String MaLoaiVe; 
	private String TenLoaiVe;
	
	
	
	public LoaiVe(String maLoaiVe) {
		super();
		MaLoaiVe = maLoaiVe;
	}

	public LoaiVe(String maLoaiVe, String tenLoaiVe) {
		super();
		MaLoaiVe = maLoaiVe;
		TenLoaiVe = tenLoaiVe;
	}

	public String getMaLoaiVe() {
		return MaLoaiVe;
	}

	public void setMaLoaiVe(String maLoaiVe) {
		MaLoaiVe = maLoaiVe;
	}

	public String getTenLoaiVe() {
		return TenLoaiVe;
	}

	public void setTenLoaiVe(String tenLoaiVe) {
		TenLoaiVe = tenLoaiVe;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(MaLoaiVe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiVe other = (LoaiVe) obj;
		return Objects.equals(MaLoaiVe, other.MaLoaiVe);
	}

	@Override
	public String toString() {
		return "LoaiVe [MaLoaiVe=" + MaLoaiVe + ", TenLoaiVe=" + TenLoaiVe + "]";
	}
	
	
	
}
