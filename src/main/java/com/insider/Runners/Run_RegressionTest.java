package com.insider.Runners;

import com.insider.Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;


public class Run_RegressionTest extends AbstractTestNGCucumberTests {

    @After
    public void closeBrowser() {
        Driver.quitDriver();
    }
}
