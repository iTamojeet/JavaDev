package com.example.suite;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import static org.junit.jupiter.api.Assertions.*;
@Suite
@SelectClasses(TestA.class)
class Test {

}