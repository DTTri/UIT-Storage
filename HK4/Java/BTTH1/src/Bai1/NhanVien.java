package Bai1;

import java.util.Scanner;

public class NhanVien extends Person{
    int basicSalary;
    double factor;
    public NhanVien(){
        basicSalary = 0;
        factor =0 ;
    }
    public NhanVien(int nvBasicSalary, double nvFactor){
        basicSalary = nvBasicSalary;
        factor = nvFactor;
    }
    public double salaryCalculating(){
        return basicSalary*factor;
    }
    public void input(Scanner sc){
        super.input(sc);
        do{
            System.out.print("Nhap luong co ban: ");
            basicSalary = sc.nextInt();
            System.out.print("Nhap he so luong: ");
            factor = sc.nextDouble();
            if(basicSalary >=0 && factor>=0) break;
        }while(true);
        sc.nextLine();
    }
}
