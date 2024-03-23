package Bai5;

import java.util.Scanner;

public class NhanVien extends Person implements Measurable{
    String employeeID;
    double workingHour;
    double wages;
    double salary;
    NhanVien(){
        employeeID = "";
        workingHour = wages = salary = 0;
    }
    public void input(Scanner sc){
        super.input(sc);
        System.out.print("Ma so nhan vien: ");
        employeeID = sc.nextLine();
        System.out.print("So gio lam: ");
        workingHour = sc.nextDouble();
        System.out.print("Luong theo gio: ");
        wages = sc.nextDouble();
        salary = wages*workingHour;
        sc.nextLine();
    }
    public double Valuate(){
        return salary;
    }
    public void print(){
        super.print();
        System.out.println("MSNV: "+employeeID);
        System.out.println("So gio lam: "+workingHour);
        System.out.println("Luong theo gio: "+wages);
        System.out.println("Luong thang: "+Valuate());
        System.out.println();

    }
}
