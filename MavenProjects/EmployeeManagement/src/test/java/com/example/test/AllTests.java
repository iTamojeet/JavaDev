package com.example.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ EmployeeServiceTest.class })
public class AllTests {
// This class remains empty. It only holds annotations for the test suite.
}