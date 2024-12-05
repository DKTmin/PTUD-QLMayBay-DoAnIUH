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
    TenHangVe NVARCHAR(100)
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
('LTK001', N'Admin'), 
('LTK002', N'Nhân viên'), 
('LTK003', N'Khách hàng');
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
('NV001', N'Nguyễn Văn A', 'a@gmail.com', N'Hà Nội', '0901234567', 'Nam', '', 'TK002'),
('NV002', N'Trần Thị B', 'b@gmail.com', N'Hồ Chí Minh', '0902345678', 'Nữ', '', 'TK003');
GO

-- Thêm dữ liệu vào bảng KhachHang
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, SoDienThoai, Email, GioiTinh, ChungMinhNhanDan) 
VALUES 
('KH001', N'Nguyễn Văn C', '0912345678', 'c@gmail.com', N'Nam', '123456789'),
('KH002', N'Trần Thị D', '0923456789', 'd@gmail.com', N'Nữ', '987654321');
GO

-- Thêm dữ liệu vào bảng LichBay
INSERT INTO LichBay (MaLichBay, NoiDi, NoiDen, ThoiGianDi, ThoiGianDen)
VALUES 
('LB001', N'Hà Nội', N'Hồ Chí Minh', '2024-11-20 08:00', '2024-11-20 10:00'),
('LB002', N'Hồ Chí Minh', N'Đà Nẵng', '2024-11-21 15:00', '2024-11-21 16:30');
GO

-- Thêm dữ liệu vào bảng HangVe
INSERT INTO HangVe (MaHangVe, TenHangBay)
VALUES 
('HV001', N'Thương gia'), 
('HV002', N'Phổ thông');
GO

-- Thêm dữ liệu vào bảng HangBay
INSERT INTO HangBay (MaHangBay, TenHangBay, QuocGia, HinhAnh) 
VALUES 
('HB001', 'Vietnam Airlines', N'Việt Nam', ''),
('HB002', 'VietJet Air', N'Việt Nam', '');
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
('LV001', N'Khứ hồi'), 
('LV002', N'Một chiều');
GO

-- Thêm dữ liệu vào bảng Ghe
INSERT INTO Ghe (MaGhe, TenGhe)
VALUES 
('G001', N'Cạnh Đường'), 
('G002', N'Cạnh Đường'), 
('G003', N'Cạnh Đường');
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


-------------------------------------------------------------
-- Thêm Hãng Bay
INSERT INTO HangBay (MaHangBay, TenHangBay, QuocGia, HinhAnh)
VALUES
('HB003', 'Bamboo Airways', N'Việt Nam', ''),
('HB004', 'Pacific Airlines', N'Việt Nam', ''),
('HB005', 'AirAsia', 'Malaysia', ''),
('HB006', 'Singapore Airlines', N'Singapore', ''),
('HB007', 'Thai Airways', N'Thái Lan', ''),
('HB008', 'Cathay Pacific', N'Hồng Kông', ''),
('HB009', 'Qatar Airways', N'Qatar', '');
GO

-- Thêm lịch bay
INSERT INTO LichBay (MaLichBay, NoiDi, NoiDen, ThoiGianDi, ThoiGianDen)
VALUES
('LB003', N'Đà Nẵng', N'Hà Nội', '2024-11-22 09:00', '2024-11-22 11:00'),
('LB004', N'Hà Nội', N'Phú Quốc', '2024-11-23 07:30', '2024-11-23 10:00'),
('LB005', N'Phú Quốc', N'Hồ Chí Minh', '2024-11-24 14:00', '2024-11-24 15:30'),
('LB006', N'Hồ Chí Minh', N'Hải Phòng', '2024-11-25 13:00', '2024-11-25 15:00'),
('LB007', N'Hải Phòng', N'Đà Lạt', '2024-11-26 16:00', '2024-11-26 18:00'),
('LB008', N'Đà Lạt', N'Hà Nội', '2024-11-27 12:30', '2024-11-27 15:00'),
('LB009', N'Hà Nội', N'Hồ Chí Minh', '2024-11-28 19:00', '2024-11-28 21:00');
GO

-- Thêm Vé Máy Bay
INSERT INTO VeMayBay (MaVe, MaHangBay, MaLichBay, MaHangVe, Gia)
VALUES 
('VE003', 'HB003', 'LB003', 'HV001', 1500000),
('VE004', 'HB004', 'LB004', 'HV002', 1800000),
('VE005', 'HB005', 'LB005', 'HV001', 1200000),
('VE006', 'HB006', 'LB006', 'HV001', 2500000),
('VE007', 'HB007', 'LB007', 'HV002', 2200000),
('VE008', 'HB008', 'LB008', 'HV001', 1900000),
('VE009', 'HB009', 'LB009', 'HV001', 2700000);
GO

-- Thêm Ghế 
INSERT INTO Ghe (MaGhe, TenGhe)
VALUES 
('G004', N'Cạnh Đường'), 
('G005', N'Cạnh Đường'), 
('G006', N'Cạnh Đường');
GO

-- Thêm Ghế Kiểu mới 
INSERT INTO Ghe (MaGhe, TenGhe)
VALUES 
-- Thương gia
('A001', N'Thương Gia'), 
('A002', N'Thương Gia'), 
('B001', N'Thương Gia'),
('B002', N'Thương Gia'), 
('C001', N'Thương Gia'), 
('C002', N'Thương Gia'), 
('D001', N'Thương Gia'),
('D002', N'Thương Gia'), 
-- Phổng thông
('I001', N'Cạnh Cửa'),
('I002', N'Cạnh Cửa'),
('I003', N'Cạnh Cửa'),
('I004', N'Cạnh Cửa'),
('I005', N'Cạnh Cửa'),
('I006', N'Cạnh Cửa'),
('I007', N'Cạnh Cửa'),
('I008', N'Cạnh Cửa'),
('I009', N'Cạnh Cửa'),
('I010', N'Cạnh Cửa'),
('I011', N'Cạnh Cửa'),
('I012', N'Cạnh Cửa'),
('I013', N'Cạnh Cửa'),
('I014', N'Cạnh Cửa'),
('I015', N'Cạnh Cửa'),
('I016', N'Cạnh Cửa'),
('I017', N'Cạnh Cửa'),
('I018', N'Cạnh Cửa'),
('I019', N'Cạnh Cửa'),
('I020', N'Cạnh Cửa'),
('I021', N'Cạnh Cửa'),
('I022', N'Cạnh Cửa'),
('I023', N'Cạnh Cửa'),
('I024', N'Cạnh Cửa'),
('I025', N'Cạnh Cửa'),
('I026', N'Cạnh Cửa'),
('I027', N'Cạnh Cửa'),
('I028', N'Cạnh Cửa'),
('I029', N'Cạnh Cửa'),
('I030', N'Cạnh Cửa'),
('I031', N'Cạnh Cửa'),
('I032', N'Cạnh Cửa'),
('I033', N'Cạnh Cửa'),
('I034', N'Cạnh Cửa'),
('I035', N'Cạnh Cửa'),
('I036', N'Cạnh Cửa'),
('I037', N'Cạnh Cửa'),
('I038', N'Cạnh Cửa'),
('I039', N'Cạnh Cửa'),
('I040', N'Cạnh Cửa'),
('I041', N'Cạnh Cửa'),
('I042', N'Cạnh Cửa'),
('I043', N'Cạnh Cửa'),
('I044', N'Cạnh Cửa'),
('I045', N'Cạnh Cửa'),
('I046', N'Cạnh Cửa'),
('I047', N'Cạnh Cửa'),
('I048', N'Cạnh Cửa'),
('I049', N'Cạnh Cửa'),
('I050', N'Cạnh Cửa'),
('E001', N'Cạnh Cửa'),
('E002', N'Cạnh Cửa'),
('E003', N'Cạnh Cửa'),
('E004', N'Cạnh Cửa'),
('E005', N'Cạnh Cửa'),
('E006', N'Cạnh Cửa'),
('E007', N'Cạnh Cửa'),
('E008', N'Cạnh Cửa'),
('E009', N'Cạnh Cửa'),
('E010', N'Cạnh Cửa'),
('E011', N'Cạnh Cửa'),
('E012', N'Cạnh Cửa'),
('E013', N'Cạnh Cửa'),
('E014', N'Cạnh Cửa'),
('E015', N'Cạnh Cửa'),
('E016', N'Cạnh Cửa'),
('E017', N'Cạnh Cửa'),
('E018', N'Cạnh Cửa'),
('E019', N'Cạnh Cửa'),
('E020', N'Cạnh Cửa'),
('E021', N'Cạnh Cửa'),
('E022', N'Cạnh Cửa'),
('E023', N'Cạnh Cửa'),
('E024', N'Cạnh Cửa'),
('E025', N'Cạnh Cửa'),
('E026', N'Cạnh Cửa'),
('E027', N'Cạnh Cửa'),
('E028', N'Cạnh Cửa'),
('E029', N'Cạnh Cửa'),
('E030', N'Cạnh Cửa'),
('E031', N'Cạnh Cửa'),
('E032', N'Cạnh Cửa'),
('E033', N'Cạnh Cửa'),
('E034', N'Cạnh Cửa'),
('E035', N'Cạnh Cửa'),
('E036', N'Cạnh Cửa'),
('E037', N'Cạnh Cửa'),
('E038', N'Cạnh Cửa'),
('E039', N'Cạnh Cửa'),
('E040', N'Cạnh Cửa'),
('E041', N'Cạnh Cửa'),
('E042', N'Cạnh Cửa'),
('E043', N'Cạnh Cửa'),
('E044', N'Cạnh Cửa'),
('E045', N'Cạnh Cửa'),
('E046', N'Cạnh Cửa'),
('E047', N'Cạnh Cửa'),
('E048', N'Cạnh Cửa'),
('E049', N'Cạnh Cửa'),
('E050', N'Cạnh Cửa'),
('F001', N'Giữa'),
('F002', N'Giữa'),
('F003', N'Giữa'),
('F004', N'Giữa'),
('F005', N'Giữa'),
('F006', N'Giữa'),
('F007', N'Giữa'),
('F008', N'Giữa'),
('F009', N'Giữa'),
('F010', N'Giữa'),
('F011', N'Giữa'),
('F012', N'Giữa'),
('F013', N'Giữa'),
('F014', N'Giữa'),
('F015', N'Giữa'),
('F016', N'Giữa'),
('F017', N'Giữa'),
('F018', N'Giữa'),
('F019', N'Giữa'),
('F020', N'Giữa'),
('F021', N'Giữa'),
('F022', N'Giữa'),
('F023', N'Giữa'),
('F024', N'Giữa'),
('F025', N'Giữa'),
('F026', N'Giữa'),
('F027', N'Giữa'),
('F028', N'Giữa'),
('F029', N'Giữa'),
('F030', N'Giữa'),
('F031', N'Giữa'),
('F032', N'Giữa'),
('F033', N'Giữa'),
('F034', N'Giữa'),
('F035', N'Giữa'),
('F036', N'Giữa'),
('F037', N'Giữa'),
('F038', N'Giữa'),
('F039', N'Giữa'),
('F040', N'Giữa'),
('F041', N'Giữa'),
('F042', N'Giữa'),
('F043', N'Giữa'),
('F044', N'Giữa'),
('F045', N'Giữa'),
('F046', N'Giữa'),
('F047', N'Giữa'),
('F048', N'Giữa'),
('F049', N'Giữa'),
('F050', N'Giữa'),

('G007', N'Cạnh Đường'),
('G008', N'Cạnh Đường'),
('G009', N'Cạnh Đường'),
('G010', N'Cạnh Đường'),
('G011', N'Cạnh Đường'),
('G012', N'Cạnh Đường'),
('G013', N'Cạnh Đường'),
('G014', N'Cạnh Đường'),
('G015', N'Cạnh Đường'),
('G016', N'Cạnh Đường'),
('G017', N'Cạnh Đường'),
('G018', N'Cạnh Đường'),
('G019', N'Cạnh Đường'),
('G020', N'Cạnh Đường'),
('G021', N'Cạnh Đường'),
('G022', N'Cạnh Đường'),
('G023', N'Cạnh Đường'),
('G024', N'Cạnh Đường'),
('G025', N'Cạnh Đường'),
('G026', N'Cạnh Đường'),
('G027', N'Cạnh Đường'),
('G028', N'Cạnh Đường'),
('G029', N'Cạnh Đường'),
('G030', N'Cạnh Đường'),
('G031', N'Cạnh Đường'),
('G032', N'Cạnh Đường'),
('G033', N'Cạnh Đường'),
('G034', N'Cạnh Đường'),
('G035', N'Cạnh Đường'),
('G036', N'Cạnh Đường'),
('G037', N'Cạnh Đường'),
('G038', N'Cạnh Đường'),
('G039', N'Cạnh Đường'),
('G040', N'Cạnh Đường'),
('G041', N'Cạnh Đường'),
('G042', N'Cạnh Đường'),
('G043', N'Cạnh Đường'),
('G044', N'Cạnh Đường'),
('G045', N'Cạnh Đường'),
('G046', N'Cạnh Đường'),
('G047', N'Cạnh Đường'),
('G048', N'Cạnh Đường'),
('G049', N'Cạnh Đường'),
('G050', N'Cạnh Đường'),
('H001', N'Cạnh Đường'),
('H002', N'Cạnh Đường'),
('H003', N'Cạnh Đường'),
('H004', N'Cạnh Đường'),
('H005', N'Cạnh Đường'),
('H006', N'Cạnh Đường'),
('H007', N'Cạnh Đường'),
('H008', N'Cạnh Đường'),
('H009', N'Cạnh Đường'),
('H010', N'Cạnh Đường'),
('H011', N'Cạnh Đường'),
('H012', N'Cạnh Đường'),
('H013', N'Cạnh Đường'),
('H014', N'Cạnh Đường'),
('H015', N'Cạnh Đường'),
('H016', N'Cạnh Đường'),
('H017', N'Cạnh Đường'),
('H018', N'Cạnh Đường'),
('H019', N'Cạnh Đường'),
('H020', N'Cạnh Đường'),
('H021', N'Cạnh Đường'),
('H022', N'Cạnh Đường'),
('H023', N'Cạnh Đường'),
('H024', N'Cạnh Đường'),
('H025', N'Cạnh Đường'),
('H026', N'Cạnh Đường'),
('H027', N'Cạnh Đường'),
('H028', N'Cạnh Đường'),
('H029', N'Cạnh Đường'),
('H030', N'Cạnh Đường'),
('H031', N'Cạnh Đường'),
('H032', N'Cạnh Đường'),
('H033', N'Cạnh Đường'),
('H034', N'Cạnh Đường'),
('H035', N'Cạnh Đường'),
('H036', N'Cạnh Đường'),
('H037', N'Cạnh Đường'),
('H038', N'Cạnh Đường'),
('H039', N'Cạnh Đường'),
('H040', N'Cạnh Đường'),
('H041', N'Cạnh Đường'),
('H042', N'Cạnh Đường'),
('H043', N'Cạnh Đường'),
('H044', N'Cạnh Đường'),
('H045', N'Cạnh Đường'),
('H046', N'Cạnh Đường'),
('H047', N'Cạnh Đường'),
('H048', N'Cạnh Đường'),
('H049', N'Cạnh Đường'),
('H050', N'Cạnh Đường'),
('K001', N'Giữa'),
('K002', N'Giữa'),
('K003', N'Giữa'),
('K004', N'Giữa'),
('K005', N'Giữa'),
('K006', N'Giữa'),
('K007', N'Giữa'),
('K008', N'Giữa'),
('K009', N'Giữa'),
('K010', N'Giữa'),
('K011', N'Giữa'),
('K012', N'Giữa'),
('K013', N'Giữa'),
('K014', N'Giữa'),
('K015', N'Giữa'),
('K016', N'Giữa'),
('K017', N'Giữa'),
('K018', N'Giữa'),
('K019', N'Giữa'),
('K020', N'Giữa'),
('K021', N'Giữa'),
('K022', N'Giữa'),
('K023', N'Giữa'),
('K024', N'Giữa'),
('K025', N'Giữa'),
('K026', N'Giữa'),
('K027', N'Giữa'),
('K028', N'Giữa'),
('K029', N'Giữa'),
('K030', N'Giữa'),
('K031', N'Giữa'),
('K032', N'Giữa'),
('K033', N'Giữa'),
('K034', N'Giữa'),
('K035', N'Giữa'),
('K036', N'Giữa'),
('K037', N'Giữa'),
('K038', N'Giữa'),
('K039', N'Giữa'),
('K040', N'Giữa'),
('K041', N'Giữa'),
('K042', N'Giữa'),
('K043', N'Giữa'),
('K044', N'Giữa'),
('K045', N'Giữa'),
('K046', N'Giữa'),
('K047', N'Giữa'),
('K048', N'Giữa'),
('K049', N'Giữa'),
('K050', N'Giữa');

GO



