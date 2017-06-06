package com.lqp.automation.features.ReportDetails;

import com.lqp.automation.pages.ReportDetailsPage;
import com.lqp.automation.steps.CreateReport;
import com.lqp.automation.steps.ReportDetails;
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
 * Just test on report details, have not create report with multiple selectin
 */
@RunWith(SerenityRunner.class)
@WithTag(type = "Regression", name = "SmokeTest")
public class ReportDetails_001_Filter_Multiple_Selection_Checked_Work_Correctly {
    @Managed
    WebDriver driver;

    @Steps
    ReportDetails reportDetails;
  //  CreateReport createReport;

    @Before
    public void beforeMethod(){

    }

    @Test
    public void ReportDetails_001_Filter_Multiple_Selection_Checked_Work_Correctly (){
        reportDetails.shouldAbleToLogin();
        reportDetails.openLeftnav();
        reportDetails.openReportsPage();
        reportDetails.openFolder("Automation");
        reportDetails.openReportDetails("Multiple Selections Filters");
        reportDetails.selectMultipleOptions();
        reportDetails.clickSubmitButton();/*After selecting multiple selections*/
        reportDetails.checkOutputAfterFilterWithMultipleSelection();
    }

    @After
    public void afterMethod(){

    }
}
