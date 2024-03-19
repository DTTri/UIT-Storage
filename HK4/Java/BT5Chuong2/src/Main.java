import java.util.Scanner;

interface SoSanhDuoc{
    int compareTo(Object o);
}
interface SapXepDuoc{
    void increase();
    void decrease();
    Object max();
    Object min();
}

class PhanSo implements SoSanhDuoc{
    int tu;
    int mau;
    public PhanSo(){
        tu = 0;
        mau =1;
    }
    public void input(Scanner sc){
        System.out.print("Nhap tu: ");
        tu = sc.nextInt();
        do{
            System.out.print("Nhap mau: ");
            mau = sc.nextInt();
            if(mau!=0) break;
        }while(true);
    }
    public void print(){
        System.out.println(tu+"/"+mau);
    }
    public int compareTo(Object o){
        int resTu = this.tu*((PhanSo)o).mau - ((PhanSo)o).tu*this.mau;
        return resTu;
    }

}
class MangPhanSo implements SapXepDuoc{
    int N;
    PhanSo[] ps;
    public MangPhanSo(){
        N = 0;
    }
    public void input(Scanner sc){
        do{
            System.out.print("Nhap N: ");
            N = sc.nextInt();
            if(N>=0) break;
        }while(true);
        ps = new PhanSo[N];
        for(int i=0; i<N; i++){
            ps[i]= new PhanSo();
            ps[i].input(sc);

        }
    }
    public void print(){
        for(int i=0; i<N; i++){
            ps[i].print();
        }
    }
    public void increase(){
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(ps[i].compareTo(ps[j])>0){
                    PhanSo temp = ps[i];
                    ps[i] = ps[j];
                    ps[j] = temp;
                }
            }
        }
        print();
    }
    public void decrease(){
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(ps[i].compareTo(ps[j])<0){
                    PhanSo temp = ps[i];
                    ps[i] = ps[j];
                    ps[j] = temp;
                }
            }
        }
        print();
    }
    public Object max(){
        PhanSo max = ps[0];
        for(int i=1; i<N; i++){
            if(max.compareTo(ps[i])<0){
                max = ps[i];
            }
        }
        return max;
    }
    public Object min(){
        PhanSo min = ps[0];
        for(int i=1; i<N; i++){
            if(ps[i].compareTo(min)<0){
                min = ps[i];
            }
        }
        return min;
    }
}
public class Main {
    static public void main(String args[]){
        MangPhanSo mps = new MangPhanSo();
        Scanner sc = new Scanner(System.in);
        mps.input(sc);
        System.out.println("Mang tang dan:");
        mps.increase();
        System.out.println("Mang giam dan:");
        mps.decrease();
        System.out.println("Phan so lon nhat: ");
        ((PhanSo)mps.max()).print();
        System.out.println("Phan so nho nhat:");
        ((PhanSo)mps.min()).print();
    }
}
