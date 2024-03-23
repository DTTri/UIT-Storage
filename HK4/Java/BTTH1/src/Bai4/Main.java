package Bai4;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Complex c1 = new Complex();
        Complex c2 = new Complex();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so phuc 1: ");
        c1.input(sc);
        System.out.println("Nhap so phuc 2: ");
        c2.input(sc);
        System.out.println("Cong:");
        System.out.println(c1 + " + " + c2 + " = " + c1.add(c2));
        System.out.println("Tru:");
        System.out.println(c1 + " - " + c2 + " = " + c1.subtract(c2));
        System.out.println("Nhan:");
        System.out.println(c1 + " * " + c2 + " = " + c1.multiply(c2));
        System.out.println("Chia:");
        System.out.println(c1 + " / " + c2 + " = " + c1.divide(c2));
    }
}
