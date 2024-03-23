package Bai3;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        StudentList stList = new StudentList();
        Scanner sc = new Scanner(System.in);
        int option = 0;
        do{
            System.out.print("1. Nhap DSSV  2. Xem DSSV  3. Sap xep va hien thi theo GPA tang dan\n4.Tim kiem theo ten  5.Xem thong tin cac sinh vien ho Lê\nKhac: Thoat");
            System.out.print("\nChon: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option){
                case 1:
                    stList.input(sc);
                    break;
                case 2:
                    stList.print();
                    break;
                case 3:
                    stList.sort();
                    break;
                case 4:
                    System.out.print("Nhap ten can tim: ");
                    String fullName = sc.nextLine();
                    Student st = stList.searchByName(fullName);
                    if(st!=null){
                        st.print();
                    }
                    else{
                        System.out.println("Khong tim thay");
                    }
                    break;
                case 5:
                    stList.printLeLastName();
                    break;
                default:
                    option = 0;
                    break;
            }
        }while(option!=0);
    }
}
