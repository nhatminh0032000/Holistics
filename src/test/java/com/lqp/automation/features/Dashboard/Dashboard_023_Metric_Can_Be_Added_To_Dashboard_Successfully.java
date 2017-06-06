package com.lqp.automation.features.Dashboard;

import com.lqp.automation.steps.Dashboard;
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
 * Created by thuan549 on 5/1/2017.
 */
@RunWith(SerenityRunner.class)
@WithTag(type = "Regression", name = "SmokeTest")
public class Dashboard_023_Metric_Can_Be_Added_To_Dashboard_Successfully {
    @Managed
    WebDriver driver;
    @Steps
    Dashboard dashboard;

    @Before
    public void beforeMethod(){

    }
    @Test
    public void Dashboard_023_Metric_Can_Be_Added_To_Dashboard_Successfully(){
        dashboard.shouldAbleToLogin();
        dashboard.openLeftNav();
        dashboard.CreateNewDashboard();
        dashboard.addMetricToDashboard();
    }
    @After
    public void afterMethod(){

    }
}
