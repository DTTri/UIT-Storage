package Bai5;

import java.util.Scanner;

public class Person {
    String fullName;
    public Person(){
        fullName = "";
    }
    public void input(Scanner sc){
        System.out.print("Ho ten: ");
        fullName = sc.nextLine();
        fullName = fullName.trim();

    }
    public void print(){
        System.out.println("Ho ten: "+fullName);
    }
    public String getFullName(){return fullName;}
}
