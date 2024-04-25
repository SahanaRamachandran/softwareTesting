package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {
    WebDriver driver;

    @Test(dataProvider = "data")
    public void Test(String username, String password) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // FileInputStream fs = new FileInputStream("D:\\d.Demobank.xlsx");
        // XSSFWorkbook workbook = new XSSFWorkbook(fs);
        // XSSFSheet sheet1 = workbook.getSheet("login");
        // XSSFRow row1 = sheet1.getRow(1);
        // String username = row1.getCell(0).getStringCellValue();
        // String password = row1.getCell(1).getStringCellValue();
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"))
                .sendKeys(username);
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"))
                .sendKeys(password);
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        Thread.sleep(3000);
        System.out.println(username + " " + password);
    }

    @DataProvider(name = "data")
    public Object[][] fetchData() throws Exception {
        Object[][] data = new Object[2][2];
        data[0][0] = "Sahana";
        data[0][1] = "S123";
        data[1][0] = "Sridevi";
        data[1][1] = "S123456";
        return data;
    }

    @AfterTest
    public void after() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}