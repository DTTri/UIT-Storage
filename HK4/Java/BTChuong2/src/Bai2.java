import java.util.Scanner;

class Time {

    private int hour;
    private int minute;
    private int second;

    // Phương thức khởi tạo
    public Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }
    public void setHour(int hour) {
        if(hour>=0 && hour<=24)
        {
            this.hour = hour;
        }
    }
    public void setMinute(int minute) {
        if(minute>= 0 && minute<=60)
        {
            this.minute = minute;
        }
    }
    public void setSecond(int second) {
        if(second>=0 && second<=60)
        {
            this.second = second;
        }
    }
    public void addSecond() {
        this.second++;
        if (this.second >= 60) {
            this.second = 0;
            this.minute++;
            if (this.minute >= 60) {
                this.minute = 0;
                this.hour++;
            }
        }
    }
    public boolean isLessThan(Time other) {
        if (this.hour < other.hour) {
            return true;
        } else if (this.hour == other.hour) {
            if (this.minute < other.minute) {
                return true;
            } else if (this.minute == other.minute) {
                return this.second < other.second;
            }
        }
        return false;
    }
    public void print() {
        System.out.printf("%02d:%02d:%02d\n", hour, minute, second);
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        boolean validTime = true;
        do{
            System.out.print("Gio: ");
            this.hour = sc.nextInt();
            System.out.print("Phut: ");
            this.minute = sc.nextInt();
            System.out.print("Giay: ");
            this.second = sc.nextInt();
            if(this.hour <0 || this.hour>24 || this.minute<0 || this.minute>60 || this.second<0 || this.second>60){
                validTime = false;
                System.out.println("Thoi gian khong hop le!");
            }
            else validTime= true;
        }while(!validTime);

    }



}

public class Bai2 {
    public static void main(String[] args) {
        Time time1 = new Time();
        Time time2 = new Time();
        System.out.println("Thoi gian 1:");
        time1.input();
        System.out.println("Thoi gian 2: ");
        time2.input();
        System.out.print("Thoi gian lon hon: ");
        if (time1.isLessThan(time2)) {
            time2.print();
        } else {
            time1.print();
        }

        System.out.println("Tang thoi gian 1 moi giay:");
        try {
            for(int i=0; i<10; i++) {
                time1.addSecond();
                time1.print();
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
        }
        finally {
            System.out.println("Chuong trinh ket thuc!");
        }
    }
}
