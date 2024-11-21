/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.util.Objects;

/**
 *
 * @author ADMIN
 */
public class TaiKhoan {
    private String MaTaiKhoan; 
    private String TenDangNhap; 
    private String MatKhau; 
    private LoaiTaiKhoan MaLoai;
    
	public TaiKhoan(String maTaiKhoan) {
		super();
		MaTaiKhoan = maTaiKhoan;
	}

	public TaiKhoan(String maTaiKhoan, String tenDangNhap, String matKhau, LoaiTaiKhoan maLoai) {
		super();
		MaTaiKhoan = maTaiKhoan;
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
		MaLoai = maLoai;
	}

	public String getMaTaiKhoan() {
		return MaTaiKhoan;
	}

	public void setMaTaiKhoan(String maTaiKhoan) {
		MaTaiKhoan = maTaiKhoan;
	}

	public String getTenDangNhap() {
		return TenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return MatKhau;
	}

	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}

	public LoaiTaiKhoan getMaLoai() {
		return MaLoai;
	}

	public void setMaLoai(LoaiTaiKhoan maLoai) {
		MaLoai = maLoai;
	}

	@Override
	public int hashCode() {
		return Objects.hash(MaTaiKhoan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(MaTaiKhoan, other.MaTaiKhoan);
	}

	@Override
	public String toString() {
		return "TaiKhoan [MaTaiKhoan=" + MaTaiKhoan + ", TenDangNhap=" + TenDangNhap + ", MatKhau=" + MatKhau
				+ ", MaLoai=" + MaLoai + "]";
	} 
    
    
    
}
