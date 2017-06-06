/*
 * Zyllem
 */
package com.lqp.automation.web.driver;

import com.lqp.automation.web.util.SerenityUtil;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Thanh Chuong
 */
public class RUChromeDriver implements DriverSource{
    @Override
    public WebDriver newDriver() {
        System.setProperty("webdriver.chrome.driver", SerenityUtil.getEnv("webdriver.chrome.driver"));
//
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("no-sandbox");
////Fix for cannot get automation extension
//        chromeOptions.addArguments("disable-extensions");
//        chromeOptions.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;
//        return new FirefoxDriver();
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
