package com.example;
/**
 * Author: iTamojeet
 * Date: 2024-03-05
 */

import java.util.ArrayList;
import java.util.List;

public class LengthofString {
    public static void LengthOfString(List<String> list) {
        for (String str : list) {
            if (str.length() > 3) {
                System.out.println(str);                  //print the string having length > 3 characters
            }
        }
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();      //create a list of 5 strings
        list.add("Java");
        list.add("Python");
        list.add("C");
        list.add("JS");
        list.add("C++");

        LengthOfString(list);
    }

}
