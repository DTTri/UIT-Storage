package Bai8;

import java.util.Scanner;

public class SinhVien implements Comparable<SinhVien>{
    String fullName;
    double dtb;
    public int compareTo(SinhVien other){
        return Double.compare(this.dtb, other.dtb);
    }
    public void input(Scanner sc){
        System.out.print("Ho ten: ");
        fullName = sc.nextLine();
        System.out.print("Diem trung binh: ");
        dtb = sc.nextDouble();
        sc.nextLine();
    }
    public String toString(){
        return fullName+"_"+dtb;
    }

}
