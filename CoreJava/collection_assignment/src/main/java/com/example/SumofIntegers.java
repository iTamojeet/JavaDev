package com.example;
/**
 * Author: iTamojeet
 * Date: 2024-03-05
 */

import java.util.ArrayList;
import java.util.List;

public class SumofIntegers {
    public static void display() {
        int[] numbers = {11,22,33,44,55};          // Array of integers
        List<Integer> numberList = new ArrayList<>();
        for (int number : numbers) {
            numberList.add(number);                   // Adding each number to the list
        }
        int sum = calculateSum(numberList);
        System.out.println("The sum of the numbers is: " + sum);
    }

    public static int calculateSum(List<Integer> list) {
        int sum = 0;
        for (int number : list) {
            sum += number;                   // Calculating the sum of the numbers in the list
        }
        return sum;
    }

    public static void main(String[] args) {
        display();
    }
}
