package com.academy.rozetka;

import com.academy.framework.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class FilterTests extends BaseTest {
    private String baseUrl = "https://rozetka.com.ua";

    @Test
    public void testFilterByPrice() {
        System.out.println("Start filter test");
        driver.get(baseUrl);

        String locatorMainLink = "body > app-root > div > div:nth-child(2) > app-rz-main-page > div > aside > main-page-sidebar > sidebar-fat-menu > div > ul > li:nth-child(9) > a";
        String mainMenuItemXPathLocator = "/html/body/app-root/div/div[1]/app-rz-main-page/div/aside/main-page-sidebar/sidebar-fat-menu/div/ul/li//a[contains(normalize-space(text()), 'Одежда, обувь и украшения')]";

        waitForJSandJQueryToLoad();
        WebElement mainLink = driver.findElement(By.xpath(mainMenuItemXPathLocator));
        Actions action = new Actions(driver);
        action.moveToElement(mainLink)
                .build()
                .perform();

        String menuItemXPathLocator = "/html/body/app-root/div/div[1]/div[1]/header/div/div[2]/div[1]/fat-menu/div/ul/li//a[contains(@class, 'menu__link') and contains(normalize-space(text()), 'Блузки и рубашки')]";
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(menuItemXPathLocator)));
        driver.findElement(By.xpath(menuItemXPathLocator)).click();

        String pricesCssLocator = "body > app-root > div > div:nth-child(2) > div.app-rz-catalog > div.central-wrapper > main > div.layout.layout_with_sidebar > section > app-goods > ul > li > app-goods-tile > app-goods-tile-default > div > div.goods-tile__inner > div.goods-tile__prices > div:nth-child(2) > p > span.goods-tile__price-value";
        String selectButtonCssLocator = "body > app-root > div > div:nth-child(2) > div.app-rz-catalog > div.central-wrapper > main > div:nth-child(1) > div > div.catalog-settings__sorting.js-app-sort > button";

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.cssSelector(selectButtonCssLocator)));

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(selectButtonCssLocator)));
        driver.findElement(By.cssSelector(selectButtonCssLocator)).click();
        driver.findElement(By.cssSelector("body > app-root > div > div:nth-child(2) > div.app-rz-catalog > div.central-wrapper > main > div:nth-child(1) > div > div.catalog-settings__sorting.js-app-sort > ul > li:nth-child(1) > a")).click();

//        waitForJSandJQueryToLoad();

        String goodCssLocator = "body > app-root > div > div:nth-child(2) > div.app-rz-catalog > div.central-wrapper > main > div.layout.layout_with_sidebar > section > app-goods > ul > li:nth-child(1) > app-goods-tile > app-goods-tile-default > div > div.goods-tile__inner > a.goods-tile__picture";
        waitForJSandJQueryToLoad();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.cssSelector(goodCssLocator)),
                        ExpectedConditions.urlContains("sort=cheap"),
                        (e)->isSorted(By.cssSelector(pricesCssLocator)))
                );
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        List<WebElement> prices = driver.findElements(By.cssSelector(pricesCssLocator));
        prices.stream().map(WebElement::getText).forEach(System.out::println);
    }

    protected boolean waitForJSandJQueryToLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            try {
                return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
            }
            catch (Exception e) {
                // no jQuery present
                return true;
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState")
                .toString().equals("complete");

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    private boolean isSorted(By byCss) {

        List<Double> numbers = driver.findElements(byCss).stream()
                .map(WebElement::getText)
                .map(s->s.replaceAll(" ", ""))
                .map(Double::valueOf)
                .collect(Collectors.toList());

        if (numbers.size() == 0)
            return true;

        Double max = numbers.get(0);
        for (Double n : numbers){
            if (n < max)
                return false;
            else
                max = n;
        }

        return true;
    }
}
