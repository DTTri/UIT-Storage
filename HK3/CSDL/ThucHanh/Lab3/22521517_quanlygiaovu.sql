------------------------------ BAI TAP 2: PHAN II QUANLYGIAOVU CAU 1-4
--- 1. Tăng hệ số lương thêm 0.2 cho những giáo viên là trưởng khoa
UPDATE DBO.GIAOVIEN
SET GIAOVIEN.HESO*= 1.2
WHERE GIAOVIEN.MAGV IN (
SELECT KHOA.TRGKHOA
FROM DBO.KHOA)


---2.	Cập nhật giá trị điểm trung bình tất cả các môn học (DIEMTB) của mỗi học viên 
--- (tất cả các môn học đều có hệ số 1 và nếu học viên thi một môn nhiều lần, chỉ lấy điểm của lần thi sau cùng).
UPDATE HV
SET HV.DIEMTB = HV_DTB.DTB
FROM DBO.HOCVIEN AS HV LEFT JOIN(
SELECT KQ1.MAHV, AVG(KQ1.DIEM) AS DTB
FROM DBO.KETQUATHI AS KQ1
WHERE KQ1.LANTHI >= ALL(
SELECT KQ2.LANTHI
FROM DBO.KETQUATHI AS KQ2
WHERE KQ2.MAHV = KQ1.MAHV AND KQ2.MAMH = KQ1.MAMH
)
GROUP BY KQ1.MAHV
) HV_DTB
  ON HV.MAHV = HV_DTB.MAHV

--- 3.	Cập nhật giá trị cho cột GHICHU là “Cam thi” đối với trường hợp: học viên có một môn bất kỳ thi lần thứ 3 dưới 5 điểm.
UPDATE DBO.HOCVIEN
SET HOCVIEN.GHICHU= 'Cam thi'
WHERE HOCVIEN.MAHV IN (
SELECT KQ.MAHV
FROM KETQUATHI AS KQ
WHERE KQ.LANTHI=3 AND KQ.DIEM < 5
)
--- 4.	Cập nhật giá trị cho cột XEPLOAI trong quan hệ HOCVIEN như sau:
UPDATE HOCVIEN 
SET HOCVIEN.XEPLOAI = CASE 
	WHEN DIEMTB >= 9 THEN 'XS'
	WHEN DIEMTB >= 8 THEN 'G'
	WHEN DIEMTB >= 6.5 THEN 'K'
	WHEN DIEMTB >= 5 THEN 'TB'
	ELSE 'Y'
END

------------------- BAI TAP 3: PHAN III QUANLYGIAOVU CAU 6- 10
--- 6.	Tìm tên những môn học mà giáo viên có tên “Tran Tam Thanh” dạy trong học kỳ 1 năm 2006
SELECT MH.TENMH
FROM DBO.GIANGDAY AS GD
     JOIN DBO.MONHOC AS MH ON GD.MAMH = MH.MAMH
	 JOIN DBO.GIAOVIEN AS GV ON GD.MAGV = GV.MAGV
WHERE GV.HOTEN= 'Tran Tam Thanh' AND GD.HOCKY=1 AND GD.NAM = 2006 

--- 7.	Tìm những môn học (mã môn học, tên môn học) mà giáo viên chủ nhiệm lớp “K11” dạy trong học kỳ 1 năm 2006.
SELECT MH.MAMH, MH.TENMH
FROM DBO.GIANGDAY AS GD
     JOIN DBO.MONHOC AS MH ON GD.MAMH = MH.MAMH
WHERE GD.HOCKY = 1 AND GD.NAM = 2006 AND GD.MAGV IN (
SELECT MAGVCN
FROM DBO.LOP
WHERE MALOP= 'K11'
)
--- 8.	Tìm họ tên lớp trưởng của các lớp mà giáo viên có tên “Nguyen To Lan” dạy môn “Co So Du Lieu”.
SELECT HO+' '+ TEN AS [HO TEN LOP TRUONG]
FROM DBO.HOCVIEN
WHERE MAHV IN (
    SELECT TRGLOP
    FROM DBO.LOP
    WHERE MALOP IN (
       SELECT GD.MALOP
       FROM DBO.GIANGDAY AS GD
       WHERE MAMH='Co So Du Lieu' AND MAGV IN (
           SELECT GV.MAGV
           FROM DBO.GIAOVIEN AS GV
           WHERE GV.HOTEN='Nguyen To Lan'
)
)
)


--- 9.	In ra danh sách những môn học (mã môn học, tên môn học) phải học liền trước môn “Co So Du Lieu”.
SELECT MH.MAMH, MH.TENMH
FROM DBO.MONHOC AS MH
WHERE MH.MAMH IN (
SELECT DK.MAMH_TRUOC
FROM DBO.DIEUKIEN AS DK
     JOIN DBO.MONHOC AS MH1 ON DK.MAMH = MH1.MAMH
WHERE MH1.TENMH = 'Co So Du Lieu'
)
--- 10.	Môn “Cau Truc Roi Rac” là môn bắt buộc phải học liền trước những môn học (mã môn học, tên môn học) nào.
SELECT MH.MAMH, MH.TENMH
FROM DBO.MONHOC AS MH
WHERE MH.MAMH IN(
SELECT DK.MAMH
FROM DBO.DIEUKIEN AS DK
     JOIN DBO.MONHOC AS MH1 ON DK.MAMH_TRUOC= MH1.MAMH
WHERE MH1.TENMH='Cau Truc Roi Rac'
)



------------------- BAI TAP 5: PHAN III QUANLYGIAOVU CAU 11- 18
---11.	Tìm họ tên giáo viên dạy môn CTRR cho cả hai lớp “K11” và “K12” trong cùng học kỳ 1 năm 2006.
SELECT GV.HOTEN
FROM DBO.GIAOVIEN AS GV
WHERE GV.MAGV IN
((
SELECT GD1.MAGV
FROM DBO.GIANGDAY AS GD1
WHERE MAMH='CTRR' AND HOCKY=1 AND NAM=2006 AND MALOP= 'K11'
)
INTERSECT (
SELECT GD1.MAGV
FROM DBO.GIANGDAY AS GD1
WHERE MAMH='CTRR' AND HOCKY=1 AND NAM=2006 AND MALOP= 'K12'
))

--- 12.	Tìm những học viên (mã học viên, họ tên) thi không đạt môn CSDL ở lần thi thứ 1 nhưng chưa thi lại môn này.
SELECT HV.MAHV, HV.HO+' '+ HV.TEN AS [HO TEN]
FROM DBO.HOCVIEN AS HV
WHERE HV.MAHV IN ((
SELECT KQ.MAHV
FROM DBO.KETQUATHI AS KQ
WHERE KQ.MAMH='CSDL' AND LANTHI=1 AND KQUA='Khong Dat'
)
INTERSECT (
SELECT KQ1.MAHV
FROM DBO.KETQUATHI AS KQ1
WHERE KQ1.MAMH='CSDL'
GROUP BY KQ1.MAHV
HAVING MAX(KQ1.LANTHI) = 1
))
--- 13.	Tìm giáo viên (mã giáo viên, họ tên) không được phân công giảng dạy bất kỳ môn học nào.
SELECT GV.MAGV, GV.HOTEN
FROM DBO.GIAOVIEN AS GV
WHERE GV.MAGV NOT IN (
SELECT GD.MAGV
FROM DBO.GIANGDAY AS GD
)
--- 14.	Tìm giáo viên (mã giáo viên, họ tên) không được phân công giảng dạy bất kỳ môn học nào thuộc khoa giáo viên đó phụ trách.
SELECT GV.MAGV, GV.HOTEN
FROM DBO.GIAOVIEN AS GV
WHERE GV.MAGV NOT IN(
SELECT GD.MAGV
FROM DBO.GIANGDAY AS GD
     JOIN DBO.MONHOC AS MH ON GD.MAMH = MH.MAMH
	 JOIN DBO.GIAOVIEN AS GV ON GD.MAGV = GV.MAGV
WHERE MH.MAKHOA = GV.MAKHOA
)
--- 15.	Tìm họ tên các học viên thuộc lớp “K11” thi một môn bất kỳ quá 3 lần vẫn “Khong dat” hoặc thi lần thứ 2 môn CTRR được 5 điểm.
SELECT HV.HO+' '+HV.TEN AS [HO TEN]
FROM DBO.HOCVIEN AS HV
WHERE HV.MALOP = 'K11' AND HV.MAHV IN (
(
SELECT KQ1.MAHV
FROM DBO.KETQUATHI AS KQ1
WHERE KQ1.KQUA='Khong Dat' AND KQ1.LANTHI>3
)
UNION
(
SELECT KQ2.MAHV
FROM DBO.KETQUATHI AS KQ2
WHERE KQ2.MAMH='CTRR' AND KQ2.LANTHI=2 AND KQ2.DIEM=5
))
---16.	Tìm họ tên giáo viên dạy môn CTRR cho ít nhất hai lớp trong cùng một học kỳ của một năm học.
SELECT GV.HOTEN
FROM DBO.GIAOVIEN AS GV
WHERE GV.MAGV IN 
(
SELECT GD.MAGV
FROM DBO.GIANGDAY AS GD
WHERE GD.MAMH='CTRR'
GROUP BY GD.MAMH, GD.MAGV, GD.HOCKY, GD.NAM
HAVING COUNT(GD.MALOP)>1
)
--- 17.	Danh sách học viên và điểm thi môn CSDL (chỉ lấy điểm của lần thi sau cùng).
SELECT KQ.MAHV, KQ.DIEM
FROM DBO.KETQUATHI AS KQ
WHERE KQ.MAMH='CSDL' AND KQ.LANTHI = 
(
SELECT MAX(KQ1.LANTHI)
FROM DBO.KETQUATHI AS KQ1
GROUP BY KQ1.MAHV, KQ1.MAMH
HAVING KQ1.MAHV= KQ.MAHV AND KQ1.MAMH='CSDL'
)
--- 18.	Danh sách học viên và điểm thi môn “Co So Du Lieu” (chỉ lấy điểm cao nhất của các lần thi).
SELECT KQ.MAHV, KQ.DIEM
FROM DBO.KETQUATHI AS KQ
WHERE KQ.MAMH='CSDL' AND KQ.DIEM = 
(
SELECT MAX(KQ1.DIEM)
FROM DBO.KETQUATHI AS KQ1
GROUP BY KQ1.MAHV, KQ1.MAMH
HAVING KQ1.MAHV= KQ.MAHV AND KQ1.MAMH='CSDL'
)