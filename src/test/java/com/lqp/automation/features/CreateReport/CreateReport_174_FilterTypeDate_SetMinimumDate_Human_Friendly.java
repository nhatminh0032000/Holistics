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
public class CreateReport_174_FilterTypeDate_SetMinimumDate_Human_Friendly {
    @Managed
    WebDriver driver;

    @Steps
    CreateReport createReport;

    @Before
    public void beforeMethod(){

    }

    @Test
    public void CreateReport_174_FilterTypeDate_SetMinimumDate_Human_Friendly(){
        createReport.shouldAbleToLogin();
        createReport.openNewReport();
        createReport.enterTitle("Create_New_Report");
//        createReport.selectFolder();
//        createReport.selectDatabase("WPL-Production");
//        String queryStr = "select * from articles limit 1000";
//        createReport.enterQuery(queryStr);
        createReport.openNewAdhocFilter();
        createReport.addDateAdhocFilter("start_date", "yesterday");
        createReport.setMaximumDate_Human_Friendly_Value();
        createReport.clickSubmitAdHocFilter();
        createReport.checkDateInFilter();
    }

    @After
    public void afterMethod(){

    }
}
