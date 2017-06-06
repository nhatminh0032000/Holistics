package com.lqp.automation.pages;

import com.lqp.automation.keywords.SimpleKeywords;
import com.lqp.automation.web.pageobject.MyPageObject;
import net.serenitybdd.core.annotations.findby.By;
import org.junit.Assert;


/**
 * Created by thuan549 on 6/2/2017.
 */
public class DataTransformationCreationPage extends MyPageObject {
    SimpleKeywords simpleKeywords;

    public void openNewDataTransformation(){
        element(By.linkText("Add new data transformation")).click();
        simpleKeywords.waitForElementPresent("//h3[contains(text(),\"New Data Transform\")]");
    }
    public void newDataTransformationName(String dataTransformationName){
        element(By.xpath("//input[@ng-model=\"ctrl.transform.title\"]")).sendKeys(dataTransformationName);
    }
    public void transformationTypeSelection(String transformationType){
        switch (transformationType){
            case "Materialized (Full)":
                element(By.xpath("//input[@value=\"materialized_full\"]")).click();
                break;
            case "Materialized (Incremental)":
                element(By.xpath("//input[@value=\"materialized_incremental\"]")).click();
                break;
            case "Generic Transform":
                element(By.xpath("//input[@value=\"Generic Transform\"]")).click();
                break;
        }
    }
    public void dataSourceSelection(String dataSourceSelection){
        selectFromDropdown(element(By.xpath("//select[@ng-model=\"ctrl.dbSource\"]")), dataSourceSelection);
    }
    public void enterTableName(String tableName){
        element(By.xpath("//input[@ng-model=\"ctrl.tableName\"]")).sendKeys(tableName);
    }
    public void enterQuery(String queryName){
        element(By.xpath("//div[@id=\"editor2\"]/textarea[@class=\"ace_text-input\"]")).sendKeys(queryName);
    }
    public void validateQuery(){
        element(By.linkText("Validate")).click();
        simpleKeywords.waitForElementPresent("//span[@ng-show=\"ctrl.query.validated\"]");
        String checkQuery = element(By.xpath("//span[@ng-show=\"ctrl.query.validated\"]")).getText();
        Assert.assertEquals("Query validated", checkQuery);
    }
    public void validateTableStructure(){
        element(By.xpath("//button[@ng-click=\"ctrl.submitValidateColumns()\"]")).click();
        simpleKeywords.waitForElementPresent("//span[@ng-show=\"ctrl.columns.validated\"]");
        String checkQuery = element(By.xpath("//span[@ng-show=\"ctrl.columns.validated\"]")).getText();
        Assert.assertEquals("Columns validated",checkQuery);
    }
    public void clickSaveButton(){
        element(By.xpath("//button[@ng-click=\"ctrl.save(ctrl.transform)\"]")).click();
    }
    public void previewAndAutoFillColumns(){
        element(By.linkText("Preview & Auto-fill Columns")).click();
        simpleKeywords.waitForElementPresent("//th[text()=\"Column Name\"]");
    }
    public void verifyNewDataTransformationCreated(String dataTranformsName){
        String getFirstRow = element(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
        Assert.assertEquals(dataTranformsName,getFirstRow);
    }
}
