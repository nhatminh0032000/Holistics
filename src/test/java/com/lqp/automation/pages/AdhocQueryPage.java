package com.lqp.automation.pages;

import com.lqp.automation.keywords.SimpleKeywords;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * Created by thuan549 on 5/2/2017.
 */

public class AdhocQueryPage extends PageObject{
    SimpleKeywords simpleKeywords;
    public void openAdhocQueryPage(){
        element(By.xpath("//a/span[text()=\"Adhoc Queries\"]")).click();
        String title = "//h2[text()=\"Adhoc Queries\"]";
        simpleKeywords.waitForElementPresent(title);
        String getTitle = element(By.xpath(title)).getText();
        Assert.assertEquals("Adhoc Queries",getTitle);
    }
    public void openNewAdhocQueryPage(){
        element(By.linkText("New Query")).click();
        simpleKeywords.waitForElementPresent("//ol/li[2]");
        String getTitle = element(By.xpath("//ol/li[2]")).getText();
        Assert.assertEquals("New Query",getTitle);
    }
    public void createNewAdhocQuery(){
        selectFromDropdown(element(By.xpath("//select[@id=\"adhoc_query_data_source_id\"]")),"WPL-Production");
        String sql ="select * from users";
        //getJavascriptExecutorFacade().executeScript("editor.setValue('"+table+"');");
        element(By.xpath("//div[@id=\"adhoc-editor\"]/textarea[@class=\"ace_text-input\"]"))
                .sendKeys(sql);
        element(By.xpath("//button[@ng-click=\"vm.submit()\"]")).click();
        simpleKeywords.waitForElementPresent("//label[@class=\"label label-success\"]");
        element(By.xpath("//table/tbody/tr[1]/td[2]")).isDisplayed();
    }
}
