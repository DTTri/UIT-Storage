﻿CREATE DATABASE BAITHI
GO 
USE BAITHI
GO 
SET DATEFORMAT DMY 
GO 

CREATE TABLE KHACHHANG(
    MAKH CHAR(4) NOT NULL,
	HOTEN NVARCHAR(30),
	SODT VARCHAR(15),
	LOAIKH NVARCHAR(30),
	CONSTRAINT PK_KHACHHANG PRIMARY KEY(MAKH)
)
GO

CREATE TABLE SPINAN(
    MASP CHAR(4) NOT NULL,
	LOAISP NVARCHAR(30),
	CHATLIEU NVARCHAR(30),
	QUYCACH VARCHAR(30),
	CONSTRAINT PK_SPINAN PRIMARY KEY(MASP)
)
GO

CREATE TABLE DONHANG(
    MADH CHAR(4) NOT NULL,
	MAKH CHAR(4),
	NGDAT SMALLDATETIME,
	TRIGIA MONEY,
	CONSTRAINT PK_DONHANG PRIMARY KEY(MADH),
	CONSTRAINT FK_DONHANG_KHACHHANG FOREIGN KEY(MAKH) REFERENCES KHACHHANG(MAKH)
	
)
GO

CREATE TABLE CTDH(
    MADH CHAR(4) NOT NULL,
	MASP CHAR(4) NOT NULL,
	SOLUONG INT,
	DONGIA MONEY,
	CONSTRAINT PK_CTDH PRIMARY KEY(MADH,MASP),
	CONSTRAINT FK_CTDH_DONHANG FOREIGN KEY(MADH) REFERENCES DONHANG(MADH),
	CONSTRAINT FK_CTDH_SPINAN FOREIGN KEY(MASP) REFERENCES SPINAN(MASP)
)
GO


--------2
INSERT INTO KHACHHANG 
VALUES('KH01','Mai Hiền Thu','0776665544','Thường xuyên'),
('KH02','Trịnh Đào Tiến','0901231415','Vãng lai'),
('KH03','Nguyễn Công Vinh','0765004321','VIP')
GO

INSERT INTO SPINAN 
VALUES('TC01','Thiệp cưới','Giấy Conqueror','15 x 30cm'),
('BR02','Băng rôn','Bạt Hiflex','100 x 500cm'),
('SD03','Standee', 'Vải bố Canvas','60 x 160cm')
GO

INSERT INTO  DONHANG 
VALUES('DH01','KH02','02/06/2020',1450000),
('DH02','KH03','27/09/2020',2600000),
('DH03','KH02','25/12/2020',950000)
GO
INSERT INTO CTDH VALUES ('DH02', 'TC01', 400, 6500)
INSERT INTO CTDH VALUES ('DH03', 'BR02', 1, 400000)
INSERT INTO CTDH VALUES ('DH03', 'SD03', 5, 110000)
GO
-- 3

ALTER TABLE KHACHHANG
ADD CONSTRAINT CHECK_LOAIKH CHECK (LOAIKH IN('Thường xuyên', 'Vãng lai', 'VIP'))
GO
--------- 4
--           THEM    XOA   SUA
--CTDH        +       -     +(MADH)

CREATE TRIGGER TRIGGER_INSERT_UPDATE_CTDH_SPKHACNHAU ON CTDH
FOR INSERT, UPDATE
AS
BEGIN
        IF EXISTS(SELECT CT.MADH FROM CTDH CT WHERE CT.MADH IN (SELECT INS.MADH FROM INSERTED INS)
		         GROUP BY CT.MADH
				 HAVING COUNT(CT.MASP)>5
				 )
				 BEGIN
				 PRINT 'LOI: DON HANG KHONG THE DAT QUA 5 SAN PHAM'
				 ROLLBACK TRANSACTION
				 END
		ELSE
		BEGIN
		PRINT 'THEM/SUA THANH CONG'
		END
END
GO


-- 5
SELECT KH.* FROM DONHANG DH JOIN KHACHHANG KH ON DH.MAKH=KH.MAKH
WHERE MADH IN(
    SELECT MADH FROM CTDH CT JOIN SPINAN SP ON CT.MASP=SP.MASP
    WHERE LOAISP='Thiệp cưới'
)
ORDER BY DH.MADH ASC
GO
-- 6
SELECT SP.* FROM SPINAN SP JOIN
(SELECT MASP,RANK() OVER( ORDER BY SUM(SOLUONG) DESC ) RNK FROM CTDH CT JOIN DONHANG DH ON CT.MADH=DH.MADH
    WHERE MAKH IN (
        SELECT MAKH FROM KHACHHANG WHERE LOAIKH='VIP'
    )
    GROUP BY MASP
) B ON SP.MASP=B.MASP
WHERE RNK=1
GO
-- 7
SELECT * FROM SPINAN SP
WHERE MASP IN 
(
    (
    SELECT MASP FROM CTDH CT 
    JOIN DONHANG DH ON DH.MADH = CT.MADH
    JOIN KHACHHANG KH ON KH.MAKH = DH.MAKH
    WHERE LOAIKH = 'Thường xuyên')
    INTERSECT
    (SELECT MASP FROM CTDH CT 
    JOIN DONHANG DH ON DH.MADH = CT.MADH
    JOIN KHACHHANG KH ON KH.MAKH = DH.MAKH
    WHERE LOAIKH = 'Vãng lai')
)
GO
-- 8
SELECT * FROM KHACHHANG KH1
WHERE KH1.MAKH IN (
SELECT KH2.MAKH
FROM CTDH CT2 JOIN DONHANG DH2 ON CT2.MADH = DH2.MADH JOIN KHACHHANG KH2 ON DH2.MAKH= KH2.MAKH JOIN SPINAN SP2 ON CT2.MASP = SP2.MASP
WHERE SP2.LOAISP='Standee'
GROUP BY KH2.MAKH
HAVING COUNT(DISTINCT CT2.MASP) = (
SELECT COUNT(DISTINCT SP3.MASP)
FROM SPINAN SP3
WHERE SP3.LOAISP='Standee'
)
)