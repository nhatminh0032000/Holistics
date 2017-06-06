package com.lqp.automation.model;

/**
 * Created by Thanh Chuong on 27/2/17.
 */
public enum AccountStatus {
    A("Active"),
    P("Pending");

    private final String text;
    /**
     * @param text
     */
    private AccountStatus(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
