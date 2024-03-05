import java.util.*;

public class Bai8 {
    static int n;
    static ArrayList<Integer> arr = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static public void input(){
        System.out.print("Nhap n: ");
        int n = sc.nextInt();
        arr.clear();
        for(int i=0; i<n; i++){
            System.out.print("arr["+i+"] = ");
            arr.add(sc.nextInt());
        }
    }
    static public void print(){
        System.out.println(arr.toString());
    }
    static public float AVG(ArrayList<Integer> arr){
        float sum =0;
        for(int i:arr) sum+= i;
        return sum/arr.size();
    }
    static public int countEven(ArrayList<Integer> arr){
        int count =0;
        for(int i :arr){
            if(i%2==0) ++count;
        }
        return count;
    }
    static public int countOdd(ArrayList<Integer> arr){
        int count =0 ;
        for(int i:arr){
            if(i%2==1) ++count;
        }
        return count;
    }

    static public void main(String arg[]){
        int opt = 0;
        int temp=0;
        while(opt>=0 && opt<8){
            System.out.println("\n0. Nhap day moi  1. In day  2. So phan tu chan/le  3. Tinh TB  4. Min 5. Max 6. Xuat mang nguoc 7. Sap xep tang dan va in ra  Khac. Thoat");
            System.out.print("Nhap lua chon: ");
            opt = sc.nextInt();
            switch(opt){
                case 0:
                    input();
                    break;
                case 1:
                    print();
                    break;
                case 2:
                    System.out.println("So phan tu chan: "+countEven(arr));
                    System.out.println("So phan tu le: "+countOdd(arr));
                    break;
                case 3:
                    System.out.println("Gia tri trung binh cua mang: "+AVG(arr));
                    break;
                case 4:
                    System.out.println("Gia tri nho nhat cua mang: "+Collections.min(arr));
                    break;
                case 5:
                    System.out.println("Gia tri lon nhat cua mang: "+Collections.max(arr));
                    break;
                case 6:
                    System.out.println("Mang theo chieu nguoc lai: "+List.copyOf(arr).reversed().toString());
                    break;
                case 7:
                    Collections.sort(arr);
                    System.out.println(arr.toString());
                    break;
                default: break;
            }
        }
        sc.close();
    }
}
