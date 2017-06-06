package com.lqp.automation.features.CreateReport;

import com.lqp.automation.steps.CreateReport;
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
 * Created by Thuan Pham on 24/3/17.
 */
@RunWith(SerenityRunner.class)
@WithTag(type = "Regression", name = "SmokeTest")

public class CreateReport_019_Query_Template_Verify_That_User_Can_Use_Query_Template_For_Report {
    @Managed
    WebDriver driver;

    @Steps
    CreateReport createReport;

    @Before
    public void beforeMethod(){

    }

    @Test
    public void CreateReport_019_Query_Template_Verify_That_User_Can_Use_Query_Template_For_Report(){
        createReport.shouldAbleToLogin();
        createReport.openNewReport();
        createReport.enterTitle("Auto Insert query template  ");
        //================LIVE===================
        createReport.selectDatabase("WPL-Production");
        String queryStr = "SELECT\n" +
                "  U.id as \"ID\",\n" +
                "  U.username as \"Username\",\n" +
                "  {{ @gender('U.gender') }} as \"Gender\"\n" +
                "FROM users U";
        createReport.enterQuery(queryStr);
        createReport.selectFolder("-- Testing");
        createReport.saveReport();
        createReport.checkResultAfterInsertQueryTemplate();
    }

    @After
    public void afterMethod(){

    }
}
