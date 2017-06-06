package com.lqp.automation.steps;

import com.lqp.automation.pages.HomePage;
import com.lqp.automation.pages.LoginPage;
import com.lqp.automation.pages.MetricPage;
import net.thucydides.core.annotations.Step;

/**
 * Created by thuan549 on 5/2/2017.
 */
public class Metric {
    private HomePage homePage;
    private LoginPage loginPage;
    private MetricPage metricPage;
    @Step
    public void shouldAbleToLogin(){
        loginPage.login();
    }
    @Step
    public void openLeftNav(){
        homePage.openLeftNav();
    }
    @Step
    public void openMetricsPage(){
        metricPage.openMetricPage();
    }
    @Step
    public void addNewMetric(){
        metricPage.addNewMetrics();
    }
}
