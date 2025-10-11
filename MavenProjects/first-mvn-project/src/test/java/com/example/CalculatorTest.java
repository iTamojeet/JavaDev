package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    public void testAdd() {
        assertEquals(20,new Calculator().addNum(10,10));
    }
    @Test
    public void testSub() {
        assertEquals(0,new Calculator().subNum(10,10));
    }
    @Test
    public void testMul() {
        assertEquals(100,new Calculator().mulNum(10,10));
    }
    @Test
    public void testDiv() {
        assertEquals(10,new Calculator().divNum(100,10));
    }
}