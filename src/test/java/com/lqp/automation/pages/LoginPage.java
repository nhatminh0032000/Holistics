package com.lqp.automation.pages;

import com.lqp.automation.web.pageobject.MyPageObject;
import com.lqp.automation.web.util.SerenityUtil;
import net.serenitybdd.core.annotations.findby.By;

/**
 * Created by Thanh Chuong on 24/3/17.
 */
public class LoginPage extends MyPageObject{

    private static String EMAIL_INPUT_ID = "user_email";
    private static String PWD_INPUT_ID = "user_password";
    private static String SIGNIN_BT_NAME = "commit";
//    private static String userName = "minhthuan0032000@gmail.com";
//    private static String pwd="thuanthuan";
    private static String userName = "thanhloc@epsilon-mobile.com";
    private static String pwd="epsilonmobile";
    public void startBrowser(){
        getDriver().get(SerenityUtil.getBaseUrl());
        getDriver().manage().window().maximize();
    }

    public void login(){
        startBrowser();
        element(By.id(EMAIL_INPUT_ID)).sendKeys(userName);
        element(By.id(PWD_INPUT_ID)).sendKeys(pwd);
        element(By.name(SIGNIN_BT_NAME)).click();
    }

}
