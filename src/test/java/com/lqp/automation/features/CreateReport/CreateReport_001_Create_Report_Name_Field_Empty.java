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
 * Created by Thuan Pham on 4/3/2017.
 * Summary: Veirfy that error message appears when leaving the title is blank
 */
@RunWith(SerenityRunner.class)
@WithTag(type = "Regression", name = "SmokeTest")
public class CreateReport_001_Create_Report_Name_Field_Empty {
    @Managed
    WebDriver driver;

    @Steps
    CreateReport step;

    @Before
    public  void beforeMethod(){

    }
    @Test
    public void CreateReport_001_Create_Report_Name_Field_Empty(){

        step.shouldAbleToLogin();
        step.openNewReport();
        step.saveReport();
        step.viewErrorMessageWhenTitleIsEmpty();
    }
    @After
    public void afterMethod(){

    }
}
