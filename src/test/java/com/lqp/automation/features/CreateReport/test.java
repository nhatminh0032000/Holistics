package com.lqp.automation.features.CreateReport;

import com.lqp.automation.steps.CreateReport;
import com.lqp.automation.steps.Dashboard;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by Thanh Chuong on 24/3/17.
 */
@RunWith(SerenityRunner.class)
public class test {
    @Managed
    WebDriver driver;

    @Steps
    Dashboard dashboard;

    @Before
    public void beforeMethod(){

    }

    @Test
    public void CreateReport_107_Pie_Chart__Verify_Xaxis_And_Yaxis_Work_Correctly(){
      dashboard.shouldAbleToLogin();
        dashboard.openLeftNav();



    }

    @After
    public void afterMethod(){

    }
}
