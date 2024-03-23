package Bai1;

import java.util.Scanner;

public class Person{
    String name;
    int age;
    String address;
    public Person(){
        name="";
        age=0;
        address="";
    }
    public Person(String pName, int pAge, String pAddress){
        name = pName;
        age = pAge;
        address = pAddress;
    }
    public void input(Scanner sc){
        System.out.print("Nhap ten: ");
        name = sc.nextLine();
        do{
            System.out.print("Nhap tuoi: ");
            age = sc.nextInt();
            if(age>=0) break;
        }while(true);
        sc.nextLine();
        System.out.print("Nhap dia chi: ");
        address = sc.nextLine();
    }
    public void printInfo(){
        System.out.println("Ten: "+name);
        System.out.println("Tuoi: "+age);
        System.out.println("Dia chi: "+address);
    }

}
