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

public class CreateReport_032_Data_Settings_Aggregations_Show_Total_Row {
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
        createReport.enterTitle("Auto Aggregations_Show_Total_Row  ");
        //================LIVE===================
        createReport.selectDatabase("WPL-Production");
        String queryStr = "Select * from users limit 10";
        createReport.enterQuery(queryStr);
        createReport.checkRunAndPreview();
        createReport.Aggregations_Show_Total_Row("inCreateReport");
        createReport.selectFolder("-- Testing");
        createReport.saveReport();
        createReport.Aggregations_Show_Total_Row("inReportDetails");
    }

    @After
    public void afterMethod(){

    }
}
