package com.lqp.automation.features.Metric;

import com.lqp.automation.steps.Metric;
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
public class Metric_007_Verify_That_User_Can_Create_Metric_Successfully {
    @Managed
    WebDriver driver;
    @Steps
    Metric metric;

    @Before
    public void beforeMethod(){

    }
    @Test
    public void Metric_007_Verify_That_User_Can_Create_Metric_Successfully(){
        metric.shouldAbleToLogin();
        metric.openLeftNav();
        metric.openMetricsPage();
        metric.addNewMetric();
    }
    @After
    public void afterMethod(){

    }
}
