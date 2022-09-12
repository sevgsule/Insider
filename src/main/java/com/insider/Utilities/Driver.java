package com.insider.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static WebDriver driver;
//    private static WebDriverWait wait;

    public static ThreadLocal<WebDriver> driverThread = new ThreadLocal<WebDriver>();
    public static ThreadLocal<String> browserName = new ThreadLocal<String>();

    public static WebDriver getDriver() {
        if (browserName.get() == null) {
            browserName.set("chrome");
        }
        if (driverThread.get() == null) {
            switch (browserName.get()) {
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
//                    options.addArguments("--window-position=2000,0");
                    ChromeDriver chrome = new ChromeDriver();
//                    chrome.manage().window().setPosition(new org.openqa.selenium.Point(-2000, 0));
                    driverThread.set(chrome);
                }
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    driverThread.set(new FirefoxDriver());
                }
                case "edge" -> {
                    WebDriverManager.edgedriver().setup();
                    driverThread.set(new EdgeDriver());
                }
                default -> throw new RuntimeException("Browser is not supported");
            }
        }
        return driverThread.get();
    }

    public static void quitDriver() {
        if (driverThread.get() != null) {
            driverThread.get().quit();
            WebDriver driver = driverThread.get();
            driver = null;
            driverThread.set(driver);
        }
    }
}
