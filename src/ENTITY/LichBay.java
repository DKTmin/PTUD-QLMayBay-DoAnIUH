package ENTITY;

import java.time.LocalDate;
import java.util.Objects;

public class LichBay {
	private String MaLichBay; 
	private String NoiDi; 
	private String NoiDen; 
	private LocalDate ThoiGianDi; 
	private LocalDate ThoiGianDen;
	
	
	
	public LichBay(String maLichBay) {
		super();
		MaLichBay = maLichBay;
	}



	public LichBay(String maLichBay, String noiDi, String noiDen, LocalDate thoiGianDi, LocalDate thoiGianDen) {
		super();
		MaLichBay = maLichBay;
		NoiDi = noiDi;
		NoiDen = noiDen;
		ThoiGianDi = thoiGianDi;
		ThoiGianDen = thoiGianDen;
	}
	
	


	public String getMaLichBay() {
		return MaLichBay;
	}



	public void setMaLichBay(String maLichBay) {
		MaLichBay = maLichBay;
	}



	public String getNoiDi() {
		return NoiDi;
	}



	public void setNoiDi(String noiDi) {
		NoiDi = noiDi;
	}



	public String getNoiDen() {
		return NoiDen;
	}



	public void setNoiDen(String noiDen) {
		NoiDen = noiDen;
	}



	public LocalDate getThoiGianDi() {
		return ThoiGianDi;
	}



	public void setThoiGianDi(LocalDate thoiGianDi) {
		ThoiGianDi = thoiGianDi;
	}



	public LocalDate getThoiGianDen() {
		return ThoiGianDen;
	}



	public void setThoiGianDen(LocalDate thoiGianDen) {
		ThoiGianDen = thoiGianDen;
	}



	@Override
	public int hashCode() {
		return Objects.hash(MaLichBay);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LichBay other = (LichBay) obj;
		return Objects.equals(MaLichBay, other.MaLichBay);
	} 
	
	
	
}
