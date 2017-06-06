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
 * Step 5: Click "Set minimum date [?]  " checkbox
 * Step 6: Select "Human friendly value" in dropdown
 * Step 7: Enter "3 days ago" into text field
 * Step 8: Click on the Save button
 * Verify that:
 * VP1: Successfully message "Shared Filter added successfully" appears correctly
 * VP2: Shared filter named "Start Date" is created with type: Date

 */
@WithTag(type = "Regression", name = "SmokeTest")
@RunWith(SerenityRunner.class)
public class NewSharedfilter_016_DateType_Set_Minimum_Date_And_Human_Friendly_Value {
    @Managed
    WebDriver driver;
    @Steps
    SharedFilterSteps step_TC;
    @Before
    public void beforeMethod(){

    }
    @Test
    public void NewSharedfilter_016_DateType_Set_Minimum_Date_And_Human_Friendly_Value(){
        String filterType = "Date";
        String sharedFilterName ="Auto Start Date";
        String message ="Shared Filter added successfully";
        step_TC.shouldAbleToLogin();
        step_TC.openLeftNav();
        step_TC.openSharedFilterPage();
        step_TC.openNewSharedFilter();
        step_TC.enterNameForSharedFilter(sharedFilterName);
        step_TC.selectFilterType(filterType);
        step_TC.setMinimumDate_Human_Friendly_Value();
        step_TC.clickSaveButton();
        step_TC.verifyMessage(message);
        step_TC.verify_Shared_Filter_Is_Created(sharedFilterName);
    }
    @After
    public void afterMethod(){

    }
}
