/*
 * Liquid Pay
 */
package com.lqp.automation.junit.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Thanh Chuong
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @ interface UseExcelDataFileFrom {
    String fileName();
    String sheetName() default "";
    int sheetNum() default 0;
    int header() default 1;
    Class<?> dataModel();
}
