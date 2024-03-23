package Bai7;

import java.util.Scanner;

public class Manager extends Person{
    int numOfEmployee;
    public Manager(){
        numOfEmployee = 0;
    }
    public void input(Scanner sc){
        super.input(sc);
        System.out.print("So luong nhan vien quan ly: ");
        numOfEmployee = sc.nextInt();
        salary = salaryCoefficient*1200000;
        sc.nextLine();
    }
    public void print(){
        super.print();
        System.out.println("So luong nhan vien quan ly: "+numOfEmployee);
    }

}
