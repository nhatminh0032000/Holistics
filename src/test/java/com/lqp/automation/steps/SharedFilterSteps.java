package com.lqp.automation.steps;

import com.lqp.automation.pages.HomePage;
import com.lqp.automation.pages.LoginPage;
import com.lqp.automation.pages.SharedFilterPage;
import net.thucydides.core.annotations.Step;

/**
 * Created by thuan549 on 4/3/2017.
 */
public class SharedFilterSteps {
    private HomePage homePage;
    private LoginPage loginPage;
    private SharedFilterPage sharedFilterPage;

    @Step
    public void shouldAbleToLogin(){
        loginPage.login();
    }
    @Step
    public void openHomePage(){
        homePage.openHomePage();
    }

    @Step
    public void openLeftNav(){
        homePage.openLeftNav();
    }

    @Step
    public void openSharedFilterPage(){
        homePage.goToSharedFilterPage();
    }

    @Step
    public void viewSharedFilterPageIsLoaded(String expectedResult){
        homePage.checkPageIsLoadedWithTitle(expectedResult);
    }

    @Step
    public void openNewSharedFilter(){
        sharedFilterPage.openNewSharedFilterPopup();
    }

    @Step
    public void enterNameForSharedFilter(String name){
        sharedFilterPage.enterNameForSharedFilter(name);
    }

    @Step
    public void selectFilterType(String filterType){
        sharedFilterPage.selectFilterType(filterType);
    }
    @Step
    public void enterDefaultValue(String defaultVaue){
        sharedFilterPage.enterDefaultValue(defaultVaue);
    }
    @Step
    public void enterHelptext(String helpText){
        sharedFilterPage.enterHelptext(helpText);
    }
    @Step
    public void clickSaveButton(){
        sharedFilterPage.clickSaveButton();
    }

    @Step
    public void verifyMessage(String message){
        sharedFilterPage.verifyMessage(message);
    }

    @Step
    public void verify_Shared_Filter_Is_Created(String shareFilterName){
        sharedFilterPage.verify_Shared_Filter_Is_Created(shareFilterName);
    }
    @Step
    public void select_Allow_Empty_Value(){
        sharedFilterPage.select_Allow_Empty_Value();
    }
    @Step
    public void setMinimumDate_Human_Friendly_Value(){
        sharedFilterPage.setMinimumDate_Human_Friendly_Value();
    }
    @Step
    public void setMinimumDateDataSource(){
        sharedFilterPage.setMinimumDateFromDataSource();
    }
    @Step
    public void setMaximumDate_Human_Friendly_Value(){
        sharedFilterPage.setMaximumDate_Human_Friendly_Value();
    }
    @Step
    public void setMaximumDateDataSource(){
        sharedFilterPage.setMaximumDateFromDataSource();
    }
    @Step
    public void setPermission(){
        sharedFilterPage.setPermission();
    }
    @Step
    public void submitSharedFilter(){
        sharedFilterPage.submitSharedFilter();
    }
}
