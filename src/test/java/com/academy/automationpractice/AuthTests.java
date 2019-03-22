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

    private String errorMessageCssLocator = "#center_column > div.alert.alert-danger > ol > li";

    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        initDrivers();

        baseUrl = "http://automationpractice.com/index.php";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

        String[] logins = {"", "qwertyLogin"};
        String[] passwords = {"123", "qwertyPassword"};
        String[] expectedMessages = {"An email address required.", "Invalid email address."};

        for (int i = 0; i < logins.length; i++) {
            // Заполняем форму логин/пароль
            WebElement loginField = driver.findElement(By.id("email"));
            loginField.click();
            loginField.clear();
            loginField.sendKeys(logins[i]);
//            loginField.sendKeys("oleg.kh81@gmail.comqwerere");

            //driver.findElement(By.id("email")).clear();
            //driver.findElement(By.id("email")).sendKeys("oleg.kh81@gmail.comqwerere");
            driver.findElement(By.id("passwd")).click();
            driver.findElement(By.id("passwd")).clear();
            driver.findElement(By.id("passwd")).sendKeys("123qwertyasdd");
            driver.findElement(By.id("SubmitLogin")).click();

            WebElement webElementWithErrorMessage = driver.findElement(By.cssSelector(errorMessageCssLocator));
            String actualErrorMessage = webElementWithErrorMessage.getText();
            try {
                assertEquals(actualErrorMessage, "Authentication failed.");
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
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
