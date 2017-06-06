package com.lqp.automation.steps;

import com.lqp.automation.pages.*;
import net.thucydides.core.annotations.Step;

/**
 * Created by thuan549 on 5/1/2017.
 */
public class DataImport {
    DashboardPage dashboard;
    LoginPage loginPage;
    HomePage homePage;
    DataImportsPage dataImportsPage;
    DataImportsCreationPage dataImportsCreationPage;

    @Step
    public void shouldAbleToLogin(){
        loginPage.login();
    }
    @Step
    public void openLeftNav(){
        homePage.openLeftNav();
    }
    @Step
    public void openDataImportPage(){
        dataImportsPage.openDataImportPage();
    }
    @Step
    public void openNewDataImport(){
        dataImportsCreationPage.openNewDataImport();
    }
    @Step
    public void importSource(String shareLinkGoogleDrive, String sourceTypeSelection){
        dataImportsCreationPage.importSource(shareLinkGoogleDrive,sourceTypeSelection);
    }
    @Step
    public void selectImportDestination(){
        dataImportsCreationPage.selectImportDestination();
    }
    @Step
    public void syncConfiguration(){
        dataImportsCreationPage.syncConfiguration();
    }
    @Step
    public void clickSaveButton(){
        dataImportsCreationPage.clickSaveButton();
    }
    @Step
    public void dataImportName(String DataImportName){
        dataImportsCreationPage.dataImportName(DataImportName);
    }
    @Step
    public void checkDataImportLoaded(){
        dataImportsPage.checkDataImportPageLoaded();
    }

}
