import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
class Checker implements Comparator<PhanSo>{
    public int compare(PhanSo a, PhanSo b){
        double x1 = a.tu*1.0/a.mau;
        double x2 = b.tu*1.0/b.mau;
        if(x1<x2) return -1;
        else if(x1>x2) return 1;
        return 0;
    }
}
class PhanSo{
    int tu;
    int mau;
    public void set(){
        System.out.print("Tu so: ");
        Scanner sc = new Scanner(System.in);
        tu = sc.nextInt();
        System.out.print("Mau so: ");
        mau = sc.nextInt();
    }
    public int getTu(){
        return tu;
    }
    public int getMau(){
        return mau;
    }
    public String toString(){
        return (tu+"/"+mau);
    }

}

public class Bai7 {
    static public void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        boolean start = true;
        char ans = 'y';
        ArrayList<PhanSo> arr = new ArrayList<>();
        Checker checker = new Checker();
        int n;
        do{

            System.out.print("Nhap n: ");
            n = sc.nextInt();
            arr.clear();
            for(int i=0; i<n; i++){
                PhanSo temp = new PhanSo();
                temp.set();
                arr.add(temp);
            }
            Collections.sort(arr, checker);
            System.out.println("Phan so nho nhat: "+arr.get(0).toString());
            System.out.println("Phan so lon nhat: "+arr.get(n-1).toString());
            System.out.print("Start?('y' for start and other for stop): ");
            sc.nextLine();
            ans = sc.nextLine().charAt(0);
            if(ans!='y') start = false;
        }while(start);
        sc.close();
    }
}
