package Bai7;

import java.util.Scanner;

public class Director extends Person{
    double posCoefficient;
    public Director(){
        posCoefficient = 0;
    }
    public void input(Scanner sc){
        super.input(sc);
        System.out.print("He so chuc vu: ");
        posCoefficient = sc.nextDouble();
        sc.nextLine();
        salary = (salaryCoefficient+posCoefficient)*1200000;
    }
    public void print(){
        super.print();
        System.out.println("He so chuc vu: "+posCoefficient);
    }
}
