package com.lqp.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * Created by thuan549 on 5/6/2017.
 */
public class FilterPermisson extends PageObject{
    public void reportsList_AdminPermission(){
        Assert.assertTrue(isElementVisible(By.xpath("//a/span[text()=\"Gender Counter\"]")));
        Assert.assertTrue(isElementVisible(By.xpath("//a/span[text()=\"Permisson class\"]")));
        Assert.assertTrue(isElementVisible(By.xpath("//a/span[text()=\"User in class\"]")));
        Assert.assertTrue(isElementVisible(By.xpath("//a/span[text()=\"Users Classes Shared Filter\"]")));
        Assert.assertTrue(isElementVisible(By.xpath("//a/span[text()=\"number of articles\"]")));
    }
    public void reportsList_BusinessUserPermission(){
        Assert.assertFalse(isElementVisible(By.xpath("//a/span[text()=\"Gender Counter\"]")));
        Assert.assertTrue(isElementVisible(By.xpath("//a/span[text()=\"Permisson class\"]")));
        Assert.assertTrue(isElementVisible(By.xpath("//a/span[text()=\"User in class\"]")));
        Assert.assertTrue(isElementVisible(By.xpath("//a/span[text()=\"Users Classes Shared Filter\"]")));
        Assert.assertFalse(isElementVisible(By.xpath("//a/span[text()=\"number of articles\"]")));
    }
    public void reportsList_GroupPermission(){
        Assert.assertFalse(isElementVisible(By.xpath("//a/span[text()=\"Gender Counter\"]")));
        Assert.assertFalse(isElementVisible(By.xpath("//a/span[text()=\"Permisson class\"]")));
        Assert.assertTrue(isElementVisible(By.xpath("//a/span[text()=\"User in class\"]")));
        Assert.assertTrue(isElementVisible(By.xpath("//a/span[text()=\"Users Classes Shared Filter\"]")));
        Assert.assertFalse(isElementVisible(By.xpath("//a/span[text()=\"number of articles\"]")));
    }

    public void dashboardList_AdminPermission(){
        Assert.assertTrue(isElementVisible(By.xpath("//a/span[text()=\"Auto All Reports Permission\"]")));
        Assert.assertTrue(isElementVisible(By.xpath("//a/span[text()=\"Auto Gender Counter\"]")));
        Assert.assertTrue(isElementVisible(By.xpath("//a/span[text()=\"Auto Permission Users in Classes\"]")));
        Assert.assertTrue(isElementVisible(By.xpath("//a/span[text()=\"Auto Permission class\"]")));
        Assert.assertTrue(isElementVisible(By.xpath("//a/span[text()=\"Auto Users Classes Shared Filter\"]")));
        Assert.assertTrue(isElementVisible(By.xpath("//a/span[text()=\"Auto permission number of articles\"]")));
    }
    public void dashboardList_BusinessUserPermission(){
        Assert.assertFalse(isElementVisible(By.xpath("//a/span[text()=\"Auto All Reports Permission\"]")));
        Assert.assertFalse(isElementVisible(By.xpath("//a/span[text()=\"Auto Gender Counter\"]")));
        Assert.assertTrue(isElementVisible(By.xpath("//a/span[text()=\"Auto Permission Users in Classes\"]")));
        Assert.assertTrue(isElementVisible(By.xpath("//a/span[text()=\"Auto Permission class\"]")));
        Assert.assertFalse(isElementVisible(By.xpath("//a/span[text()=\"Auto Users Classes Shared Filter\"]")));
        Assert.assertFalse(isElementVisible(By.xpath("//a/span[text()=\"Auto permission number of articles\"]")));
    }
    public void dashboardList_GroupPermission(){
        Assert.assertTrue(isElementVisible(By.xpath("//a/span[text()=\"Auto All Reports Permission\"]")));
        Assert.assertFalse(isElementVisible(By.xpath("//a/span[text()=\"Auto Gender Counter\"]")));
        Assert.assertTrue(isElementVisible(By.xpath("//a/span[text()=\"Auto Permission Users in Classes\"]")));
        Assert.assertFalse(isElementVisible(By.xpath("//a/span[text()=\"Auto Permission class\"]")));
        Assert.assertFalse(isElementVisible(By.xpath("//a/span[text()=\"Auto Users Classes Shared Filter\"]")));
        Assert.assertFalse(isElementVisible(By.xpath("//a/span[text()=\"Auto permission number of articles\"]")));
    }

    public void switchUser(String userType){
        element(By.xpath("//a/span[text()='Impersonate']")).click();
        element(By.linkText(userType)).click();
    }
    public void adminSeeAllOptionsDropdown(){
        withTimeoutOf(60, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath(
                                "//input[@name=\"just_see_4_classes\"]/../select/option[2]")));
        String dropdown ="//input[@name=\"just_see_4_classes\"]/../div";
        element(By.xpath(dropdown)).click();
        waitABit(4);
        Boolean present1 = element(By.xpath(
                "//input[@name=\"just_see_4_classes\"]/../select/option[text()=\"Workplace Literacy\"]")).isPresent();
        Assert.assertTrue(present1);
        Boolean present2 = element(By.xpath(
                "//input[@name=\"just_see_4_classes\"]/../select/option[text()=\"WPL Beginners\"]")).isPresent();
        Assert.assertTrue(present2);
        Boolean present3 = element(By.xpath(
                "//input[@name=\"just_see_4_classes\"]/../select/option[text()=\"WPL Advanced\"]")).isPresent();
        Assert.assertTrue(present3);
        Boolean present4 = element(By.xpath(
                "//input[@name=\"just_see_4_classes\"]/../select/option[text()=\"WPL Intermediate\"]")).isPresent();
        Assert.assertTrue(present4);
        Boolean present5 = element(By.xpath(
                "//input[@name=\"just_see_4_classes\"]/../select/option[text()=\"TMLFB-16-02-05-T\"]")).isPresent();
        Assert.assertTrue(present5);
    }
    public void businessUserSeesRestrictedOptions(){
        withTimeoutOf(60, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath(
                                "//input[@name=\"just_see_4_classes\"]/../select/option[2]")));
        String dropdown ="//input[@name=\"just_see_4_classes\"]/../div";
        element(By.xpath(dropdown)).click();
        waitABit(4);
        Boolean present1 = element(By.xpath(
                "//input[@name=\"just_see_4_classes\"]/../select/option[text()=\"Workplace Literacy\"]")).isPresent();
        Assert.assertTrue(present1);
        Boolean present2 = element(By.xpath(
                "//input[@name=\"just_see_4_classes\"]/../select/option[text()=\"WPL Beginners\"]")).isPresent();
        Assert.assertTrue(present2);
        Boolean present3 = element(By.xpath(
                "//input[@name=\"just_see_4_classes\"]/../select/option[text()=\"WPL Advanced\"]")).isPresent();
        Assert.assertTrue(present3);
        Boolean present4 = element(By.xpath(
                "//input[@name=\"just_see_4_classes\"]/../select/option[text()=\"WPL Intermediate\"]")).isPresent();
        Assert.assertTrue(present4);
        Boolean present5 = element(By.xpath(
                "//input[@name=\"just_see_4_classes\"]/../select/option[text()=\"TMLFB-16-02-05-T\"]")).isPresent();
        Assert.assertFalse(present5);
    }
    public void groupSeesRestrictedOptions(){
        withTimeoutOf(60, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath(
                                "//input[@name=\"just_see_4_classes\"]/../select/option[2]")));
        String dropdown ="//input[@name=\"just_see_4_classes\"]/../div";
        element(By.xpath(dropdown)).click();
        waitABit(4);
        Boolean present1 = element(By.xpath(
                "//input[@name=\"just_see_4_classes\"]/../select/option[text()=\"Workplace Literacy\"]")).isPresent();
        Assert.assertTrue(present1);
        Boolean present2 = element(By.xpath(
                "//input[@name=\"just_see_4_classes\"]/../select/option[text()=\"WPL Beginners\"]")).isPresent();
        Assert.assertTrue(present2);
        Boolean present3 = element(By.xpath(
                "//input[@name=\"just_see_4_classes\"]/../select/option[text()=\"WPL Advanced\"]")).isPresent();
        Assert.assertFalse(present3);
        Boolean present4 = element(By.xpath(
                "//input[@name=\"just_see_4_classes\"]/../select/option[text()=\"WPL Intermediate\"]")).isPresent();
        Assert.assertFalse(present4);
        Boolean present5 = element(By.xpath(
                "//input[@name=\"just_see_4_classes\"]/../select/option[text()=\"TMLFB-16-02-05-T\"]")).isPresent();
        Assert.assertFalse(present5);
    }
    public void adminCanSearchEveryThing(){
        withTimeoutOf(60, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath(
                                "//input[@ng-model=\"vm.filter.selected_value\"]")));
        element(By.xpath("//input[@ng-model=\"vm.filter.selected_value\"]")).sendKeys("WPL Advanced");
        element(By.id("submit-filter-btn")).click();
        waitABit(5);

        withTimeoutOf(60, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath(
                                "//span[contains(text(),\"Total\")]")));
        String className = element(By.xpath("//tr[2]/td[5]/span")).getText();
        Assert.assertEquals("WPL Advanced", className);
    }
    public void businessUserOnlySeesOneClass(){
        withTimeoutOf(10, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath(
                                "//span[@ng-if=\"vm.disable || vm.filter.permission_restricted\"]")));
        String className = element(By.xpath("//span[@ng-if=\"vm.disable || vm.filter.permission_restricted\"]")).getText();
        Assert.assertEquals("WPL Advanced",className);
    }
    public void groupOnlySeesOneClass(){
        withTimeoutOf(60, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath(
                                "//span[@ng-if=\"vm.disable || vm.filter.permission_restricted\"]")));
        String className = element(By.xpath("//span[@ng-if=\"vm.disable || vm.filter.permission_restricted\"]")).getText();
        Assert.assertEquals("WPL Advanced",className);
    }
    public void adminSeeAllThingsOnDashboardDetails(){
        //Admin see all reports
        withTimeoutOf(20, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        net.serenitybdd.core.annotations.findby.By.xpath(
                                "//tr[2]/td[5]")));
        String getClassName1 = element(By.xpath("//tr[2]/td[5]")).getText();
        Assert.assertEquals("Class 1",getClassName1);
        String getClassName2 = element(By.xpath("//tr[3]/td[5]")).getText();
        Assert.assertEquals("Lorem ipsum dolor sit amet,",getClassName2);
        String getClassName3 = element(By.xpath("//tr[4]/td[5]")).getText();
        getClassName3 = getClassName3.replaceAll("\\s+","");
        String expected3= "Lorem ipsum";
        expected3 = expected3.replaceAll("\\s+","");
        Assert.assertEquals(expected3,getClassName3);
    }
    public void businessUserOnlySeesSharedDataOnDashboardDetails(){
        //Business User does not see class below:
        String getClassName1 = element(By.xpath("//tr[2]/td[5]")).getText();
        Assert.assertNotEquals("Class 1", getClassName1);
        String getClassName2 = element(By.xpath("//tr[3]/td[5]")).getText();
        Assert.assertNotEquals("Lorem ipsum dolor sit amet,", getClassName2);
        String getClassName3 = element(By.xpath("//tr[4]/td[5]")).getText();
        Assert.assertNotEquals("Lorem ipsum ", getClassName3);
        //Business User see class "WPL Advanced"
        String getClassName = element(By.xpath("//tr[2]/td[5]")).getText();
        Assert.assertEquals("WPL Advanced", getClassName1);
    }
    public void groupOnlySeesSharedDataOnDashboardDetails(){
        //Group does not see class below:
        String getClassName1 = element(By.xpath("//tr[2]/td[5]")).getText();
        Assert.assertNotEquals("Class 1", getClassName1);
        String getClassName2 = element(By.xpath("//tr[3]/td[5]")).getText();
        Assert.assertNotEquals("Lorem ipsum dolor sit amet,", getClassName2);
        String getClassName3 = element(By.xpath("//tr[4]/td[5]")).getText();
        Assert.assertNotEquals("Lorem ipsum", getClassName3);
        //Group sees class "Workplace Literacy" and "WPL Beginners"
        String workplaceLiteracy = element(By.xpath("//tr[2]/td[5]")).getText();
        Assert.assertEquals("Workplace Literacy", workplaceLiteracy);
        String WPLBeginners = element(By.xpath("//tr[3]/td[5]")).getText();
        Assert.assertEquals("WPL Beginners", WPLBeginners);
    }
}
