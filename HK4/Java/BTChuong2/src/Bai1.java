import java.util.Scanner;

class Point2D{
    private int x;
    private int y;
    public Point2D(){
        x =0;
        y = 0;
    }
    public Point2D(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;

    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap x: ");
        x =sc.nextInt();
        System.out.print("Nhap y: ");
        y = sc.nextInt();

    }
    public void print(){
        System.out.println("("+x+";"+y+")");
    }
    public void move(int vectorX, int vectorY){
        x += vectorX;
        y += vectorY;
    }
    public double distance(Point2D other){
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

}
public class Bai1 {

    static public void main(String args[]){
        Point2D a = new Point2D();
        Point2D b = new Point2D();
        System.out.println("Diem A: ");
        a.input();
        System.out.println("Diem B: ");
        b.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap x cua vector: ");
        int vectorX = sc.nextInt();
        System.out.print("Nhap y cua vector: ");
        int vectorY = sc.nextInt();
        a.move(vectorX, vectorY);
        b.move(vectorX, vectorY);
        System.out.print("Diem A sau khi di chuyen: ");
        a.print();
        System.out.print("Diem B sau khi di chuyen: ");
        b.print();
        System.out.print("Khoang cach giua 2 diem: "+a.distance(b));
    }
}
