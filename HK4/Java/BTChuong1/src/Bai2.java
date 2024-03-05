import java.util.Scanner;
enum NumberOfRoots{
    Zero,
    One,
    Two,
    Infinity
}
public class Bai2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        boolean start = true;
        char ans = 'y';
        do{
            System.out.println("Phuong trinh bac 2: ax2 + bx + c = 0");
            double a,b,c;

            System.out.print("Nhap a: ");
            a = sc.nextInt();
            System.out.print("Nhap b: ");
            b = sc.nextInt();
            System.out.print("Nhap c: ");
            c = sc.nextInt();
            boolean quadratic = true;
            NumberOfRoots roots = NumberOfRoots.Zero;
            double x1,x2;
            x1 = x2 = 0;
            if(a==0){
                quadratic = false;
                if(b==0){
                    if(c==0) roots = NumberOfRoots.Infinity;
                    else roots = NumberOfRoots.Zero;
                }
                else{
                    x1 = x2 = -c/b;
                    roots = NumberOfRoots.One;
                }
            }
            else {
                double delta = Math.pow(b, 2) - 4 * a * c;
                if (delta < 0) {
                    roots = NumberOfRoots.Zero;
                }
                if (delta > 0) {
                    x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    roots = NumberOfRoots.Two;
                } else {
                    x1 = x2 = (-b) / (2 * a);
                    roots = NumberOfRoots.One;

                }
            }
            if(roots == NumberOfRoots.Zero){
                System.out.println("Phuong trinh vo nghiem");
            }
            else if(roots == NumberOfRoots.One){
                if(quadratic){
                    System.out.printf("Phuong trinh co nghiem kep:\nx1 = x2 = %.2f\n", x1);
                }
                else{
                    System.out.printf("Phuong trinh co 1 nghiem don:\nx = %.2f\n", x1);
                }
            }
            else if(roots == NumberOfRoots.Two){
                System.out.printf("Phuong trinh co 2 nghiem don:\nx1 = %.2f\nx2 = %.2f\n", x1, x2);
            }
            else{
                System.out.println("Phuong trinh co vo so nghiem");
            }
            System.out.print("Start?('y' for start and other for stop): ");
            sc.nextLine();
            ans = sc.nextLine().charAt(0);
            if(ans!='y') start = false;
        }while(start);
        sc.close();

    }
}
