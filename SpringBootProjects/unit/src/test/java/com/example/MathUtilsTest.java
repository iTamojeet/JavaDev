package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5})
    public void testIsEven(int number) {

        MathUtils m = new MathUtils();
        boolean result = m.isEven(number);
        assertTrue(result);
    }

}