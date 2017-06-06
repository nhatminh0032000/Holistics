package com.lqp.automation.pages;

import com.lqp.automation.keywords.SimpleKeywords;
import com.lqp.automation.web.pageobject.MyPageObject;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by thuan549 on 5/1/2017.
 */
public class DashboardPage extends MyPageObject {
    SimpleKeywords simpleKeywords;
    @Managed
    WebDriver driver;
    public void openDashboardPage(){
        String dashboardMenu ="//a[@class=\"title\"]/span[contains(text(),\"Dashboards\")]";
        element(By.xpath(dashboardMenu)).click();
        String dashBoardLink = "//a[contains(text(),'To Dashboards Page')]";
        withTimeoutOf(20, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath(dashBoardLink)));

        element(By.xpath(dashBoardLink)).click();
        withTimeoutOf(20, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath("//h2[contains(text(),'Dashboards')]")));

    }
    public void openDashboardDetails(){
        element(By.linkText("Auto Permission Users in Classes")).click();

        withTimeoutOf(20, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath("//ol[@class=\"breadcrumb\"]")));
    }
    public void createDashboard(){
        String dashboardMenu ="//a[@class=\"title\"]/span[contains(text(),\"Dashboards\")]";
        element(By.xpath(dashboardMenu)).click();
        element(By.xpath("//a[contains(text(),\"New Dashboard\")]")).click();
        withTimeoutOf(10, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.id("dashboard-name")));
        element(By.id("dashboard-name")).sendKeys("AutoDashboard");
        element(By.xpath("//button[@ng-click=\"submit()\"]")).click();
    }
    public void addReportToDashboard(){
        String addButton = "//div[@class=\"btn-group dropdown\"]/button/icon[@i=\"add\"]";
        String reportMenu ="//a[@ng-click=\"vm.editWidgetModal('QueryReport')\"]";
        String getTitle = "//h3/span[contains(text(),'Add Report')]";
        element(By.xpath(addButton)).click();
        element(By.xpath(reportMenu)).click();
        withTimeoutOf(10, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath(getTitle)));
        String expectedResult = "Add Report Widget to Dashboard \"AutoDashboard\"";
        String actualResult = element(By.xpath(getTitle)).getText();
        Assert.assertEquals(expectedResult, actualResult);

        selectFromDropdown(element(By.xpath("//select[@title=\"select report\"]")), "---- Gender Counter");
        element(By.xpath("//input[@ng-model=\"vm.ui.reportTitle\"]")).sendKeys("Auto add title");
        element(By.xpath("//button[@ng-click=\"vm.submit()\"]")).click();
        String expectedTitle = "AUTO ADD TITLE";
        String titlePopup = "//a[contains(text(),'Auto add title')]";
        withTimeoutOf(10, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath(titlePopup)));

        String actualTitle = element(By.xpath("//a[contains(text(),'Auto add title')]")).getText();
        Assert.assertEquals(expectedTitle,actualTitle);

    }
    public void addMetricToDashboard(){
        String addButton = "//div[@class=\"btn-group dropdown\"]/button/icon[@i=\"add\"]";
        String metricMenu ="//a[@ng-click=\"vm.editWidgetModal('QueryMetric')\"]";
        String getTitle = "//h3/span[contains(text(),'Add Metric Widget')]";
        element(By.xpath(addButton)).click();
        element(By.xpath(metricMenu)).click();
        withTimeoutOf(10, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath(getTitle)));
        String expectedResult = "Add Metric Widget to Dashboard \"AutoDashboard\"";
        String actualResult = element(By.xpath(getTitle)).getText();
        Assert.assertEquals(expectedResult, actualResult);

        selectFromDropdown(element(By.xpath("//select[@title=\"select metric\"]")), "Class");
        element(By.xpath("//input[@ng-model=\"vm.ui.title\"]")).sendKeys("Total Class");
        element(By.xpath("//button[@ng-click=\"vm.submit()\"]")).click();
        String expectedTitle = "TOTAL CLASS";
        String titlePopup = "//a[contains(text(),'Total Class')]";
        withTimeoutOf(10, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath(titlePopup)));

        String actualTitle = element(By.xpath("//a[contains(text(),'Total Class')]")).getText();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    public void addTextToDashboard(){
        String addButton = "//div[@class=\"btn-group dropdown\"]/button/icon[@i=\"add\"]";
        String textMenu ="//a[@ng-click=\"vm.editWidgetModal('Text')\"]";
        String getTitle = "//h3[contains(text(),'Add Text Widget')]";
        element(By.xpath(addButton)).click();
        element(By.xpath(textMenu)).click();
        withTimeoutOf(20, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath(getTitle)));
        String expectedResult = "Add Text Widget to dashboard \"AutoDashboard\"";
        String actualResult = element(By.xpath(getTitle)).getText();
        Assert.assertEquals(expectedResult, actualResult);

        String table ="| Windows  | Windows  | Windows  | Windows  |\n" +
                "|----------|----------|----------|----------|\n" +
                "| 1512     | 1512     | 1512     |   1512   |\n" +
                "| 1512     | 1512     | 1512     |   1512   |\n" +
                "| 1512     | 1512     | 1512     |   1512   |\n" +
                "| 1512     | 1512     | 1512     |   1512   |\n" +
                "| 1512     | 1512     | 1512     |   1512   |";
       // getJavascriptExecutorFacade().executeScript("editor.setValue('"+table+"');");
        element(By.xpath("//div[@id=\"editor\"]/textarea[@class=\"ace_text-input\"]"))
                .sendKeys(table);
        element(By.xpath("//button[@ng-click=\"vm.submit()\"]")).click();
        String getValue = "//div[@class=\"text-widget-markdown-container\"]";
        withTimeoutOf(10, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath(getValue)));

        String actualTitle = element(By.xpath(getValue)).getText();
        Assert.assertNotNull(actualResult);
    }
    public void getDataInAColumn(){
        WebElement table_element = element(By.xpath("//table[@class=\"table table-browse-reports\"]/tbody"));
        //Cannot use code below becuase cannot cast
        //List<WebElement> tr_collection=element(By.xpath("//table[@class=\"table table-browse-reports\"]/tbody"));
        List<WebElement> tr_collection = table_element.findElements(By.xpath("//table[@class=\"table table-browse-reports\"]/tbody/tr"));

        int row_num, col_num;
        row_num = 1;col_num=1;
        for (WebElement trElement : tr_collection){
            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
          //  System.out.println("NUMBER OF COLUMNS="+td_collection.size());
            for (WebElement tdElement : td_collection){
                if(col_num==1){ //display column if you want
                    System.out.println("Row # " + row_num + ", Column #" + col_num + " Text " + tdElement.getText());
                }
                col_num++;
            }
            row_num++;
            col_num=1;
        }
    }
        //Verify that how many record match defined value in table.
    public int [] numberOfFoundRows(String nameTobeDelete){
        WebElement table_element = element(By.xpath("//table[@class=\"table table-browse-reports\"]/tbody"));
        List<WebElement> tr_collection = table_element.findElements(By.xpath("//table[@class=\"table table-browse-reports\"]/tbody/tr"));
        int [] rowToBeDeleted = new int[tr_collection.size()];
        int row_num=1, col_num=1, count =0;
        for (WebElement trElement : tr_collection){
            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
            for (WebElement tdElement : td_collection){
                if(col_num==1){ //display column if you want
                    String getDashboardName = tdElement.getText();
                    if(getDashboardName.contains(nameTobeDelete)){
                        rowToBeDeleted[count]=row_num;
                        count++;
                    }
                }
                col_num++;
                break;//exit for loop when searching one row
            }
            row_num++;
            col_num=1;
        }
        return rowToBeDeleted;
    }

    public int findNameToBeDeleted(String nameTobeDelete){
        WebElement table_element = element(By.xpath("//table[@class=\"table table-browse-reports\"]/tbody"));
        List<WebElement> tr_collection = table_element.findElements(By.xpath("//table[@class=\"table table-browse-reports\"]/tbody/tr"));
        int rowToBeDeleted = 0;
        int row_num=1, col_num=1, count =0;
        for (WebElement trElement : tr_collection){
            //td_collection keeps number of cell in a row
            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
            for (WebElement tdElement : td_collection){
                if(col_num==1){ //display column if you want
                    String getDashboardName = tdElement.getText();
                    if(getDashboardName.contains(nameTobeDelete)){
                        rowToBeDeleted =row_num;
                        count++;
                    }
                }
                col_num++;
                break;//exit for loop when searching one row
            }
            row_num++;
            col_num=1;
            if(rowToBeDeleted>0)
                break;
        }
        return rowToBeDeleted;
    }
    public void openDasboardDetailsToDeleted(String xPath){
        element(By.xpath(xPath)).click();
        withTimeoutOf(20, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath("//ol[@class=\"breadcrumb\"]")));
    }

    public void deleteAllRowsSameName(String xPathToBeDelete){
        //Step 1: Find how many rows which are found with work defined value
        int countRows=0;
        int foundRows[]= numberOfFoundRows(xPathToBeDelete);
        for(int i=0;i<foundRows.length;i++) {
            if (foundRows[i] > 0)
                countRows += 1;
            else
                break;
        }
        //Step 2: After knowing rows numbers, starting use loop to delete all record
        for (int i=0;i<countRows;i++){
            int getRowNumberToBeDeleted = findNameToBeDeleted(xPathToBeDelete);
            openDashboardPage();
            String getLinkName = "//table[@class=\"table table-browse-reports\"]/tbody/tr[" + getRowNumberToBeDeleted + "]/td[1]/a/span";
            openDasboardDetailsToDeleted(getLinkName);
            element(By.xpath("//button/span[@class=\"icon-wrap\"]")).click();
            element(By.xpath("//div/ul/li/a[@ng-click=\"vm.deleteDashboard()\"]")).click();
            element(By.xpath("//button[text()='Confirm']")).click();
            simpleKeywords.waitForElementPresent("//h2[contains(text(),\"Dashboards\")]");
        }
    }

    public void getAllDataInTable(){
        WebElement table_element = element(By.xpath("//table[@class=\"table table-browse-reports\"]/tbody"));
        //Cannot use code below becuase cannot cast
        //List<WebElement> tr_collection=element(By.xpath("//table[@class=\"table table-browse-reports\"]/tbody"));
        List<WebElement> tr_collection = table_element.findElements(By.xpath("//table[@class=\"table table-browse-reports\"]/tbody/tr"));

        int row_num, col_num;
        row_num = 1;col_num=1;
        for (WebElement trElement : tr_collection){
            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
            System.out.println("NUMBER OF COLUMNS="+td_collection.size());

            for (WebElement tdElement : td_collection){
                System.out.println("Row # " + row_num + ", Column #" + col_num + " Text " + tdElement.getText());
                col_num++;
            }
            row_num++;
        }
    }
}
