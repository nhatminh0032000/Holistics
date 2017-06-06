package com.lqp.automation.pages;

import com.lqp.automation.keywords.SimpleKeywords;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

/**
 * Created by thuan549 on 5/6/2017.
 */
public class ReportDetailsPage extends PageObject{
    SimpleKeywords simpleKeywords;

    public void openReportDetails(String reportName){
        String reportLink = "//a/span[contains(text(),"+"'"+reportName+"'"+")]";
        element(By.xpath(reportLink)).click();
        simpleKeywords.waitForElementPresent("//h1[@class=\"report-title\"]");
        String getTitle = element(By.xpath("//h1[@class=\"report-title\"]")).getText();
        getTitle = getTitle.replaceAll("\\s+","");
        reportName = reportName.replaceAll("\\s+","");
        System.out.println(getTitle + "----" + reportName);
        Assert.assertTrue(getTitle.contains(reportName));
    }
    public void selectMultipleOptions(){
        //button[@class="ui-multiselect ui-widget ui-state-default ui-corner-all"]
        element(By.xpath("//button[@class=\"ui-multiselect ui-widget ui-state-default ui-corner-all\"]")).click();
        element(By.xpath("//*[@id=\"ui-multiselect-3-option-0\"]")).click();
        waitABit(2);
        element(By.xpath("//label/input[@title=\"Nicholas\"]")).click();
    }
    public void clickSubmitButton(){
        element(By.xpath("//input[@id=\"submit-filter-btn\"]")).click();
        simpleKeywords.waitForElementPresent("//table/tbody/tr[1]");
    }
    public void checkOutputAfterFilterWithMultipleSelection(){
        //table/tbody/tr[1]/td[2]
        String actualResult1 = element(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
        Assert.assertEquals("John", actualResult1);
        String actualResult2 = element(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
        Assert.assertEquals("Nicholas", actualResult2);
    }
    public void checkReportDetailsPageLoaded(){
        simpleKeywords.waitForElementPresent("//h3[@ng-click=\"vm.debug.showing = !vm.debug.showing\"]");
    }
}
