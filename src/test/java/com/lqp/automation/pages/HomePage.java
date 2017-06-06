package com.lqp.automation.pages;

import com.lqp.automation.web.pageobject.MyPageObject;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;



import java.util.concurrent.TimeUnit;

/**
 * Created by Thanh Chuong on 24/3/17.
 */
public class HomePage extends MyPageObject{
    @Managed
    WebDriver driver;
    public void openHomePage(){
        element(By.xpath("//h1[@class=\"app-name\"]/a[text()=\"Holistics\"]")).click();
    }
    public void openLeftNav(){
        //Need to check if Left Nav has already opened or not.
        String classAttr= "";
        classAttr = element(By.xpath("//div[@class=\"functions-nav\"]/div[@ng-click=\"vm.toggleSidebar()\"]")).getAttribute("class");
        if(classAttr.equals("sidebar-toggle")) {
            element(By.xpath("//div[@class=\"sidebar-toggle\"]")).click();
            ExpectedConditions.visibilityOf(element(By.linkText("Shared Filters")));
            String classAttr1 = element(By.xpath("//div[@ng-click=\"vm.toggleSidebar()\"]")).getAttribute("class");
            System.out.print(classAttr1);
        }
    }
    //Open New Report page
    public void goToCreateReportPage(){
        element(By.linkText("New Report")).click();
        withTimeoutOf(10,TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.visibilityOf(
                        element(By.buttonText("Save Report"))));
        String titleOfReportPage = getTitle();
        Assert.assertEquals("New Query Report - Epsilon Mobile",titleOfReportPage);
    }
    //open Shared Filter page
    public void goToSharedFilterPage(){
        element(By.xpath("//ul[@class=\"nav subnav\"]//span[contains(text(),\"Shared Filters\")]")).click();
    }
    public void checkPageIsLoadedWithTitle(String expectedResult){
        String getTitle = getDriver().getTitle();
        Assert.assertEquals(getTitle,expectedResult);
    }
}
