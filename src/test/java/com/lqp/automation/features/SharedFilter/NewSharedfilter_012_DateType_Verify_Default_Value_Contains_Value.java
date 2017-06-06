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
 * Created by thuan549 on 4/4/2017.
 * Test case: NewSharedfilter_011
 * TEST PATH: New Shared Filter > Filter Type = Date:
 * Test case: Default Value field = empty  > After filter is created, verify that value in filter is correct
 * Step 1: Click the Shared Filter link on the Left Nav
 * Make sure that the Shared filter page is loaded.
 * Step 2: At the end of page, click on the New Shared Filter button
 * Make sure that the New Shared Filter dialog is appeared.
 * Step 3: Enter "Auto Start Date" into the "Shared Filter" text field
 * Step 4: Check on the "Date" checkradio
 * Step 5: Enter "2 weeks ago" into the "Default Value:" text field
 * Step 6: Click on the Save button
 * Verify that:
 * VP1: Successfully message "Shared Filter added successfully" appears correctly
 * VP2: Shared filter named "Start Date" is created with type: Date

 */
@RunWith(SerenityRunner.class)
@WithTag(type = "Regression", name = "SmokeTest")
public class NewSharedfilter_012_DateType_Verify_Default_Value_Contains_Value {
    @Managed
    WebDriver driver;
    @Steps
    SharedFilterSteps endUser;
    @Before
    public void beforeMethod(){

    }
    @Test
    public void Newsharedfilter012_VerifyDefaultValueContainsValue(){
        String filterType = "Date";
        String sharedFilterName ="Auto Start Date";
        String message ="Shared Filter added successfully";
        String defaulvalue ="2 weeks ago";
        endUser.shouldAbleToLogin();
        endUser.openLeftNav();
        endUser.openSharedFilterPage();
        endUser.openNewSharedFilter();
        endUser.enterNameForSharedFilter(sharedFilterName);
        endUser.selectFilterType(filterType);
        endUser.enterDefaultValue(defaulvalue);
        endUser.clickSaveButton();
        endUser.verifyMessage(message);
        endUser.verify_Shared_Filter_Is_Created(sharedFilterName);
    }
    @After
    public void afterMethod(){

    }
}
