package com.lqp.automation.steps;

import com.lqp.automation.pages.*;
import net.thucydides.core.annotations.Step;

/**
 * Created by Thanh Chuong on 24/3/17.
 */
public class ReportDetails {

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
}

