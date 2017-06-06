/*
 * Zyllem
 */
package com.lqp.automation.web.applitools;

import com.applitools.eyes.FileLogger;
import com.applitools.eyes.StdoutLogHandler;
import com.applitools.eyes.selenium.Eyes;
import com.lqp.automation.web.util.SerenityUtil;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Thanh Chuong
 */
public class EyesFactory {
    
    private static Eyes eyes;
    
    public static Eyes getCurrentEyes(){
        return eyes;
    }
    
    public static void initEyes(WebDriver driver){
        eyes = new Eyes();
        eyes.setLogHandler(new StdoutLogHandler(true));  
        eyes.setLogHandler(new FileLogger("applitools.log", true, true));
        eyes.setApiKey(SerenityUtil.getEnv("ru.applitools.key"));
//        eyes.open(driver, "Zyllem", "WebApp", new RectangleSize(1024, 768));
        eyes.open(driver, "Zyllem", "WebApp");
    }
    
    
}
