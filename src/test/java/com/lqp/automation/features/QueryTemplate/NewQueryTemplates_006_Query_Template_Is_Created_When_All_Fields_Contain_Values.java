package com.lqp.automation.features.QueryTemplate;

import com.lqp.automation.steps.Metric;
import com.lqp.automation.steps.QueryTemplate;
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
public class NewQueryTemplates_006_Query_Template_Is_Created_When_All_Fields_Contain_Values {
    @Managed
    WebDriver driver;
    @Steps
    QueryTemplate step;

    @Before
    public void beforeMethod(){

    }
    @Test
    public void Dashboard_028_Text_Can_Be_Added_To_Dashboard_Successfully(){
        step.shouldBeAbleToLogin();
        step.openLeftNav();
        step.openQueryTemplatePage();
    }
    @After
    public void afterMethod(){

    }
}
