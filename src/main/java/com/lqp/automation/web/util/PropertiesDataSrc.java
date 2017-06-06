package com.lqp.automation.web.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author thao.nguyen
 */

public class PropertiesDataSrc {
    String fileName;
    InputStream inputStream;

    public PropertiesDataSrc(String fileName){
        this.fileName = fileName;
    }

    public Properties getPropValues() throws IOException {
        Properties prop = new Properties();
        inputStream = new FileInputStream(fileName);
        try {
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + fileName + "' is not found.");
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }

        return prop;
    }
}