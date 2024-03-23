package Bai7;

import java.util.Scanner;

public class Employee extends Person{
    String department;
    public Employee(){
        department = "";
    }
    public void input(Scanner sc){
        super.input(sc);
        sc.nextLine();
        System.out.print("Ten don vi: ");
        department = sc.nextLine();
        salary = salaryCoefficient*1200000;
    }
    public void print(){
        super.print();
        System.out.println("Ten don vi: "+department);
    }
    public String getDepartment(){return department;}

}
