package com.lqp.automation.pages;

import com.lqp.automation.keywords.SimpleKeywords;
import com.lqp.automation.web.pageobject.MyPageObject;
import net.serenitybdd.core.annotations.findby.By;
import org.junit.Assert;


/**
 * Created by thuan549 on 6/2/2017.
 */
public class DataImportsCreationPage extends MyPageObject {
    SimpleKeywords simpleKeywords;

    public void openNewDataImport(){
        element(By.linkText("Add new data import")).click();
        simpleKeywords.waitForElementPresent("//h3[contains(text(),\"New Data Import\")]");
    }
    public void dataImportName(String DataImportName){
        element(By.xpath("//input[@ng-model=\"ctrl.import.title\"]")).sendKeys(DataImportName);
    }
    public void importSource(String shareLinkGoogleDrive, String sourceTypeSelection){
        sourceTypeSelection(sourceTypeSelection);
        if(sourceTypeSelection.equalsIgnoreCase("google_spreadsheet") || sourceTypeSelection.contains("Latest File")) {
            element(By.xpath("//input[@ng-model=\"ctrl.sourceForm.googleUrl\"]")).sendKeys(shareLinkGoogleDrive);
            element(By.linkText("Validate Source")).click();
        }else
        {
            element(By.xpath("//select[@ng-model=\"ctrl.sourceForm.dsSource\"]")).click();
            waitABit(3);
            element(By.xpath("//select[@ng-model=\"ctrl.sourceForm.dsSource\"]/option[text()=\"WPL-Production\"]")).click();
            waitABit(3);
            //  selectFromDropdown(element(By.xpath("//select[@ng-model=\"ctrl.sourceForm.dsSource\"]")), "WPL-Production");
            simpleKeywords.waitForElementPresent("//span[text()=\"Banks\"]");
            element(By.xpath("//span[text()=\"Banks\"]")).click();
        }
        simpleKeywords.waitForElementPresent("//span[@class=\"alert-inline alert-success ng-binding\"]");
        simpleKeywords.waitForElementPresent("//table/tbody/tr[1]/td[2]");
        String country1="Afghanistan";
        String actualResult1 =element(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
        Assert.assertEquals(country1,actualResult1);

        String country2="Albania";
        String actualResult2 =element(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
        Assert.assertEquals(country2, actualResult2);
    }
    public void sourceTypeSelection(String sourceType){
        switch (sourceType){
            case "google_spreadsheet":
                element(By.xpath("//input[@value=\"google_spreadsheet\"]")).click();
                break;
            case "Latest File in Google Folder":
                element(By.xpath("//input[@value=\"google_folder\"]")).click();
                break;
            case "Database Table":
                element(By.xpath("//input[@value=\"dbtable\"]")).click();
                break;
        }
    }
    public void  selectImportDestination(){
        selectFromDropdown(element(By.xpath("//select[@ng-model=\"ctrl.dbSource\"]")), "FashionShop");
        element(By.xpath("//input[@ng-model=\"ctrl.tableName\"]")).sendKeys("Banks");
    }
    //Just check Validate button on this section
    public void  syncConfiguration(){
        boolean disableOrNot = true;
        disableOrNot = element(org.openqa.selenium.By.xpath("//button[@disabled=\"disabled\"]")).isPresent();
        if (disableOrNot){
            element(By.xpath("//button[@ng-click=\"ctrl.syncForm.submitValidate()\"]")).click();
            simpleKeywords.waitForElementPresent("//span[contains(text(),\"Table structure validated\")]");
            String textSuccess = element(By.xpath("//span[contains(text(),\"Table structure validated\")]")).getText();
            String expectedResult = "Table structure validated";
            Assert.assertEquals(expectedResult, textSuccess);
        }else {
            Assert.assertFalse("The button validate should not disable.",disableOrNot);
        }
    }
    public void clickSaveButton(){
        boolean disableOrNot = true;
        disableOrNot = element(By.xpath("//button[@disabled=\"disabled\"][@ng-click=\"ctrl.submit()\"]")).isPresent();
        if(disableOrNot){
            Assert.assertFalse("The button validate should not disable.", disableOrNot);
        }else {
            element(By.xpath("//button[@ng-click=\"ctrl.submit()\"]")).click();
        }
    }

}
