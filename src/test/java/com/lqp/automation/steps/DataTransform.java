package com.lqp.automation.steps;

import com.lqp.automation.pages.*;
import net.thucydides.core.annotations.Step;

/**
 * Created by thuan549 on 5/1/2017.
 */
public class DataTransform {
    DashboardPage dashboard;
    LoginPage loginPage;
    HomePage homePage;
    DataTransformation dataTransformationPage;
    DataTransformationCreationPage dataTransformationCreationPage;

    @Step
    public void shouldAbleToLogin(){
        loginPage.login();
    }
    @Step
    public void openLeftNav(){
        homePage.openLeftNav();
    }
    @Step
    public void openDataTransformationPage(){
        dataTransformationPage.openDataTransformationPage();
    }
    @Step
    public void openNewDataTransformation(){
        dataTransformationCreationPage.openNewDataTransformation();
    }
    @Step
    public void newDataTransformationName(String name){
        dataTransformationCreationPage.newDataTransformationName(name);
    }
    @Step
    public void transformationTypeSelection(String transformationTypeSelection){
        dataTransformationCreationPage.transformationTypeSelection(transformationTypeSelection);
    }
    @Step
    public void dataSourceSelection(String dataSourceSelection){
        dataTransformationCreationPage.dataSourceSelection(dataSourceSelection);
    }
    @Step
    public void enterTableName(String tableName){
        dataTransformationCreationPage.enterTableName(tableName);
    }
    @Step
    public void enterQuery(String enterQuery){
        dataTransformationCreationPage.enterQuery(enterQuery);
    }
    @Step
    public void validateQuery(){
        dataTransformationCreationPage.validateQuery();
    }
    @Step
    public void validateTableStructure(){
        dataTransformationCreationPage.validateTableStructure();
    }
    @Step
    public void previewAndAutoFillColumns(){
        dataTransformationCreationPage.previewAndAutoFillColumns();
    }
    @Step
    public void clickSaveButton(){
        dataTransformationCreationPage.clickSaveButton();
    }
    @Step
    public void checkDataTransformationPageLoaded(){
        dataTransformationPage.checkDataTransformationPageLoaded();
    }
    @Step
    public void verifyNewDataTransformationCreated(String dataTransformName){
        dataTransformationCreationPage.verifyNewDataTransformationCreated(dataTransformName);
    }
}
