/*
 * Liquid Pay
 */
package com.lqp.automation.web.util;

import net.thucydides.core.guice.ThucydidesModule;
import net.thucydides.core.steps.StepEventBus;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.List;

/**
 *
 * @author Thanh Chuong
 */
public class SerenityUtil {

    private static EnvironmentVariables evs;

    public static String getEnv(String key) {
        if (evs == null) {
            evs = (new ThucydidesModule()).provideEnvironmentVariables();
        }
        return evs.getProperty(key)==null?"":evs.getProperty(key);
    }

    public static String getIssue(){
//        List<String> issueKeys = StepEventBus.getEventBus().getBaseStepListener().getTestOutcomes().get(0).getIssueKeys();
//        if()
        return StepEventBus.getEventBus().getBaseStepListener().getTestOutcomes().get(0).getIssueKeys().get(0);
    }

    public static String getBaseUrl() {

        return getEnv("webdriver.base.url");
    }
    
    public static String getHttpsBaseUrl(){
        String baseURL = SerenityUtil.getBaseUrl();
        if (!baseURL.contains("https")) {
            return baseURL.replaceAll("http", "https");
        }
        return baseURL;
    }
    
    public static String getAdminURL(){
        String regex = "(http:\\/\\/)(\\w+)(\\.zyllem.*)";
        return SerenityUtil.getBaseUrl().replaceAll(regex, "$1admin$3");
    }
    
//    public static void main(String[] args) {
//        String a = "\\";
//        System.out.println(a);
//        System.out.println(a.replace("\\", "\\\\"));
//    }
}
