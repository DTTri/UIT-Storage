package Bai5;

import java.util.Scanner;

public class DanhSach {
    int n;
    int m;
    int total;
    Person[] p;
    DanhSach(){
        n = m = total = 0;
        p = new Person[total];
    }
    public void input(Scanner sc){
        System.out.print("Nhap n: ");
        n = sc.nextInt();
        System.out.print("Nhap m: ");
        m = sc.nextInt();
        sc.nextLine();
        total = n+m;
        p = new Person[total];
        System.out.println("Nhap "+n+" nhan vien:");
        for(int i=0; i<n; i++){
            p[i] = new NhanVien();
            p[i].input(sc);
        }
        System.out.println("Nhap "+m+" sinh vien:");
        for(int i=n; i<total; i++){
            p[i] = new SinhVien();
            p[i].input(sc);
        }
    }
    public void print(){
        for(int i=0; i<total; i++){
            p[i].print();
        }
    }
}
