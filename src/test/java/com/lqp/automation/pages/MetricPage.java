package com.lqp.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * Created by thuan549 on 5/2/2017.
 */

public class MetricPage extends PageObject{
    public void openMetricPage(){
        element(By.xpath("//a/span[text()=\"Metrics\"]")).click();
        String title = "//h3[text()=\"Metrics\"]";
        String getTitle = element(By.xpath(title)).getText();
        Assert.assertEquals("Metrics",getTitle);
    }
    public void addNewMetrics(){
        element(By.linkText("New Metric")).click();
        String title = "//h2[contains(text(),\"New Metric\")]";
        withTimeoutOf(10, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath(title)));
        element(By.xpath("//input[@id=\"metric-title\"]")).sendKeys("Gender Metric");
        selectFromDropdown(element(By.xpath("//select[@id=\"metric-ds\"]")),"WPL-Production");
        element(By.xpath("//input[@id=\"metric-timefield\"]")).sendKeys("created_at");
        String sql ="SELECT COUNT(1) FROM users WHERE {{time_where}}";
        //getJavascriptExecutorFacade().executeScript("editor.setValue('"+table+"');");
        element(By.xpath("//div[@id=\"metric_editor\"]/textarea[@class=\"ace_text-input\"]"))
                .sendKeys(sql);
        element(By.xpath("//button[@type=\"button\"]")).click();
        withTimeoutOf(10, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath("//h3[text()=\"Metrics\"]")));
        element(By.xpath("//span[text()=\"Gender Metric\"]")).isDisplayed();

    }
}
