package Bai3;

import java.util.Scanner;

public class Person {
    String lastName;
    String firstName;
    String fullName;
    String address;
    public Person(){
        lastName = "";
        firstName = "";
        fullName = "";
        address = "";
    }
    public void input(Scanner sc){
        System.out.print("Ho: ");
        lastName = sc.nextLine();
        System.out.print("Ten: ");
        firstName = sc.nextLine();
        fullName = lastName+" "+firstName;
        fullName = fullName.trim();
        System.out.print("Dia chi: ");
        address = sc.nextLine();
    }
    public void print(){
        System.out.println("Ho ten: "+fullName);
        System.out.println("Dia chi: "+address);
    }
    public String getFullName(){return fullName;}
    public String getLastName(){return lastName;}
}
