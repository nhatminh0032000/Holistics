package com.lqp.automation.features.FilterPermisson;



import com.lqp.automation.steps.FilterPermission;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by thuan549 on 4/3/2017.
 * Summary: User report "User in class" to test
 *
 */
@RunWith(SerenityRunner.class)
@WithTag(type = "Regression", name = "SmokeTest")
public class Permission_004_Reports_Details_Admin_See_All_Filters {
    @Managed
    WebDriver driver;

    @Steps
    FilterPermission filterPermission;

    @Before
    public  void beforeMethod(){

    }
    @Test
    public void Permission_004_Reports_Details_Admin_See_All_Filters(){
        filterPermission.shouldAbleToLogin();
        filterPermission.openLeftNav();
        filterPermission.openReportsListPage();
        filterPermission.openDetailsReportPage("User in class");
        filterPermission.adminSeeAllOptionsDropdown();
    }
    @After
    public void afterMethod(){

    }
}
