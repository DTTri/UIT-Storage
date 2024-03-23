package Bai7;


import java.util.Scanner;

public class QuanLyNhanSu {
    Person[] p;
    int N;
    public QuanLyNhanSu(){
        N = 0;
        p = new Person[0];
    }
    public void input(Scanner sc){
        System.out.print("Nhap N: ");
        N = sc.nextInt();
        p = new Person[N];
        int option = 0;
        for(int i=0; i<N; i++){
            System.out.println("1. Giam doc  2. Quan ly  Khac. Nhan vien");
            option = sc.nextInt();
            switch (option){
                case 1: p[i] = new Director();
                break;
                case 2: p[i]= new Manager();
                break;
                default: p[i]= new Employee();
                break;
            }
            p[i].input(sc);
        }
    }
    public void print(){
        for(int i=0; i<N; i++){
            p[i].print();
        }
    }
    public Person highestSalary(){
        if(N==0) return null;
        int index = 0;
        for(int i=1; i<N; i++){
            if(p[i].getSalary()>p[index].getSalary()) index = i;
        }
        return p[index];
    }
    public void february(){
        for(int i=0; i<N; i++){
            if(p[i].getDateOfBirth().getMonth().getValue()==2) p[i].print();
        }
    }
    public void accountingDepartment(){
        for(int i=0; i<N;i++){
            if(p[i] instanceof Employee){
                if(((Employee) p[i]).getDepartment().equalsIgnoreCase("kế toán")){
                    p[i].print();
                }
            }
        }
    }
    public int countAn(){
        int count =0;
        for(int i=0;i<N; i++){
            if(p[i].getFullName().endsWith("An")) count+=1;
        }
        return count;
    }

}
