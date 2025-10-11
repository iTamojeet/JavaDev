package com.example;

public class Calculator {
    public int addNum(int a, int b) {
        return a + b;
    }
    public int subNum(int a, int b) {
        return a - b;
    }
    public int mulNum(int a, int b) {
        return a * b;
    }
    public int divNum(int a, int b) {
        if(b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}
