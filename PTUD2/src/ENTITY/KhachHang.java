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
public class KhachHang {
	private String MaKhachHang;
	private String TenKhachHang;
	private String SoDienThoai;
	private String Email;
	private String GioiTinh;
	private String ChungMinhNhanDan;
	
	public KhachHang(String maKhachHang) {
		super();
		MaKhachHang = maKhachHang;
	}
	
	public KhachHang(String maKhachHang, String tenKhachHang, String soDienThoai, String email, String gioiTinh,
			String chungMinhNhanDan) {
		super();
		MaKhachHang = maKhachHang;
		TenKhachHang = tenKhachHang;
		SoDienThoai = soDienThoai;
		Email = email;
		GioiTinh = gioiTinh;
		ChungMinhNhanDan = chungMinhNhanDan;
	}
	
	
	public String getMaKhachHang() {
		return MaKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		MaKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return TenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		TenKhachHang = tenKhachHang;
	}

	public String getSoDienThoai() {
		return SoDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getChungMinhNhanDan() {
		return ChungMinhNhanDan;
	}

	public void setChungMinhNhanDan(String chungMinhNhanDan) {
		ChungMinhNhanDan = chungMinhNhanDan;
	}

	@Override
	public int hashCode() {
		return Objects.hash(MaKhachHang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(MaKhachHang, other.MaKhachHang);
	}
	
	@Override
	public String toString() {
		return "KhachHang [MaKhachHang=" + MaKhachHang + ", TenKhachHang=" + TenKhachHang + ", SoDienThoai="
				+ SoDienThoai + ", Email=" + Email + ", GioiTinh=" + GioiTinh + ", ChungMinhNhanDan=" + ChungMinhNhanDan
				+ "]";
	}
	
	
	
	
}
