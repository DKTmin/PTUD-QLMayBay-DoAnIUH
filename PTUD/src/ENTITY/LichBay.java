package ENTITY;

import java.time.LocalDateTime;
import java.util.Objects;

public class LichBay {
	private String MaLichBay; 
	private String NoiDi; 
	private String NoiDen; 
	private LocalDateTime ThoiGianDi; 
	private LocalDateTime ThoiGianDen;
	
	
	
	public LichBay(String maLichBay) {
		super();
		MaLichBay = maLichBay;
	}



	public LichBay(String maLichBay, String noiDi, String noiDen, LocalDateTime thoiGianDi, LocalDateTime thoiGianDen) {
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



	public LocalDateTime getThoiGianDi() {
		return ThoiGianDi;
	}



	public void setThoiGianDi(LocalDateTime thoiGianDi) {
		ThoiGianDi = thoiGianDi;
	}



	public LocalDateTime getThoiGianDen() {
		return ThoiGianDen;
	}



	public void setThoiGianDen(LocalDateTime thoiGianDen) {
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



	@Override
	public String toString() {
		return "LichBay [MaLichBay=" + MaLichBay + ", NoiDi=" + NoiDi + ", NoiDen=" + NoiDen + ", ThoiGianDi="
				+ ThoiGianDi + ", ThoiGianDen=" + ThoiGianDen + "]";
	} 
	
	
	
}
