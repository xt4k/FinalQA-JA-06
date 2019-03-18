package com.academy.automationpractice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class AuthTests {
    private String commonProperties = "D:/programming/java/QA-JA-06/maven/src/main/resources/common.properties";
    private WebDriver driver;
    private String baseUrl;
    private String geckoDriver;
    private String chromeDriver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        initDrivers();

        baseUrl = "http://automationpractice.com/index.php";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    private void initDrivers() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(commonProperties));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver"));
        System.setProperty("webdriver.gecko.driver", properties.getProperty("gecko.driver"));
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("oleg.kh81@gmail.comqwerere");
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("123qwertyasdd");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Forgot your password?'])[1]/following::span[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Authentication'])[2]/following::div[1]")).click();
        try {
            assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Authentication'])[2]/following::li[1]")).getText(), "Authentication failed.");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
