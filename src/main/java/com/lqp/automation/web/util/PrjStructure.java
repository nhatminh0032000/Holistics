package com.lqp.automation.web.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrjStructure {

    public void getScreenshot(WebDriver driver, String fileName, String dirScreenshot) throws IOException {
        File dir = new File(dirScreenshot);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(dirScreenshot + File.separator + fileName + ".png"));
    }

    public void moveOldLog(String dirLog) {
        Date aDay = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+7:00"));
        String today = dateFormat.format(aDay).toString();
        File root = new File(dirLog);
        if (!root.exists()) {
            root.mkdir();
            return;
        }
        File[] rootChild = root.listFiles(new FileFilter() {

            public boolean accept(File pathname) {
                if (pathname.isFile()) {
                    return true;
                }
                return false;
            }
        });
        if (rootChild.length == 0) {
            return;
        }
        File dir = new File(dirLog + File.separator + today);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File[] children = dir.listFiles(new FileFilter() {

            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                }
                return false;
            }
        });
        for (File logFile : rootChild) {
            String count = String.valueOf(children.length);
            File dst = new File(dirLog + File.separator + today + File.separator + count);
            try {
                FileUtils.copyFileToDirectory(logFile, dst, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            logFile.delete();
        }
    }

    public InputStream readProperties(String fileName) {
        InputStream in;
        try {
            File file = new File(fileName);
            in = new FileInputStream(file);
            return in;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PrjStructure.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getProperties(String key, String propFile) {

        Properties prop = new Properties();
        InputStream input = readProperties(propFile);
        try {
            prop.load(input);
            return prop.getProperty(key);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
