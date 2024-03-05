import java.util.Arrays;
import java.util.Scanner;

public class Bai3 {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        boolean start = true;
        char ans = 'y';
        int n=0;
        int[] arr = new int[0];
        do{
            System.out.print("Nhap n: ");
            n = sc.nextInt();
            arr = new int[n];
            for(int i=0; i<n; i++) {
                System.out.print("arr["+i+"]= ");
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.print("Day sau khi sap xep: ");
            System.out.print(Arrays.toString(arr));
            //---------------------------------------------------
            System.out.print("\nStart?('y' for start and other for stop): ");
            sc.nextLine();
            ans = sc.nextLine().charAt(0);
            if(ans!='y') start = false;
        }while(start);
        sc.close();
        }
    }

