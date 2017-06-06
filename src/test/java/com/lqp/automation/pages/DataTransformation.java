package com.lqp.automation.pages;

import com.lqp.automation.keywords.SimpleKeywords;
import com.lqp.automation.web.pageobject.MyPageObject;
import net.serenitybdd.core.annotations.findby.By;
import org.junit.Assert;


/**
 * Created by thuan549 on 6/2/2017.
 */
public class DataTransformation extends MyPageObject {
    SimpleKeywords simpleKeywords;

    public void openDataTransformationPage(){
        String dataImports ="//a[@class=\"title\"]/span[contains(text(),\"Data Transforms\")]";
        element(By.xpath(dataImports)).click();
        simpleKeywords.waitForElementPresent("//h2[contains(text(),\"Data Transformation\")]");
    }
    public void checkDataTransformationPageLoaded(){
        simpleKeywords.waitForElementPresent("//h2[contains(text(),\"Data Transformation\")]");
        Assert.assertEquals("Data Transformation",element(By.xpath("//h2[contains(text(),\"Data Transformation\")]")).getText());
    }
}
