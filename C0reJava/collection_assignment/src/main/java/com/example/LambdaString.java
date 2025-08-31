package com.example;
/**
 * Author: iTamojeet
 * Date: 2024-03-05
 */

import java.util.ArrayList;
import java.util.List;

public class LambdaString {
    public static void PrintString(List<String> list) {
        list.forEach(s -> System.out.println(s));          // lambda expression
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();     // create a list
        list.add("Diplodocus");
        list.add("Brachiosaurus");
        list.add("Turiasaurus");
        list.add("Austroposeidon");
        list.add("Tyrannosaurus Rex");
        PrintString(list);
    }
}
