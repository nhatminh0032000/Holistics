package com.lqp.automation.steps;

import com.lqp.automation.pages.HomePage;
import com.lqp.automation.pages.LoginPage;
import com.lqp.automation.pages.QueryTemplatePage;
import net.thucydides.core.annotations.Step;

/**
 * Created by thuan549 on 5/18/2017.
 */
public class QueryTemplate {
    HomePage homePage;
    LoginPage loginPage;
    QueryTemplatePage queryTemplatePage;

    @Step
    public void shouldBeAbleToLogin(){
        loginPage.login();
    }
    @Step
    public void openLeftNav(){
        homePage.openLeftNav();
    }
    @Step
    public void openQueryTemplatePage(){
        queryTemplatePage.openQueryTemplate();
    }
}
