package Bai4;

import java.util.Scanner;

public class Complex {
    double real; 
    double virtual; 

    public Complex() {
        real = 0;
        virtual = 0;
    }

    public Complex(double real, double virtual) {
        this.real = real;
        this.virtual = virtual;
    }
    public void input(Scanner sc){
        System.out.print("Phan thuc: ");
        real = sc.nextDouble();
        System.out.print("Phan ao: ");
        virtual = sc.nextDouble();
    }

    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.virtual + other.virtual);
    }

    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.virtual - other.virtual);
    }

    public Complex multiply(Complex other) {
        double resReal = this.real * other.real - this.virtual * other.virtual;
        double resVirtual = this.real * other.virtual + this.virtual * other.real;
        return new Complex(resReal, resVirtual);
    }
    public Complex divide(Complex other) {
        double mau = other.real * other.real + other.virtual * other.virtual;
        double resReal = (this.real * other.real + this.virtual * other.virtual) / mau;
        double resVirtual = (this.virtual * other.real - this.real * other.virtual) / mau;
        return new Complex(resReal, resVirtual);
    }

    public String toString() {
        return String.format("%.2f + %.2fi", this.real, this.virtual);
    }
}

