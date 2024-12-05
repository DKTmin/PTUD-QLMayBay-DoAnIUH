package ENTITY;

import java.util.Objects;

public class Ghe {
	private String MaGhe; 
	private String TenGhe;
	
	public Ghe(String maGhe, String tenGhe) {
		super();
		MaGhe = maGhe;
		TenGhe = tenGhe;
	}
	
	
	public Ghe(String maGhe) {
		super();
		MaGhe = maGhe;
	}


	public String getMaGhe() {
		return MaGhe;
	}

	public void setMaGhe(String maGhe) {
		MaGhe = maGhe;
	}

	public String getTenGhe() {
		return TenGhe;
	}

	public void setTenGhe(String tenGhe) {
		TenGhe = tenGhe;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(MaGhe);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ghe other = (Ghe) obj;
		return Objects.equals(MaGhe, other.MaGhe);
	}


	@Override
	public String toString() {
		return "Ghe [MaGhe=" + MaGhe + ", TenGhe=" + TenGhe + "]";
	} 
	
	
	
}
