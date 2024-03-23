package Bai2;

import java.util.Scanner;

public class Rectangle extends Shape {
    double length;
    double width;
    Rectangle(){
        length =0 ;
        width=0;
    }
    public void input(Scanner sc){
        do {
            System.out.print("Length: ");
            length = sc.nextDouble();
            System.out.print("Width: ");
            width = sc.nextDouble();
            if(length>=0 && width>=0) break;
        }while(true);
    }
    double area(){
        return length*width;
    }
    public String toString(){
        //this.getClass().getName()
        return "Rectangle"+" "+this.area();
    }
}
