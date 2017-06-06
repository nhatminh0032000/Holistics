package com.lqp.automation.model;

/**
 * Created by Thanh Chuong on 10/3/17.
 */
public class PromoCode {
    private String code;
    private double factor;
    private int previousMonthCount;
    private int currentMonthCount;

    public String getCode() {
        return code;
    }

    public PromoCode setCode(String code) {
        this.code = code;
        return this;
    }

    public double getFactor() {
        return factor;
    }

    public PromoCode setFactor(double factor) {
        this.factor = factor;
        return this;
    }

    public int getPreviousMonthCount() {
        return previousMonthCount;
    }

    public PromoCode setPreviousMonthCount(int previousMonthCount) {
        this.previousMonthCount = previousMonthCount;
        return this;
    }

    public int getCurrentMonthCount() {
        return currentMonthCount;
    }

    public PromoCode setCurrentMonthCount(int currentMonthCount) {
        this.currentMonthCount = currentMonthCount;
        return this;
    }
}
