package com.lqp.automation.steps;

import com.lqp.automation.pages.*;
import net.thucydides.core.annotations.Step;

/**
 * Created by Thuan Pham on 28/05/17.
 */
public class AdhocQuery {

    private LoginPage loginPage;
    private HomePage homePage;
    private CreateReportPage createReportPage;
    private SharedFilterPage sharedFilterPage;
    private ReportsListPage reportsListPage;
    private ReportDetailsPage reportDetailsPage;
    private AdhocQueryPage adhocQueryPage;


    @Step
    public void shouldAbleToLogin(){
        loginPage.login();
    }
    @Step
    public void openLeftnav(){
        homePage.openLeftNav();
    }
    @Step
    public void openAdhocQueryPage(){
        adhocQueryPage.openAdhocQueryPage();
    }
    @Step
    public void openNewAdhocQueryPage(){
        adhocQueryPage.openNewAdhocQueryPage();
    }
    @Step
    public void createNewAdhocQuery(){
        adhocQueryPage.createNewAdhocQuery();
    }

}

