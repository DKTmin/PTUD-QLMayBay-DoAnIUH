CREATE DATABASE PTUD_DataBase;
go

USE PTUD_DataBase;
go 

-- Bảng LoaiTaiKhoan
CREATE TABLE LoaiTaiKhoan (
    MaLoai VARCHAR(50) PRIMARY KEY,
    TenLoai NVARCHAR(100)
);

-- Bảng TaiKhoan
CREATE TABLE TaiKhoan (
    MaTaiKhoan VARCHAR(50) PRIMARY KEY,
    TenDangNhap NVARCHAR(100),
    MatKhau NVARCHAR(255),
    MaLoai VARCHAR(50),
    FOREIGN KEY (MaLoai) REFERENCES LoaiTaiKhoan(MaLoai)
);

-- Bảng NhanVien
CREATE TABLE NhanVien (
    MaNhanVien VARCHAR(50) PRIMARY KEY,
    TenNhanVien NVARCHAR(100),
    Email NVARCHAR(100),
    DiaChi NVARCHAR(255),
    SoDienThoai NVARCHAR(20),
    GioiTinh NVARCHAR(10),
    HinhAnh NVARCHAR(255),
	MaTaiKhoan VARCHAR(50), 
	FOREIGN KEY (MaTaiKhoan) REFERENCES TaiKhoan(MaTaiKhoan)
);

-- Bảng KhachHang
CREATE TABLE KhachHang (
    MaKhachHang VARCHAR(50) PRIMARY KEY,
    TenKhachHang NVARCHAR(100),
    SoDienThoai NVARCHAR(20),
    Email NVARCHAR(100),
    GioiTinh NVARCHAR(10),
    ChungMinhNhanDan NVARCHAR(20)
);

-- Bảng LichBay
CREATE TABLE LichBay (
    MaLichBay VARCHAR(50) PRIMARY KEY,
    NoiDi NVARCHAR(100),
    NoiDen NVARCHAR(100),
    ThoiGianDi DATETIME,
    ThoiGianDen DATETIME
);

-- Bảng HangVe
CREATE TABLE HangVe	 (
    MaHangVe VARCHAR(50) PRIMARY KEY,
    TenHangBay NVARCHAR(100)
);

-- Bảng HangBay
CREATE TABLE HangBay (
    MaHangBay VARCHAR(50) PRIMARY KEY,
    TenHangBay NVARCHAR(100),
    QuocGia NVARCHAR(100),
    HinhAnh NVARCHAR(255)
);

-- Bảng VeMayBay
CREATE TABLE VeMayBay (
    MaVe VARCHAR(50) PRIMARY KEY,
    MaHangBay VARCHAR(50),
	MaLichBay VARCHAR(50),
	MaHangVe VARCHAR(50),
    Gia DECIMAL(18, 2),
    FOREIGN KEY (MaHangBay) REFERENCES HangBay(MaHangBay),
	FOREIGN KEY (MaLichBay) REFERENCES LichBay(MaLichBay),
	FOREIGN KEY (MaHangVe) REFERENCES HangVe(MaHangVe)
);


-- Bảng HoaDon
CREATE TABLE HoaDon (
    MaHoaDon VARCHAR(50) PRIMARY KEY,
    MaKhachHang VARCHAR(50),
    SoLuong INT,
    Gia DECIMAL(18, 2),
    FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang)
);



-- Bảng ChiTietHoaDon
CREATE TABLE ChiTietHoaDon (
    MaHoaDon VARCHAR(50),
    MaVe VARCHAR(50),
    MaNhanVien VARCHAR(50),
    TongTien DECIMAL(18, 2),
    NgayLapHoaDon DATE,
    PRIMARY KEY (MaHoaDon, MaVe, MaNhanVien),
    FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon), 
    FOREIGN KEY (MaVe) REFERENCES VeMayBay(MaVe),
    FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
);


-- Bảng LoaiVe
CREATE TABLE LoaiVe (
    MaLoaiVe VARCHAR(50) PRIMARY KEY,
    TenLoaiVe NVARCHAR(100)
);


-- Bảng Ghe
CREATE TABLE Ghe (
    MaGhe VARCHAR(50) PRIMARY KEY,
    TenGhe NVARCHAR(100)
);

-- Bảng TrangThaiGhe
CREATE TABLE TrangThaiGhe (
    MaChiTietTrangThai VARCHAR(50) PRIMARY KEY,
    MaGhe VARCHAR(50),
    MaLichBay VARCHAR(50),
    TrangThai BIT, -- hoặc BOOLEAN nếu hệ quản trị cơ sở dữ liệu hỗ trợ
    FOREIGN KEY (MaGhe) REFERENCES Ghe(MaGhe),
    FOREIGN KEY (MaLichBay) REFERENCES LichBay(MaLichBay)
);

-- Bảng ChiTietVe
CREATE TABLE ChiTietVe (
    MaTrangThaiGhe VARCHAR(50) PRIMARY KEY,
    MaLoaiVe VARCHAR(50),
    MaKhachHang VARCHAR(50), 
    MaNhanVien VARCHAR(50), 
    FOREIGN KEY (MaLoaiVe) REFERENCES LoaiVe(MaLoaiVe),
    FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien),
    FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang),
    FOREIGN KEY (MaTrangThaiGhe) REFERENCES TrangThaiGhe(MaChiTietTrangThai)
);


-- Thêm dữ liệu vào bảng LoaiTaiKhoan
INSERT INTO LoaiTaiKhoan (MaLoai, TenLoai) 
VALUES 
('LTK001', 'Admin'), 
('LTK002', 'Nhân viên'), 
('LTK003', 'Khách hàng');
GO

-- Thêm dữ liệu vào bảng TaiKhoan
INSERT INTO TaiKhoan (MaTaiKhoan, TenDangNhap, MatKhau, MaLoai) 
VALUES 
('TK001', 'admin', '123456', 'LTK001'),
('TK002', 'nhanvien01', 'abcdef', 'LTK002'),
('TK003', 'nhanvien02', '123abc', 'LTK002'),
('TK004', 'khachhang01', '123456', 'LTK003'),
('TK005', 'khachhang02', 'abcdef', 'LTK003');
GO

-- Thêm dữ liệu vào bảng NhanVien
INSERT INTO NhanVien (MaNhanVien, TenNhanVien, Email, DiaChi, SoDienThoai, GioiTinh, HinhAnh, MaTaiKhoan)
VALUES 
('NV001', 'Nguyễn Văn A', 'a@gmail.com', 'Hà Nội', '0901234567', 'Nam', '', 'TK002'),
('NV002', 'Trần Thị B', 'b@gmail.com', 'Hồ Chí Minh', '0902345678', 'Nữ', '', 'TK003');
GO

-- Thêm dữ liệu vào bảng KhachHang
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, SoDienThoai, Email, GioiTinh, ChungMinhNhanDan) 
VALUES 
('KH001', 'Nguyễn Văn C', '0912345678', 'c@gmail.com', 'Nam', '123456789'),
('KH002', 'Trần Thị D', '0923456789', 'd@gmail.com', 'Nữ', '987654321');
GO

-- Thêm dữ liệu vào bảng LichBay
INSERT INTO LichBay (MaLichBay, NoiDi, NoiDen, ThoiGianDi, ThoiGianDen)
VALUES 
('LB001', 'Hà Nội', 'Hồ Chí Minh', '2024-11-20 08:00', '2024-11-20 10:00'),
('LB002', 'Hồ Chí Minh', 'Đà Nẵng', '2024-11-21 15:00', '2024-11-21 16:30');
GO

-- Thêm dữ liệu vào bảng HangVe
INSERT INTO HangVe (MaHangVe, TenHangBay)
VALUES 
('HV001', 'Thương gia'), 
('HV002', 'Phổ thông');
GO

-- Thêm dữ liệu vào bảng HangBay
INSERT INTO HangBay (MaHangBay, TenHangBay, QuocGia, HinhAnh) 
VALUES 
('HB001', 'Vietnam Airlines', 'Việt Nam', ''),
('HB002', 'VietJet Air', 'Việt Nam', '');
GO

-- Thêm dữ liệu vào bảng VeMayBay
INSERT INTO VeMayBay (MaVe, MaHangBay, MaLichBay, MaHangVe, Gia)
VALUES 
('VE001', 'HB001', 'LB001', 'HV001', 2000000),
('VE002', 'HB002', 'LB002', 'HV002', 1000000);
GO

-- Thêm dữ liệu vào bảng HoaDon
INSERT INTO HoaDon (MaHoaDon, MaKhachHang, SoLuong, Gia)
VALUES 
('HD001', 'KH001', 2, 4000000),
('HD002', 'KH002', 1, 1000000);
GO

-- Thêm dữ liệu vào bảng ChiTietHoaDon
INSERT INTO ChiTietHoaDon (MaHoaDon, MaVe, MaNhanVien, TongTien, NgayLapHoaDon)
VALUES 
('HD001', 'VE001', 'NV001', 4000000, '2024-11-19'),
('HD002', 'VE002', 'NV002', 1000000, '2024-11-19');
GO

-- Thêm dữ liệu vào bảng LoaiVe
INSERT INTO LoaiVe (MaLoaiVe, TenLoaiVe)
VALUES 
('LV001', 'Khứ hồi'), 
('LV002', 'Một chiều');
GO

-- Thêm dữ liệu vào bảng Ghe
INSERT INTO Ghe (MaGhe, TenGhe)
VALUES 
('G001', 'Ghế 1A'), 
('G002', 'Ghế 1B'), 
('G003', 'Ghế 2A');
GO

-- Thêm dữ liệu vào bảng TrangThaiGhe
INSERT INTO TrangThaiGhe (MaChiTietTrangThai, MaGhe, MaLichBay, TrangThai)
VALUES 
('TTG001', 'G001', 'LB001', 1),
('TTG002', 'G002', 'LB001', 0);
GO

-- Thêm dữ liệu vào bảng ChiTietVe
INSERT INTO ChiTietVe (MaTrangThaiGhe, MaLoaiVe, MaKhachHang, MaNhanVien)
VALUES 
('TTG001', 'LV001', 'KH001', 'NV001'),
('TTG002', 'LV002', 'KH002', 'NV002');
GO

