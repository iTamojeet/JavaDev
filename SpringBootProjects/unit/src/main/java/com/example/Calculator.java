package com.example;

public class Calculator {
    public int calculator(int a, int b) {
        return a + b;
    }

    int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    boolean greater(int a, int b) {
        return a>b;
    }

}
