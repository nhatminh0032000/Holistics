/*
 * Liquid Pay
 */


package com.lqp.automation.web.driver;

import com.lqp.automation.web.applitools.EyesFactory;
import com.lqp.automation.web.util.SerenityUtil;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Thanh Chuong
 */
public class RUFireFoxDriver implements DriverSource{

    @Override
    public WebDriver newDriver() {
        System.setProperty("webdriver.gecko.driver", SerenityUtil.getEnv("webdriver.gecko.driver"));
        WebDriver driver = new FirefoxDriver();
        EyesFactory.initEyes(driver);
        return driver;
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }

}
