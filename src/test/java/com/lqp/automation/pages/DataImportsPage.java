package com.lqp.automation.pages;

import com.lqp.automation.keywords.SimpleKeywords;
import com.lqp.automation.web.pageobject.MyPageObject;
import net.serenitybdd.core.annotations.findby.By;
import org.junit.Assert;


/**
 * Created by thuan549 on 6/2/2017.
 */
public class DataImportsPage extends MyPageObject {
    SimpleKeywords simpleKeywords;

    public void openDataImportPage(){
        String dataImports ="//a[@class=\"title\"]/span[contains(text(),\"Data Imports\")]";
        element(By.xpath(dataImports)).click();
        simpleKeywords.waitForElementPresent("//h2[contains(text(),\"Data Imports\")]");
    }
    public void checkDataImportPageLoaded(){
        simpleKeywords.waitForElementPresent("//h2[contains(text(),\"Data Imports\")]");
        Assert.assertEquals("Data Imports",element(By.xpath("//h2[contains(text(),\"Data Imports\")]")).getText());
    }
}
