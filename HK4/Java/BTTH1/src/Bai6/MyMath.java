package Bai6;

public class MyMath {
    public static int UCLN(int a, int b) {
        if(b==0) return a;
        return UCLN(b, a%b);
    }

    public static double max(double a, double b, double c) {
        return Math.max(a, Math.max(b, c));
    }

    public static double min(double a, double b, double c) {
        return Math.min(a, Math.min(b, c));
    }

    public static boolean isPrime(int N) {
        if (N <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int sumToN(int N) {
        return N*(1+N)/2;
    }

    public static int abs(int N) {
        return Math.abs(N);
    }

    public static double round(double N) {
        return Math.round(N);
    }
}
