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
 * Summary: Veirfy that error message appears when leaving the title is blank
 */
@RunWith(SerenityRunner.class)
@WithTag(type = "Regression", name = "SmokeTest")
public class Permission_012_Dashboards_Details_Group_Only_Sees_Shared_Data {
    @Managed
    WebDriver driver;

    @Steps
    FilterPermission filterPermission;

    @Before
    public  void beforeMethod(){

    }
    @Test
    public void Permission_012_Dashboards_Details_Group_Only_Sees_Shared_Data(){
        filterPermission.shouldAbleToLogin();
        filterPermission.openLeftNav();
        filterPermission.switchUser("Genner developer");
        filterPermission.openDashboardPage();
        filterPermission.openDashboardDetails();
        filterPermission.groupOnlySeesSharedDataOnDashboardDetails();
    }
    @After
    public void afterMethod(){

    }
}
