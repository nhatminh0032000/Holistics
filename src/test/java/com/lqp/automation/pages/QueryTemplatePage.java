package com.lqp.automation.pages;

import com.lqp.automation.web.pageobject.MyPageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * Created by thuan.pham on 5/16/2017.
 */
public class QueryTemplatePage extends MyPageObject{
    public void openQueryTemplate(){
        element(By.xpath("//a/span[contains(text(),'Query Templates')]")).click();
        withTimeoutOf(10, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.visibilityOf(element
                        (By.xpath("//h3[contains(text(),'Query Templates')]"))));
        String actualResult = element(By.xpath("//h3[contains(text(),'Query Templates')]")).getText();
        Assert.assertEquals("Query Templates",actualResult);
    }
    public void newQueryTemplate(){
        //click button to open the Create New Query Template
        element(By.xpath("//button[contains(text(),'New Query Template')]")).click();
        withTimeoutOf(10, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.visibilityOf(element
                        (By.xpath("//h3[contains(text(),'New Query Template')]"))));
        String actualResult = element(By.xpath("//h3[contains(text(),'New Query Template')]\"")).getText();
        Assert.assertEquals("New Query Template",actualResult);

        //enter Query Template name
        element(By.xpath("//input[@ng-model=\"vm.qt.name\"]")).sendKeys("Auto Demo");
        //Enter description
        element(By.xpath("//textarea[@ng-model=\"vm.qt.description\"]")).sendKeys(
            "CASE {{column_name}}\n" +
                    "    WHEN 0 THEN 'Femle'\n" +
                    "    WHEN 1 THEN 'Male'\n" +
                    "    ELSE 'other'\n" +
                    "END"
        );
        //Enter variable
        element(By.xpath("//div[@ng-model=\"vm.qt.variables\"]/ul/li/input")).sendKeys("abc");
        element(By.xpath("//textarea[@class=\"ace_text-input\"]")).sendKeys("ok");
        System.out.println("ok");
    }
}
