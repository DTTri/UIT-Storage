import java.util.Calendar;
import java.util.Scanner;

public class Bai6 {
    static final  String[] months = { "", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December" };
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        boolean start = true;
        char ans = 'y';
        int year = 2024;
        Calendar cal = Calendar.getInstance();
        do{
            System.out.print("Nam: ");
            year = sc.nextInt();
            for(int i=1; i<13; i++){
                printMonth(year, i);
            }

        //-------------------------------------------------------
            System.out.print("Start?('y' for start and other for stop): ");
            sc.nextLine();
            ans = sc.nextLine().charAt(0);
            if(ans!='y') start = false;
    }while(start);
        sc.close();
    }
    public static void printMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println("--------" + months[month] + " " + year);
        System.out.println("  Sun Mon Tue Wed Thu Fri Sat");
        for (int i = 1; i < dayOfWeek; i++) {
            System.out.print("    ");
        }
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%4d", day);
            if ((day + dayOfWeek-1) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n");
    }
}
