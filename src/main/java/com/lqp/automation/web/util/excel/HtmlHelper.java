/*
 * Liquid Pay
 */


package com.lqp.automation.web.util.excel;

import org.apache.poi.ss.usermodel.CellStyle;

import java.util.Formatter;

/**
 *
 * @author Thanh Chuong
 */
public interface HtmlHelper {
    void colorStyles(CellStyle style, Formatter out);
}
