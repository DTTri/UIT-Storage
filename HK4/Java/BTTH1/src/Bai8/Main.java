package Bai8;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sinh vien: ");
        int N = sc.nextInt();
        SinhVien[] sv = new SinhVien[N];
        sc.nextLine();
        for(int i=0; i<N; i++){
            sv[i] = new SinhVien();
            sv[i].input(sc);
        }
        Arrays.sort(sv);
        System.out.println(Arrays.toString(sv));
    }
}
