package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {
    WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://meet.google.com/");
        Thread.sleep(5000);
        System.out.print("Before test");
    }

    @BeforeMethod
    public void initDriver() {
        System.out.print("Driver init");
    }

    @Test(priority = 2)
    public void login() throws InterruptedException {
        driver.get("http://www.google.com/");
        Thread.sleep(10000);
        System.out.print("Hello Test 1");
    }

    @Test(priority = 1)
    public void register() throws InterruptedException {
        driver.get("http://www.bing.com");
        Thread.sleep(10000);
        System.out.print("Hello Test 2");
    }

    @AfterTest
    public void exitDriver() {
        System.out.print("Exit Driver");
    }

    @AfterTest
    public void classtest() {
        System.out.print("Test end");
    }

}
