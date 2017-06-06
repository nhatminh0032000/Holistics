package com.lqp.automation.features.SharedFilter;

import com.lqp.automation.steps.SharedFilterSteps;
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
 * Created by thuan549 on 4/3/2017.
 *  * NewSharedfilter_002	New Shared Filter >  New Adhoc filter popup is appeared
 *      when clicking on the New Adhoc filter  button

 */
@RunWith(SerenityRunner.class)
@WithTag(type = "Regression", name = "SmokeTest")
public class Newsharedfilter_001_VerifySharedFilterPageIsLoaded {
    @Managed
    WebDriver driver;

    @Steps
    SharedFilterSteps endUser;
    @Before
    public void beforeMethod(){

    }
    @Test
    public void Newsharedfilter001_VerifySharedFilterPageIsLoaded(){
        String title ="Shared Filters - Epsilon Mobile";
        endUser.shouldAbleToLogin();
        endUser.openLeftNav();
        endUser.openSharedFilterPage();
        endUser.viewSharedFilterPageIsLoaded(title);
    }
    @After
    public void afterMethod(){

    }
}
