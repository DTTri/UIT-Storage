package Bai3;

import java.util.Arrays;
import java.util.Scanner;

public class StudentList {
    Student[] st;
    int N;
    public StudentList(){
        N = 0;
        st = new Student[0];
    }
    public void input(Scanner sc){
        do{
            System.out.print("Nhap so luong sinh vien: ");
            N = sc.nextInt();
            if(N>=0) break;
        }while(true);
        sc.nextLine();
        st = new Student[N];
        for(int i=0; i<N; i++){
            st[i] = new Student();
            st[i].input(sc);
        }
    }
    public void print(){
        for(int i=0; i<N; i++){
            st[i].print();
        }
        System.out.println();
    }
    public void sort(){
        Arrays.sort(st);
        print();
    }
    Student searchByName(String fullName){
        fullName = fullName.trim();
        for(int i=0; i<N; i++){
            if(st[i].getFullName().endsWith(fullName)) return st[i];
        }
        return null;
    }
    public void printLeLastName(){
        for(int i=0; i<N; i++){
            if(st[i].getLastName().equalsIgnoreCase("Lê")) st[i].print();
        }
    }
}
