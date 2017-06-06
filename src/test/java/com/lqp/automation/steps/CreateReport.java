package com.lqp.automation.steps;

import com.lqp.automation.pages.*;
import net.thucydides.core.annotations.Step;

/**
 * Created by Thuan Pham on 24/3/17.
 */
public class CreateReport {

    private LoginPage loginPage;
    private HomePage homePage;
    private CreateReportPage createReportPage;
    private SharedFilterPage sharedFilterPage;
    private ReportsListPage reportsListPage;
    private ReportDetailsPage reportDetailsPage;


    @Step
    public void shouldAbleToLogin(){
        loginPage.login();
    }
    @Step
    public void openLeftnav(){
        homePage.openLeftNav();
    }
    @Step
    public void openNewReport(){
        homePage.goToCreateReportPage();
    }
    @Step
    public void enterTitle(String title){
        createReportPage.setReportTitle(title);
    }
    @Step
    public void enterQuery(String query){
        createReportPage.inputQuery(query);
    }
    @Step
    public void addDateAdhocFilter(String fieldName, String defaultValue){
        createReportPage.addDateAdhocFilter(fieldName, defaultValue);
    }
    @Step
    public void selectDatabase(String database){
        createReportPage.selectDatabase(database);
    }
    @Step
    public void saveReport(){
        createReportPage.saveReport();
    }
    @Step
    public void filterWithStartAndEndDate(String startDate, String endDate){
        createReportPage.filterWithStartAndEndDate(startDate, endDate);
    }
    @Step
    public void viewErrorMessageWhenTitleIsEmpty(){
        createReportPage.getErrorMessage_emptyTitle();
    }
    @Step
    public void selectFolder(String folderName){
        createReportPage.selectFolder(folderName);
    }
    @Step
    public void checkRunAndPreview(){
        createReportPage.checkRunAndPreview();
    }
    @Step
    public void checkQuickPivot(){
        createReportPage.check_Quick_Pivot();
    }
    @Step
    public void checkVisualization(){
        createReportPage.VisualizationCharts();
    }
    @Step
    public void selectXaxis(){
        createReportPage.selectXaxis();
    }
    @Step
    public void setMaximumDate_Human_Friendly_Value(){
        createReportPage.setMaximumDate_Human_Friendly_Value();
    }
    @Step
    public void clickSubmitAdHocFilter(){
        createReportPage.clickSubmitAdhocFilter();
    }
    @Step
    public void checkDateInFilter(){
        sharedFilterPage.checkDateInFilter();
    }
    @Step
    public void addSharedFilter(){
        createReportPage.addSharedFilter();
    }
    @Step
    public void addAdhocClickSubmitButton(){
        sharedFilterPage.clickSaveButton();
    }
    @Step
    public void insertQueryTemplate(){
        createReportPage.insertQueryTemplate();
    }
    @Step
    public void checkResultAfterInsertQueryTemplate(){
        createReportPage.checkResultAfterInsertQueryTemplate();
    }
    @Step
    public void checkAfterClickOnRunAndPreview(){
        createReportPage.checkAfterClickOnRunAndPreview();
    }
    @Step
    public void Aggregations_Show_Total_Row(String checkWhere){
        createReportPage.aggregations_Show_Total_Row(checkWhere);
    }
    @Step
    public void doNotLoadDataAutomatically(String checkWhere){
        createReportPage.doNotLoadDataAutomatically(checkWhere);
    }
    @Step
    public void openReportsPage(){
        reportsListPage.openReportsPage();
    }
    @Step
    public void openFolder(String folderName){
        reportsListPage.openFolder(folderName);
    }
    @Step
    public void openReportDetails(String reportName){
        reportDetailsPage.openReportDetails(reportName);
    }
    @Step
    public void selectMultipleOptions(){
        reportDetailsPage.selectMultipleOptions();
    }
    @Step
    public void clickSubmitButton(){
        reportDetailsPage.clickSubmitButton();
    }
    @Step
    public void checkOutputAfterFilterWithMultipleSelection(){
        reportDetailsPage.checkOutputAfterFilterWithMultipleSelection();
    }
    @Step
    public void openNewAdhocFilter(){
        createReportPage.openNewAdhocFilter();
    }
    @Step
    public void checkReportDetailsPageLoaded(){
        reportDetailsPage.checkReportDetailsPageLoaded();
    }
}

