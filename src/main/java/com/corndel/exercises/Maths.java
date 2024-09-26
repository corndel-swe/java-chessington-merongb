package com.corndel.exercises;

public class Maths {
    public static double PI = 3.14;

    public static double getPI() {
        return PI;
    }

    public static double max(double a, double b) {
        return Math.max(a, b);
    }

    public static double round(double num) {
        return Math.round(num);
    }

    public static double factorial(double num) {

        double sum = 1;
        for (double i = 1; i <= num; i++) {
            sum *= i;
        }
        return sum;
    }

    public static int fibonacci(int num) {
        if (num <= 1) {
            return num;
            }
            else
            return fibonacci(num - 1) + fibonacci(num - 2);

    }
}
