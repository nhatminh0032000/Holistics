package com.lqp.automation.keywords;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Created by thuan549 on 4/21/2017.
 */
public class SimpleKeywords extends PageObject {
    @Managed
    static WebDriver driver;
    public String getText(By by){
        return driver.findElement(by).getText();
    }
    public void dropdownSelection(By by,String strText){
        Select dropdown = new Select(driver.findElement(by));
    }

    public static void scrollToBottom() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public void waitForElementPresent(String elementPresent){
        //withTimeoutOf(30, TimeUnit.SECONDS)
        //        .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
        //                net.serenitybdd.core.annotations.findby.By.xpath(elementPresent)));
        withTimeoutOf(30,TimeUnit.SECONDS).elementIsPresent(By.xpath(elementPresent));
    }
}
