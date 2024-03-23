package Bai7;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        QuanLyNhanSu ql = new QuanLyNhanSu();
        int option =0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1.Nhap  2.Xuat danh sach  3.NV luong cao nhat  4.NV sinh thang 2  5. Nhan vien ban Ke toan  6.Nhan vien ten An  Khac. Thoat");
            System.out.print("Chon: ");
            option = sc.nextInt();
            switch (option){
                case 1:
                    ql.input(sc);
                    break;
                case 2:
                    ql.print();
                    break;
                case 3:
                    ql.highestSalary().print();
                    break;
                case 4:
                    ql.february();
                    break;
                case 5:
                    ql.accountingDepartment();
                    break;
                case 6:
                    System.out.println(ql.countAn());
                    break;
                default:
                    option = 0;
                    break;


            }
        }while(option!=0);
    }
}
