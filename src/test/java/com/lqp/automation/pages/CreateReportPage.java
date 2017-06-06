package com.lqp.automation.pages;

import com.lqp.automation.keywords.SimpleKeywords;
import com.lqp.automation.web.pageobject.MyPageObject;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Managed;
import org.jruby.RubyGlobal;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Thuan Pham on 24/3/17.
 */
public class CreateReportPage extends MyPageObject{
    SharedFilterPage sharedFilterPage;
    SimpleKeywords simpleKeywords;

    @Managed
    WebDriver driver;

    public void inputQuery(String query){
        waitFor(ExpectedConditions.visibilityOf(element(By.id("editor"))));
        //getJavascriptExecutorFacade().executeScript("editor.setValue('"+query+"');");
        element(By.xpath("//div[@id=\"editor\"]/textarea[@class=\"ace_text-input\"]")).sendKeys(query);
    }
    public void openNewAdhocFilter(){
        selectTab("Report Filters");
        element(By.linkText("New Adhoc Filter")).click();
        String FILTER_NAME_XPATH = "//input[@ng-model='vm.filter.name']";
        withTimeoutOf(30, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.visibilityOf(element(By.xpath(FILTER_NAME_XPATH))));
    }

    public void addDateAdhocFilter(String fieldName, String defaultVaule){
//        selectTab("Report Filters");
//        element(By.linkText("New Adhoc Filter")).click();
        //openNewAdhocFilter();
        String FILTER_NAME_XPATH = "//input[@ng-model='vm.filter.name']";
//        withTimeoutOf(30, TimeUnit.SECONDS)
//                .waitFor(ExpectedConditions.visibilityOf(element(By.xpath(FILTER_NAME_XPATH))));
        element(By.xpath(FILTER_NAME_XPATH)).sendKeys(fieldName);
        element(By.xpath("//span[text()='Date']/../input")).click();
        element(By.xpath("//input[@ng-model='filter.default']")).sendKeys(defaultVaule);
    }
    public void selectDatabase(String database){
        selectFromDropdown(element(By.id("report-ds")), database);
    }

    public void selectXaxis(){
        selectFromDropdown(element(By.xpath("" +
                "//select[@ng-model=\"vm.report.viz.chart_options.x_axis_columns[0]\"]")), "gender");
    }

    public void setReportTitle(String title){
        element(By.xpath("//input[@placeholder='(Report Title)']")).sendKeys(title);
    }

    public void saveReport(){
        element(By.buttonText("Save Report")).click();
        waitABit(2);
//        simpleKeywords.waitForElementPresent("//h3[@ng-click=\"vm.debug.showing = !vm.debug.showing\"]");
    }
    public void filterWithStartAndEndDate(String startDate, String endDate){
        withTimeoutOf(60,TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("start_date")));
        waitABit(2);
        getJavascriptExecutorFacade()
                .executeScript("arguments[0].setAttribute('value', '" + startDate + "')", element(By.name("start_date")));
        getJavascriptExecutorFacade()
                .executeScript("arguments[0].setAttribute('value', '" + endDate + "')", element(By.name("end_date")));
        element(By.id("submit-filter-btn")).click();

        String table= "//table//tr/td[2]";
        withTimeoutOf(15, TimeUnit.SECONDS.SECONDS)
                .waitFor(table);
        Assert.assertEquals(element(org.openqa.selenium.By.xpath("//table//tr/td[2]")).getText(), "Lesson 1");
    }
    public void getErrorMessage_emptyTitle(){
       String expectedResult ="Error saving report. Title can't be blank";
        String getError;
       getError = element(By.xpath("//div[contains(text(),\"Error saving report. Title can't be blank\")]")).getText();
        Assert.assertEquals(expectedResult, getError);
    }
    public void selectTab(String tabName){
        switch (tabName){
            case "Metadata":
                element(By.xpath("//li/a/uib-tab-heading/icon[@i=\"info\"]")).click();
                break;
            case "Report Filters":
                element(By.xpath("//li/a/uib-tab-heading/icon[@i=\"filter\"]")).click();
                break;
            case "Query Editor":
                element(By.xpath("//li/a/uib-tab-heading/icon[@i=\"code\"]")).click();
                break;
            case "Visualization":
                element(By.xpath("//li/a/uib-tab-heading/icon[@i=\"viz-line-fa\"]")).click();
                break;
        }
    }
    public void addSharedFilter(){
        selectTab("Report Filters");
        element(org.openqa.selenium.By.linkText("Add Shared Filter")).click();
        String dropdown = "//select[@ng-model=\"vm.states.addSharedFilterId\"]";

        withTimeoutOf(15, TimeUnit.SECONDS)
                .waitFor(dropdown);
        selectFromDropdown(element(org.openqa.selenium.By.xpath(dropdown)), "To Date");
        element(org.openqa.selenium.By.xpath("//input[@value=\"Add Filter\"]")).click();
        WebElement checkExist = element(org.openqa.selenium.By.linkText("to_date"));
        Assert.assertTrue(checkExist.isDisplayed());
    }
    public void selectFolder(String folderName){
        selectTab("Metadata");
//        String folderName = "-- Testing";
        String pathFolder = "//i[@ng-click=\"$select.toggle($event)\"]/../span[contains(text(),\"Choose a folder..\")]";
        String selectFolder ="//span[@class=\"ng-binding ng-scope\" and contains(text(),\"" + folderName + "\")]";
        element(By.xpath(pathFolder)).click();
        waitABit(2);
        element(By.xpath(selectFolder)).click();

    }
    public void checkRunAndPreview(){
        selectTab("Report Filters");
        String runAndPreviewButton ="//div[@class=\"running-bar\"]/button[@ng-click=\"vm.preview.submit()\"]/span[@ng-show=\"vm.preview.state != 'loading'\"]/icon[@i=\"run-preview\"]";
        element(By.xpath(runAndPreviewButton)).click();
        simpleKeywords.waitForElementPresent("//table/tbody");
    }
    public void checkAfterClickOnRunAndPreview(){
        String expectedAttributeValue = "//table/tbody/tr[2]/td[2]/span";
        simpleKeywords.waitForElementPresent(expectedAttributeValue);
        WebElement element = element(By.xpath(expectedAttributeValue));
        boolean status = element.isDisplayed();
        System.out.println(status);
    }
    public void check_Quick_Pivot(){
        String expectedAttributeValue = "//table/tbody/tr[2]/td[2]/span";
        String checkBox ="//input[@ng-model=\"vm.settings.quick_pivot\"]";
        String id = "//div/table/thead/tr/th[1]/div/span";
        String name = "//div/table/thead/tr/th[2]/div/span";
        String start_date = "//div/table/thead/tr/th[3]/div/span";
        String end_date = "//div/table/thead/tr/th[4]/div/span";
        String create_by = "//div/table/thead/tr/th[5]/div/span";
        String ex_id = "id";
        String ex_name="name";
        String ex_start_date="start_date";
        String ex_end_date="end_date",ex_create_by="2016-01-04T16:42:50.000+00:00";

        element(By.xpath(checkBox)).click();
        withTimeoutOf(15, TimeUnit.SECONDS.SECONDS)
                .waitFor(expectedAttributeValue);
        Assert.assertEquals(ex_id, element(By.xpath(id)).getText());
        Assert.assertEquals(ex_name,element(By.xpath(name)).getText());
        Assert.assertEquals(ex_start_date, element(By.xpath(start_date)).getText());
        Assert.assertEquals(ex_end_date,element(By.xpath(end_date)).getText());
        Assert.assertEquals(ex_create_by, element(By.xpath(create_by)).getText());

    }


    public void VisualizationCharts(){
        selectTab("Report Filters");
        selectTab("Visualization"); //open Visualization tab
        String expectedAttributeValue = "//table/tbody/tr[2]/td[2]/span";
        String checkBoxRenderVisualization ="//label/input[@ng-model=\"vm.report.viz.has_viz\"]";
        String pieChart = "//a[@class=\"chart-icon icon-pie\"]";
        element(By.xpath(checkBoxRenderVisualization)).click();
        withTimeoutOf(15, TimeUnit.SECONDS)
                .waitFor(pieChart);
        element(By.xpath(pieChart)).click();
        withTimeoutOf(15, TimeUnit.SECONDS)
                .waitFor("//p[contains(text(),\"X-axis\")]");

        //Initial data
        String list[]= {"gender", "count"};
        List<String> expected = Arrays.asList(list);

        //Get List from dropdown
        Select select = new Select(element(By.xpath("//select[@ng-model=\"vm.report.viz.chart_options.x_axis_columns[0]\"]")));
        List<WebElement> options = select.getOptions();
        String getList[] = new String[options.size()];
        for (int i=0; i< options.size();i++){
            getList[i]=options.get(i).getText();
            System.out.println(options.get(i).getText());
        }
        List<String> actual = Arrays.asList(getList);

        Assert.assertNotNull(actual);
        Assert.assertTrue(expected.size() == actual.size());
        Assert.assertTrue(expected.containsAll(actual));

        //Select X-axis
        selectFromDropdown(element(By.xpath("" +
                "//select[@ng-model=\"vm.report.viz.chart_options.x_axis_columns[0]\"]")), "count");
        //Select Y-Axis
        element(By.xpath("//div[@class=\"treeview\"]/div[1]/label")).click();

    }
    public void setMaximumDate_Human_Friendly_Value(){
        sharedFilterPage.setMaximumDate_Human_Friendly_Value();
    }
    public void clickSubmitAdhocFilter(){
        sharedFilterPage.clickSaveButton();
    }
    public void insertQueryTemplate(){
        selectTab("Query Editor");
        element(By.linkText("Query Template")).click();
        waitABit(2);
        element(org.openqa.selenium.By.linkText("usersList")).click();
        waitABit(10);
    }
    public void checkResultAfterInsertQueryTemplate(){
       withTimeoutOf(20, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath(
                                "//table/tbody/tr[1]/td[2]")));
        String result1= element(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
        String result2= element(By.xpath("//table/tbody/tr[1]/td[3]")).getText();
        String result3= element(By.xpath("//table/tbody/tr[5]/td[2]")).getText();
        String result4= element(By.xpath("//table/tbody/tr[5]/td[3]")).getText();

        Assert.assertEquals("admin", result1);
        Assert.assertEquals("Male", result2);
        Assert.assertEquals("Apollo", result3);
        Assert.assertEquals("Female", result4);
    }

    public void aggregations_Show_Total_Row(String whereCheck){
        if (whereCheck.equalsIgnoreCase("inCreateReport")){
            String checkbox = "//input[@ng-model=\"vm.settings.show_total\"]";
            element(org.openqa.selenium.By.xpath(checkbox)).click();
        }
        withTimeoutOf(20, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath(
                                "//table/tbody/tr[1]/td[2]")));
        String getText = element(org.openqa.selenium.By.xpath("//table/tbody/tr[1]/td[1]")).getText();
        boolean trueFalse = getText.contains("10");
        System.out.println(trueFalse);
    }
    public void doNotLoadDataAutomatically(String checkWhere){
        if(checkWhere.equalsIgnoreCase("inCreateReport")){
            String checkbox = "//input[@ng-model=\"vm.settings.disable_auto_load\"]";
            element(org.openqa.selenium.By.xpath(checkbox)).click();
        }
        if(checkWhere.equalsIgnoreCase("inReportDetails")){
            withTimeoutOf(20, TimeUnit.SECONDS)
                    .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            net.serenitybdd.core.annotations.findby.By.xpath(
                                    "//button[@ng-click=\"vm.submitQuery()\"]")));
            String textNotLoad = element(By.xpath("//div[contains(text(),'(Data not yet loaded)')]")).getText();

            Assert.assertEquals("(Data not yet loaded)",textNotLoad);
            element(org.openqa.selenium.By.xpath("//button[@ng-click=\"vm.submitQuery()\"]")).click();
            withTimeoutOf(60, TimeUnit.SECONDS)
                    .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            net.serenitybdd.core.annotations.findby.By.xpath(
                                    "//table/tbody/tr[1]/td[2]")));
            String getText = element(org.openqa.selenium.By.xpath("//table/tbody/tr[1]/td[1]")).getText();
            boolean trueFalse = getText.contains("1");
            System.out.println(trueFalse);
        }
    }
}
