package com.example;
/**
 * Author: iTamojeet
 * Date: 2024-03-05
 */

import java.util.ArrayList;
import java.util.List;

public class ForEachonString {
    public static void Display(List<String> list) {
        for (String str : list) {                             //for each loop
            System.out.println(str);
        }
    }
    public static void main(String[] args) {                         //main method
        List<String> list = new ArrayList<>();  //create a list of strings
        list.add("Diplodocus");
        list.add("Brachiosaurus");
        list.add("Turiasaurus");
        list.add("Austroposeidon");
        list.add("Tyrannosaurus Rex");

        Display(list);
    }
}
