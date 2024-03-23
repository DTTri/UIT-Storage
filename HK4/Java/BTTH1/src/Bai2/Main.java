package Bai2;

import java.util.Scanner;

public class Main {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N;
        do{
            System.out.print("Nhap N: ");
            N = sc.nextInt();
            if(N>=0) break;
        }while(true);
        int index=0;
        int numRec = 0;
        int numCir = 0;
        int option = 0;
        Shape[] shapes = new Shape[N];
        for(int i=0; i<N; i++){
            do{
                System.out.print("0. Rectangle  1. Circle: ");
                option = sc.nextInt();
                if(option==0 || option==1) break;
            }while(true);
            if(option==0){
                numRec+=1;
                shapes[i] = new Rectangle();
                ((Rectangle) shapes[i]).input(sc);

            }
            else{
                numCir+=1;
                shapes[i] = new Circle();
                ((Circle)shapes[i]).input(sc);
            }
            if(shapes[i].area()>shapes[index].area()){
                index = i;
            }
        }
        System.out.println(numRec+" hinh chu nhat");
        System.out.println(numCir+" hinh tron");
        System.out.println("Hinh co dien tich lon nhat: "+shapes[index].toString());
    }
}
