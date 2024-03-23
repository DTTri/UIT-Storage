package Bai1;

import java.util.Scanner;

public class Main {
    static public void main(String args[]){
        double sumSalary = 0;
        Scanner sc = new Scanner(System.in);
        int N;
        do{
            System.out.print("Nhap so nhan vien: ");
            N = sc.nextInt();
            if(N>=0) break;
        }while(true);
        sc.nextLine();
        NhanVien[] nv= new NhanVien[N];
        NhanVien best = new NhanVien();
        for(int i=0; i<N; i++){
            nv[i] = new NhanVien();
            nv[i].input(sc);
            sumSalary += nv[i].salaryCalculating();
            if(nv[i].salaryCalculating()> best.salaryCalculating()){
                best = nv[i];
            }
        }
        System.out.println("\nTong so luong: "+sumSalary);
        System.out.println("Nhan vien co luong cao nhat:");
        best.printInfo();
        System.out.println("Luong: "+best.salaryCalculating());
        sc.close();
    }
}