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

public class CreateReport_019_1_Query_Template_Verify_User_Can_Insert_Query_Template {
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
        createReport.insertQueryTemplate();
        createReport.checkRunAndPreview();
        createReport.checkAfterClickOnRunAndPreview();
    }

    @After
    public void afterMethod(){

    }
}
