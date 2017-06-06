/*
 * Liquid Pay
 */
package com.lqp.automation.web.util;

import com.lqp.automation.web.util.excel.ToHtmlConverter;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import static com.lqp.automation.web.util.excel.ToHtmlConverter.create;

/**
 *
 * @author Thanh Chuong
 */
public class ExcelUtil {

    public static void convertExcelToHtml(String excelFile, String htmlOuput) throws Exception {
        File file = new File(htmlOuput);
        FileWriter fileWriter = new FileWriter(file);
        ToHtmlConverter toHtml = create(excelFile, new PrintWriter(fileWriter));
        toHtml.setCompleteHTML(true);
        toHtml.printPage();
    }
}
