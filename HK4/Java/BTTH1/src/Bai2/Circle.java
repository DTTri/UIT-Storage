package Bai2;

import java.util.Scanner;

public class Circle extends Shape {
    double radius;
    Circle(){
        radius =0;
    }
    void input(Scanner sc){
        do {
            System.out.print("Radius: ");
            radius = sc.nextDouble();
            if(radius>=0) break;
        }while(true);
    }
    double area(){
        return 3.14*radius*radius;
    }
    public String toString(){
        //this.getClass().getName() -> "Bai2.Circle"
        return "Circle"+" "+this.area();
    }
}
