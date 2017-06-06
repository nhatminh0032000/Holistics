package com.lqp.automation.pages;


import com.lqp.automation.web.pageobject.MyPageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * Created by thuan549 on 4/3/2017.
 */
public class SharedFilterPage extends MyPageObject {
    //Define object





    public void openNewSharedFilterPopup(){
        String title = "//h3[text()=\"New Shared Filter\"]";
        String expectedTitle = "New Shared Filter";
        element(By.linkText("New Shared Filter")).click();
        waitABit(3);
        String getTitle= element(By.xpath(title)).getText();
        Assert.assertEquals(expectedTitle,getTitle);
    }
    public void enterNameForSharedFilter(String name){
        String nameField= "//input[@ng-model=\"vm.filter.name\"]";
        element(By.xpath(nameField)).sendKeys(name);
    }
    public void selectFilterType(String filterType){
        String dateFilter = "//label/span[text()=\"Date\"]/../input[@type=\"radio\"]";
        String dateRangeFilter = "//label/span[text()=\"Date Range\"]/../input[@type=\"radio\"]";
        switch (filterType){
            case "Date":
                element(By.xpath(dateFilter)).click();
                break;
            case "Date Range":
                element(By.xpath(dateRangeFilter)).click();
                break;
        };
    }
    public void enterDefaultValue(String defaultValue){
        String defaultValueField ="//input[@ng-model='filter.default']";
        element(By.xpath(defaultValueField)).sendKeys(defaultValue);
    }
    public void enterHelptext(String helpText){
        String helpTextField = "//input[@ng-model='filter.help_text']";
        element(By.xpath(helpTextField)).sendKeys(helpText);
    }
    public void clickSaveButton(){
        String saveButton = "//button[@ng-click=\"vm.submit()\"]";
        element(By.xpath(saveButton)).click();
    }
    public void verifyMessage(String expectedResult){
        String getMessageAfterCreatig = "//div[contains(text(),\"Shared Filter added successfully\")]";
        //Shared Filter updated successfully
        String actualResult = element(By.xpath(getMessageAfterCreatig)).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }
    public void verify_Shared_Filter_Is_Created(String sharedFilterName){
        Assert.assertTrue(getDriver().getPageSource().contains(sharedFilterName));
    }

    public void select_Allow_Empty_Value(){
        String allowEmptyValue ="//input[@ng-model=\'filter.date_allow_empty\']";
        element(By.xpath(allowEmptyValue)).click();
    }
    public void setMinimumDate_Human_Friendly_Value(){
        String selectSetMinimumdDate = "//input[@ng-model=\'filter.date_min_toggle\']";
        String dropdownSelectState = "//select[@ng-model='filter.date_min_type']";
        String setMinimumDate = "10 days ago";
        String setMiniumuDateField = "//input[@ng-model='filter.date_min_human' and @type='text']";
        element(By.xpath(selectSetMinimumdDate)).click();
        waitABit(3);
        Select dropdownStateSelection = new Select(element(By.xpath(dropdownSelectState)));
        dropdownStateSelection.selectByVisibleText("Human friendly value");
        waitABit(3);
        element(setMiniumuDateField).sendKeys(setMinimumDate);
    }
    public void setMinimumDateFromDataSource(){
        String selectSetMinimumdDate = "//input[@ng-model=\'filter.date_min_toggle\']";
        String dropdownSelectState = "//select[@ng-model='filter.date_min_type']";
        String dropdownSelectDataSource = "//select[@ng-model='filter.date_min_ds_id']";
        String dataSource="WPL-Production";
        String sql ="select * from marketplace.cities";
        String sqlTextArea = "//div[@ng-model=\"filter.date_min_sql\"]/textarea[@class=\"ace_text-input\"]";
        element(By.xpath(selectSetMinimumdDate)).click();
        waitABit(2);
        Select dropdownStateSelection = new Select(element(By.xpath(dropdownSelectState)));
        dropdownStateSelection.selectByVisibleText("From data source");
        waitABit(2);
        Select dropdownDataSource = new Select(element(By.xpath(dropdownSelectDataSource)));
        dropdownDataSource.selectByVisibleText(dataSource);
        waitABit(2);
        element(By.xpath(sqlTextArea)).sendKeys(sql);
    }

    public void setMaximumDate_Human_Friendly_Value(){
        String selectSetMaximumdDate = "//input[@ng-model=\'filter.date_max_toggle\']";
        String dropdownSelectState = "//select[@ng-model='filter.date_max_type']";
        String setMaxiumuDateField = "//input[@ng-model='filter.date_max_human' and @type='text']";
        String setMaximumDate = "2017-04-30";


        element(By.xpath(selectSetMaximumdDate)).click();
        waitABit(3);
        Select dropdownStateSelection = new Select(element(By.xpath(dropdownSelectState)));
        dropdownStateSelection.selectByVisibleText("Human friendly value");
        waitABit(3);
        element(setMaxiumuDateField).sendKeys(setMaximumDate);
    }

    public void setMaximumDateFromDataSource(){
        String selectSetMaximumdDate = "//input[@ng-model=\'filter.date_max_toggle\']";
        String dropdownSelectState = "//select[@ng-model='filter.date_max_type']";
        String dropdownSelectDataSource = "//select[@ng-model='filter.date_max_ds_id']";
        String dataSource="WPL-Production";
        String sql ="select * from marketplace.cities";
        String sqlTextArea = "//div[@ng-model=\"filter.date_max_sql\"]/textarea[@class=\"ace_text-input\"]";

        String setMaximumDate = "3 days ago";
        element(By.xpath(selectSetMaximumdDate)).click();
        waitABit(2);
        Select dropdownStateSelection = new Select(element(By.xpath(dropdownSelectState)));
        dropdownStateSelection.selectByVisibleText("From data source");
        waitABit(2);
        Select dropdownDataSource = new Select(element(By.xpath(dropdownSelectDataSource)));
        dropdownDataSource.selectByVisibleText(dataSource);
        waitABit(2);
        element(By.xpath(sqlTextArea)).sendKeys(sql);
    }
    public void setPermission(){
        String showTextarea = "//span[@ng-click=\"showPerms = !showPerms\"]";
        String editorTextarea ="//div[@id=\"ci-ace-permissions\"]/textarea[@class=\"ace_text-input\"]";
        String permission = "permissions:\n" +
                "- if_user: nhatminh0032000@gmail.com\n" +
                "  then_date_min: \"2017-03-01\"";
        element(By.xpath(showTextarea)).click();
        element(By.xpath(editorTextarea)).sendKeys(permission);
    }
    public void checkDateInFilter(){
        withTimeoutOf(20, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath(
                                "//input[@name=\"start_date\"]/../input[1]")));
        String getDate=element(org.openqa.selenium.By.xpath("//input[@name=\"start_date\"]/../input[1]")).getAttribute("data-max-date");
        String setMaximumDate = "2017-04-30";
        Assert.assertEquals(setMaximumDate, getDate);
    }
    public void submitSharedFilter(){
        element(net.serenitybdd.core.annotations.findby.By.buttonText("Submit")).click();
    }
}
