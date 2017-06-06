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
@Target(ElementType.FIELD)
public @ interface XlsColumn {
    String name();
}
