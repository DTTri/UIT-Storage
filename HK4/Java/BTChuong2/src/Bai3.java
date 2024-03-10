import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class PhanSo {

    private int tu;
    private int mau;

    public PhanSo() {
        this.tu = 0;
        this.mau = 1;
    }

    public PhanSo(int tu) {
        this.tu = tu;
        this.mau = 1;
    }

    public PhanSo(int tu, int mau) {
        this.tu = tu;
        this.mau = mau;
        rutGon();
    }
    public int getTu(){return tu;}
    public int getMau(){return mau;}
    public void setTu(int tu){this.tu = tu;}
    public void setMau(int mau)
    {
        if(mau!=0) {
        this.mau = mau;
        }
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap tu so: ");
        this.tu = scanner.nextInt();
        while(true){
            System.out.print("Nhap mau so: ");
            this.mau = scanner.nextInt();
            if(this.mau!=0) break;
            else {
                System.out.println("Mau khong hop le!");
                this.mau = 1;
            }
        }
        rutGon();
    }

    public void print() {
        System.out.printf("%d/%d ", tu, mau);
    }

    // Rút gọn
    private void rutGon() {
        int ucln = GCD(tu, mau);
        tu /= ucln;
        mau /= ucln;
    }

    private int GCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public PhanSo add(PhanSo other) {
        int otherTu = this.tu * other.mau + this.mau * other.tu;
        int otherMau = this.mau * other.mau;
        return new PhanSo(otherTu, otherMau);
    }
    public PhanSo minus(PhanSo other) {
        int otherTu = this.tu * other.mau - this.mau * other.tu;
        int otherMau = this.mau * other.mau;
        return new PhanSo(otherTu, otherMau);
    }
    public PhanSo multiply(PhanSo other) {
        int otherTu = this.tu * other.tu;
        int otherMau = this.mau * other.mau;
        return new PhanSo(otherTu, otherMau);
    }

    public PhanSo devide(PhanSo other) {
        int otherTu = this.tu * other.mau;
        int otherMau = this.mau * other.tu;
        return new PhanSo(otherTu, otherMau);
    }

   
}
class Checker implements Comparator<PhanSo> {
    @Override
    public int compare(PhanSo p1, PhanSo p2) {
        return (p1.getTu()*p2.getMau()-p2.getTu()*p1.getMau());
    }
}
public class Bai3 {
    static public void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so phan so: ");
        int n = scanner.nextInt();
        
        PhanSo[] ps = new PhanSo[n];

        for (int i = 0; i < n; i++) {
            ps[i] = new PhanSo();
            ps[i].input();
        }

        System.out.println("Danh sach phan so:");
        for (PhanSo i : ps) {
            i.print();
        }
        System.out.println();

        PhanSo sum = new PhanSo();
        for (PhanSo i : ps) {
            sum = sum.add(i);
        }
        System.out.print("Tong cac phan so: ");
        sum.print();
        System.out.println();

        Arrays.sort(ps,new Checker());
        System.out.println("Danh sach phan so sau khi sap xep:");
        for (PhanSo i : ps) {
            i.print();
        }
    }
}
