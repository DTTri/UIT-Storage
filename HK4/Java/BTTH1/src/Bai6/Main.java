package Bai6;

import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int opt = -1;
        do{
            System.out.println("1.UCLN 2.Max 3.Min 4. isPrime? 5.Sum 1 to N 6. abs 7. round Khac. Thoat");
            System.out.print("Chon: ");
            opt = sc.nextInt();
            int a,b,c, N;
            double real1,real2, real3;
            switch(opt){
                case 1:
                    System.out.println("Nhap 2 so nguyen:");
                    a = sc.nextInt();
                    b = sc.nextInt();
                    System.out.println(MyMath.UCLN(a,b));
                    break;
                case 2:
                    System.out.println("Nhap 3 so thuc:");
                    real1 = sc.nextDouble();
                    real2 = sc.nextDouble();
                    real3 = sc.nextDouble();
                    System.out.println(MyMath.max(real1, real2, real3));

                    break;
                case 3:
                    System.out.println("Nhap 3 so thuc:");
                    real1 = sc.nextDouble();
                    real2 = sc.nextDouble();
                    real3 = sc.nextDouble();
                    System.out.println(MyMath.min(real1, real2, real3));

                    break;
                case 4:
                    System.out.println("Nhap N:");
                    N = sc.nextInt();
                    System.out.println(MyMath.isPrime(N));
                    break;
                case 5:
                    System.out.println("Nhap N:");
                    N = sc.nextInt();
                    System.out.println(MyMath.sumToN(N));

                    break;
                case 6:
                    System.out.println("Nhap N:");
                    N = sc.nextInt();
                    System.out.println(MyMath.abs(N));

                    break;
                case 7:
                    System.out.println("Nhap so thuc:");
                    real1 = sc.nextDouble();
                    System.out.println(MyMath.round(real1));

                    break;
                default:
                    opt = 0;
                    break;

            }
        }while(opt!=0);
    }
}
