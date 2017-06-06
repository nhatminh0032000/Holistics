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
 * Just test on report details, have not create report with multiple selectin
 */
@RunWith(SerenityRunner.class)
@WithTag(type = "Regression", name = "SmokeTest")
public class CreateReport_203_Add_New_Adhoc_Filter_Allow_Multiple_Selection {
    @Managed
    WebDriver driver;

    @Steps
    CreateReport createReport;

    @Before
    public void beforeMethod(){

    }

    @Test
    public void CreateReport_203_Add_New_Adhoc_Filter_Allow_Multiple_Selection(){
        createReport.shouldAbleToLogin();
        createReport.openLeftnav();
        createReport.openReportsPage();
        createReport.openFolder("Automation");
        createReport.openReportDetails("Multiple Selections Filters");
        createReport.selectMultipleOptions();
        createReport.clickSubmitButton(); /*After selecting multiple selections*/
        createReport.checkOutputAfterFilterWithMultipleSelection();
    }

    @After
    public void afterMethod(){

    }
}
