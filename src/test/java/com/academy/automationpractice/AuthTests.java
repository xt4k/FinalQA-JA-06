package com.academy.automationpractice;

import com.academy.automationpractice.model.AuthData;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class AuthTests {
    private WebDriver driver;
    private String baseUrl;

    private String errorMessageCssLocator = "#center_column > div.alert.alert-danger > ol > li";

    private StringBuffer verificationErrors = new StringBuffer();

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("firefox") String browser) throws Exception {
        initDrivers(browser);

        baseUrl = "http://automationpractice.com/index.php";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private void initDrivers(String browser) {
        // Здесь читаю пусть к файлу конфигурации
        String commonProperties = System.getProperty("common.cfg");
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(commonProperties));
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver"));
                driver = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("gecko.driver"));
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("Unknown browser " + browser);
        }
    }

    @Test(dataProvider = "authDataProvider")
    public void testUntitledTestCase(String login, String password, String expectedMessage) throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();

        // Заполняем форму логин/пароль
        WebElement loginField = driver.findElement(By.id("email"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(login);

        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();

        WebElement webElementWithErrorMessage = driver.findElement(By.cssSelector(errorMessageCssLocator));
        String actualErrorMessage = webElementWithErrorMessage.getText();
        try {
            assertEquals(actualErrorMessage, expectedMessage);
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    private List<AuthData> readTestData() {
        List<AuthData> testDataList = new ArrayList<>();

        // Прочитать из excel файла
        return testDataList;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    // TODO move path to property
    @DataProvider(name="authDataProvider")
    public Object[][] authDataProvider() throws IOException {
        String pathData = "D:/programming/java/QA-JA-06/maven/test-data/automationpractice-auth-data.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook( new FileInputStream( pathData ) );
        XSSFSheet sheet = workbook.getSheet( "Sheet1" );
        Object[][] testData = new Object[sheet.getLastRowNum()][3];
        System.out.println(sheet.getLastRowNum());
        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            XSSFRow parRow = sheet.getRow(i);
            testData[i-1][0] = (parRow.getCell(0) == null) ? "" : parRow.getCell(0).getStringCellValue();
            testData[i-1][1] = (parRow.getCell(1) == null) ? "" : parRow.getCell(1).getStringCellValue();
            testData[i-1][2] = parRow.getCell(2).getStringCellValue();
        }
        return testData;
    }
}
