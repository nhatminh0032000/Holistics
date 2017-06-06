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
public class CreateReport_002_Create_New_Report {
    @Managed
    WebDriver driver;

    @Steps
    CreateReport createReport;

    @Before
    public void beforeMethod(){

    }

    @Test
    public void CreateReport_002_Create_New_Report(){
        createReport.shouldAbleToLogin();
        createReport.openNewReport();
        createReport.enterTitle("Create_New_Report");
        //================LIVE===================
        createReport.selectDatabase("WPL-Production");
        String queryStr = "select * from articles limit 1000";
        createReport.enterQuery(queryStr);
        createReport.selectFolder("-- Testing");
        createReport.openNewAdhocFilter();
        createReport.addDateAdhocFilter("start_date", "8 weeks ago");
        createReport.addAdhocClickSubmitButton();
        createReport.openNewAdhocFilter();
        createReport.addDateAdhocFilter("end_date","yesterday");
        createReport.addAdhocClickSubmitButton();
        createReport.saveReport();
        createReport.checkReportDetailsPageLoaded();
        createReport.filterWithStartAndEndDate("2017-04-20","2017-05-01");
    }

    @After
    public void afterMethod(){

    }
}
