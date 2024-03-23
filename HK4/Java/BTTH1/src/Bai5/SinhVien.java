package Bai5;

import java.util.Scanner;

public class SinhVien extends Person implements Measurable{
    String studentID;
    double math;
    double physics;
    double chemistry;
    double dtb;
    SinhVien(){
        math = physics = chemistry = dtb = 0;
        studentID="";
    }
    public void input(Scanner sc){
        super.input(sc);
        System.out.print("MSSV: ");
        studentID = sc.nextLine();
        System.out.print("Diem toan: ");
        math = sc.nextDouble();
        System.out.print("Diem ly: ");
        physics = sc.nextDouble();
        System.out.print("Diem hoa: ");
        chemistry = sc.nextDouble();
        dtb = (math+physics+chemistry)/3;
        sc.nextLine();
    }
    public double Valuate(){
        return dtb;
    }
    public void print(){
        super.print();
        System.out.println("MSSV: "+studentID);
        System.out.println("Toan: "+math);
        System.out.println("Ly: "+physics);
        System.out.println("Hoa: "+chemistry);
        System.out.println("DTB: "+Valuate());
        System.out.println();
    }
}
