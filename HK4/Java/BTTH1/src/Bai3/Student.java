package Bai3;

import java.util.Scanner;

public class Student extends Person implements Comparable<Student>{
    String studentID;
    double gpa;
    Student(){
        studentID = "";
        gpa = 1.0;
    }
    public void input(Scanner sc){
        super.input(sc);
        System.out.print("MSSV: ");
        studentID = sc.nextLine();
        do{
            System.out.print("GPA: ");
            gpa = sc.nextDouble();
            if(gpa>= 0 ) break;
        }while(true);
        sc.nextLine();
    }
    public void print(){
        super.print();
        System.out.println("MSSV: "+studentID);
        System.out.println("GPA: "+gpa);
    }
    public int compareTo(Student other){
        return Double.compare(this.gpa, other.gpa);
    }
}
