package com.lqp.automation.features.AdhocQuery;


import com.lqp.automation.steps.AdhocQuery;
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
public class AdhocQueries_004_Verify_That_Adhoc_Queries_Is_Created_Successfully {
    @Managed
    WebDriver driver;

    @Steps
    AdhocQuery step;

    @Before
    public  void beforeMethod(){

    }
    @Test
    public void AdhocQueries_004_Verify_That_Adhoc_Queries_Is_Created_Successfully(){
        step.shouldAbleToLogin();
        step.openLeftnav();
        step.openAdhocQueryPage();
        step.openNewAdhocQueryPage();
        step.createNewAdhocQuery();
    }
    @After
    public void afterMethod(){

    }
}
