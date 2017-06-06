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
 * Created by TThuan Pham on 24/3/17.
 */
@RunWith(SerenityRunner.class)
@WithTag(type = "Regression", name = "SmokeTest")
public class CreateReport_034_QuickTransforms_Verify_That_Quick_Pivot_Works_Correctly {
    @Managed
    WebDriver driver;

    @Steps
    CreateReport createReport;

    @Before
    public void beforeMethod(){

    }

    @Test
    public void CreateReport_034_QuickTransforms_Verify_That_Quick_Pivot_Works_Correctly(){
        createReport.shouldAbleToLogin();
        createReport.openNewReport();
        //createReport.enterTitle("Create_New_Report");
        //createReport.selectFolder();
        //================Stage===================
//        endUser.selectDatabase("demodb");
//        String queryStr = "Select *\\n" +
//                "from quicksell.users\\n" +
//                "where sign_up_date >={{start_date}}\\n" +
//                "and sign_up_date <={{end_date}}";
        //================LIVE===================
        createReport.selectDatabase("WPL-Production");
        String queryStr = "select id,name,start_date,end_date,created_at,created_by\n" +
                "from classes\n" +
                "limit 100";
        createReport.enterQuery(queryStr);
        createReport.checkRunAndPreview();
        createReport.checkQuickPivot();
    }

    @After
    public void afterMethod(){

    }
}
