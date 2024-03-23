package Bai7;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Person {
    String fullName;
    LocalDate dateOfBirth;
    double salaryCoefficient;
    double salary;
    public Person(){
        fullName = "";
        dateOfBirth = LocalDate.now();
        salaryCoefficient = 0;
        salary = 0;
    }
    public void input(Scanner sc){
        sc.nextLine();
        System.out.print("Ho ten: ");
        fullName = sc.nextLine();
        System.out.println("Ngay sinh:");
        System.out.print("Ngay: ");
        int day = sc.nextInt();
        System.out.print("Thang: ");
        int month = sc.nextInt();
        System.out.print("Nam: ");
        int year = sc.nextInt();
        try{
            dateOfBirth = LocalDate.of(year, month, day);
        }catch(DateTimeException e){
            System.out.println("Ngay sinh khong hop le! Ngay sinh duoc tra ve ngay hien tai!");
            dateOfBirth = LocalDate.now();
        }
        System.out.print("He so luong: ");
        salaryCoefficient = sc.nextDouble();
    }
    public void print(){
        System.out.println("Ho ten: "+fullName);
        System.out.println("Ngay sinh: "+dateOfBirth.toString());
        System.out.println("He so luong: "+salaryCoefficient);
        System.out.println();
    }
    public double getSalary(){return salary;}
    public LocalDate getDateOfBirth(){return dateOfBirth;}
    public String getFullName(){return fullName;}
}
