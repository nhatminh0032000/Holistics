package com.lqp.automation.model;

/**
 * Created by Thanh Chuong on 20/3/17.
 */
public class Purse {
    private String storeValueType;
    private String merchantId;

    public String getStoreValueType() {
        return storeValueType;
    }

    public Purse setStoreValueType(String storeValueType) {
        this.storeValueType = storeValueType;
        return this;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public Purse setMerchantId(String merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    @Override
    public String toString(){
        return merchantId;
    }
}
