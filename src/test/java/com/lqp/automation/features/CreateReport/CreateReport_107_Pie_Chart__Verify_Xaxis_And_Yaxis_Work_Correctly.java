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
public class CreateReport_107_Pie_Chart__Verify_Xaxis_And_Yaxis_Work_Correctly {
    @Managed
    WebDriver driver;

    @Steps
    CreateReport createReport;

    @Before
    public void beforeMethod(){

    }

    @Test
    public void CreateReport_107_Pie_Chart__Verify_Xaxis_And_Yaxis_Work_Correctly(){
        createReport.shouldAbleToLogin();
        createReport.openNewReport();
        //createReport.enterTitle("Create_New_Report");
        //createReport.selectFolder();
        //================LIVE===================
        createReport.selectDatabase("WPL-Production");
        String queryStr = "SELECT gender, COUNT(id) AS count\n" +
                "FROM users\n" +
                "GROUP BY gender;";
        createReport.enterQuery(queryStr);
        createReport.checkRunAndPreview();
        createReport.checkVisualization();
    }

    @After
    public void afterMethod(){

    }
}
