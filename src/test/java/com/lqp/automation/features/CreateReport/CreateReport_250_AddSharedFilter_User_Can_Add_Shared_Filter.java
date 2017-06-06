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
public class CreateReport_250_AddSharedFilter_User_Can_Add_Shared_Filter {
    @Managed
    WebDriver driver;

    @Steps
    CreateReport createReport;

    @Before
    public void beforeMethod(){

    }

    @Test
    public void CreateReport_250_AddSharedFilter_User_Can_Add_Shared_Filter(){
        createReport.shouldAbleToLogin();
        createReport.openNewReport();
        createReport.addSharedFilter();
    }

    @After
    public void afterMethod(){

    }
}
