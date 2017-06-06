package com.lqp.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

/**
 * Created by thuan549 on 5/6/2017.
 */
public class ReportsListPage extends PageObject {
    HomePage homePage;

    public void openLeftNav(){
        homePage.openLeftNav();
    }
    public void openReportsList(){
        String reportLink ="//a/span[text()='Reports']";
        String reportTilte = "//h2[contains(text(),'Home')]";
        element(By.xpath(reportLink)).click();
        withTimeoutOf(15, TimeUnit.SECONDS)
                .waitFor(reportTilte);
        //open Testing folder
        element(By.xpath("//a/span[text()='Automation']")).click();
        //waiting the Testing folder is opened
        withTimeoutOf(15, TimeUnit.SECONDS)
                .waitFor("//h2[contains(text(),'Automation')]");
        //open Permission folder
        element(By.xpath("//a/span[text()='Permission']")).click();
        //waiting the Permission folder is opened
        withTimeoutOf(15, TimeUnit.SECONDS)
                .waitFor("//h2[contains(text(),'Permission')]");
        Assert.assertTrue(isElementVisible(By.xpath("//h2[contains(text(),'Permission')]")));
        //Admin should see 4 reports

    }
    public void openReportsPage(){
        String reportLink ="//a/span[text()='Reports']";
        String reportTilte = "//h2[contains(text(),'Home')]";
        element(By.xpath(reportLink)).click();
        withTimeoutOf(15, TimeUnit.SECONDS)
                .waitFor(reportTilte);
    }
    public void openFolder(String folderName){
        //open Testing folder
        String pathFolder = "//a/span[text()='"+folderName+"']";
        element(By.xpath(pathFolder)).click();
        //waiting the Testing folder is opened
        String waitForElementAppears = "//h2[contains(text(),'"+folderName+"')]";
        withTimeoutOf(15, TimeUnit.SECONDS)
                .waitFor(waitForElementAppears);
        Assert.assertTrue(isElementVisible(By.xpath(waitForElementAppears)));
    }
}
