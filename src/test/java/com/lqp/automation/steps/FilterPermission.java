package com.lqp.automation.steps;

import com.lqp.automation.pages.*;
import net.thucydides.core.annotations.Step;
import org.junit.experimental.theories.suppliers.TestedOn;

/**
 * Created by thuan549 on 5/6/2017.
 */
public class FilterPermission {
    ReportsListPage reportsListPage;
    LoginPage loginPage;
    HomePage homePage;
    FilterPermisson filterPermisson;
    ReportDetailsPage reportDetailsPage;
    DashboardPage dashboardPage;
    @Step
    public void shouldAbleToLogin(){
        loginPage.login();
    }
    @Step
    public void openLeftNav(){
        homePage.openLeftNav();
    }
    @Step
    public void openReportsListPage(){
        reportsListPage.openReportsList();
    }
    @Step
    public void reportsList_AdminPermission(){
        filterPermisson.reportsList_AdminPermission();
    }
    @Step
    public void reportsList_BusinessUserPermission(){
        filterPermisson.reportsList_BusinessUserPermission();
    }
    @Step
    public void reportsList_groupPermission(){
        filterPermisson.reportsList_GroupPermission();
    }
    @Step
    public void switchUser(String userType){
        filterPermisson.switchUser(userType);
    }
    @Step
    public void openDetailsReportPage(String reportName){
        reportDetailsPage.openReportDetails(reportName);
    }
    @Step
    public void adminSeeAllOptionsDropdown(){
        filterPermisson.adminSeeAllOptionsDropdown();
    }
    @Step
    public void businessUserSeesRestrictedOptions(){
        filterPermisson.businessUserSeesRestrictedOptions();
    }
    @Step
    public void groupSeesRestrictedOptions(){
        filterPermisson.groupSeesRestrictedOptions();
    }
    @Step
    public void adminCanSearchEveryThing(){
        filterPermisson.adminCanSearchEveryThing();
    }
    @Step
    public void businessUserOnlySeesOneClass(){
        filterPermisson.businessUserOnlySeesOneClass();
    }
    @Step
    public void groupOnlySeesOneClass(){
        filterPermisson.groupOnlySeesOneClass();
    }
    @Step
    public void adminSeeAllThingsOnDashboardDetails(){
        filterPermisson.adminSeeAllThingsOnDashboardDetails();
    }
    @Step
    public void businessUserOnlySeesSharedDataOnDashboardDetails(){
        filterPermisson.businessUserOnlySeesSharedDataOnDashboardDetails();
    }
    @Step
    public void groupOnlySeesSharedDataOnDashboardDetails(){
        filterPermisson.groupOnlySeesSharedDataOnDashboardDetails();
    }
    @Step
    public void openDashboardPage(){
        dashboardPage.openDashboardPage();
    }
    @Step
    public void openDashboardDetails(){
        dashboardPage.openDashboardDetails();
    }
    @Step
    public void dashboardList_AdminPermission(){
        filterPermisson.dashboardList_AdminPermission();
    }
    @Step
    public void dashboardList_BusinessUserPermission(){
        filterPermisson.dashboardList_BusinessUserPermission();
    }
    @Step
    public void dashboardList_GroupPermission(){
        filterPermisson.dashboardList_GroupPermission();
    }
}
