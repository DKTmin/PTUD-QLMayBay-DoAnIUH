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
public class NhanVien {
    private String MaNhanVien; 
    private String TenNhanVien; 
    private String Email;
    private String DiaChi;
    private String SoDienThoai;
    private String GioiTinh;
    private String HinhAnh;
    private TaiKhoan MaTaiKhoan;
    
	public NhanVien(String maNhanVien) {
		super();
		MaNhanVien = maNhanVien;
	}

	public NhanVien(String maNhanVien, String tenNhanVien, String email, String diaChi, String soDienThoai,
			String gioiTinh, String hinhAnh, TaiKhoan maTaiKhoan) {
		super();
		MaNhanVien = maNhanVien;
		TenNhanVien = tenNhanVien;
		Email = email;
		DiaChi = diaChi;
		SoDienThoai = soDienThoai;
		GioiTinh = gioiTinh;
		HinhAnh = hinhAnh;
		MaTaiKhoan = maTaiKhoan;
	}
	
	

	public String getMaNhanVien() {
		return MaNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return TenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		TenNhanVien = tenNhanVien;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getSoDienThoai() {
		return SoDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getHinhAnh() {
		return HinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		HinhAnh = hinhAnh;
	}

	public TaiKhoan getMaTaiKhoan() {
		return MaTaiKhoan;
	}

	public void setMaTaiKhoan(TaiKhoan maTaiKhoan) {
		MaTaiKhoan = maTaiKhoan;
	}

	@Override
	public int hashCode() {
		return Objects.hash(MaNhanVien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(MaNhanVien, other.MaNhanVien);
	}

	@Override
	public String toString() {
		return "NhanVien [MaNhanVien=" + MaNhanVien + ", TenNhanVien=" + TenNhanVien + ", Email=" + Email + ", DiaChi="
				+ DiaChi + ", SoDienThoai=" + SoDienThoai + ", GioiTinh=" + GioiTinh + ", HinhAnh=" + HinhAnh
				+ ", MaTaiKhoan=" + MaTaiKhoan + "]";
	}
    
	
    
   
}
