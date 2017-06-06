package com.lqp.automation.steps;

import com.lqp.automation.pages.DashboardPage;
import com.lqp.automation.pages.HomePage;
import com.lqp.automation.pages.LoginPage;
import net.thucydides.core.annotations.Step;

/**
 * Created by thuan549 on 5/1/2017.
 */
public class Dashboard {
    DashboardPage dashboard;
    LoginPage loginPage;
    HomePage homePage;
    @Step
    public void CreateNewDashboard(){
        dashboard.createDashboard();
    }
    @Step
    public void shouldAbleToLogin(){
        loginPage.login();
    }
    @Step
    public void openLeftNav(){
        homePage.openLeftNav();
    }
    @Step
    public void addReportToDashboard(){
        dashboard.addReportToDashboard();
    }
    @Step
    public void addMetricToDashboard(){
        dashboard.addMetricToDashboard();
    }
    @Step
    public void addTextToDashboard(){
        dashboard.addTextToDashboard();
    }
    @Step
    public void openDashboardPage(){
        dashboard.openDashboardPage();
    }
    @Step
    public void getDataInAColumn(){
        dashboard.getDataInAColumn();
    }
    @Step
    public void deleteAllRowsSameName(String dashboardName){
        dashboard.deleteAllRowsSameName(dashboardName);
    }
}
