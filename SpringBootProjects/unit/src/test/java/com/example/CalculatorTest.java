package com.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculatorTest {

    @Test
    @Order(2)
    public void test() {
//        Calculator calculator = new Calculator();
//        int result = calculator.calculator(1, 2);
//        assertEquals(5, result);
        System.out.println("Test1...");
    }

    @Test
    @Order(3)
    public void test2() {
//
        System.out.println("Test2...");
    }

    @RepeatedTest(3)
    @Order(1)
    void test3() {
//        Calculator calculator = new Calculator();
//        assertTrue(calculator.greater(5,10));
        System.out.println("Test3...");
    }

    @ParameterizedTest
    @CsvSource({
        "0,1",
        "1,1",
        "2,2",
        "3,6",
        "4,24",
        "5,120"
    })
    void fact(int no, int expected){
        assertEquals(expected, new Calculator().factorial(no));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/source.csv")
    void factCSVFile(int no, int expected){
        assertEquals(expected, new Calculator().factorial(no));
    }

}