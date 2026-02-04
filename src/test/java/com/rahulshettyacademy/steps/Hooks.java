package com.rahulshettyacademy.steps;

import com.rahulshettyacademy.core.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    private final DriverFactory driverFactory = new DriverFactory();

    @Before
    public void setUp() {
        driverFactory.initializeDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
