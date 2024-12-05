package ENTITY;

import java.util.Objects;

public class LoaiTaiKhoan {
	private String MaLoai; 
	private String TenLoai;
	
	
	
	public LoaiTaiKhoan(String maLoai) {
		super();
		MaLoai = maLoai;
	}

	public LoaiTaiKhoan(String maLoai, String tenLoai) {
		super();
		MaLoai = maLoai;
		TenLoai = tenLoai;
	}

	public String getMaLoai() {
		return MaLoai;
	}

	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}

	public String getTenLoai() {
		return TenLoai;
	}

	public void setTenLoai(String tenLoai) {
		TenLoai = tenLoai;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(MaLoai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiTaiKhoan other = (LoaiTaiKhoan) obj;
		return Objects.equals(MaLoai, other.MaLoai);
	}

	@Override
	public String toString() {
		return "LoaiTaiKhoan [MaLoai=" + MaLoai + ", TenLoai=" + TenLoai + "]";
	} 
	
	
}
