package com.lqp.automation.model;

/**
 * Created by Thanh Chuong on 10/3/17.
 */
public class Merchant {
    private String userName;
    private String password;
    private String deviceId;
    private String deviceUID;
    private String deviceType;

    public Merchant(){
        this.deviceId = "eO7y3EYFRn4%3AAPA91bF0E8ykH_OY2Ezpt5F1bJ3UpRxpJlMnd2V19C9k348n5zmvbUNa4pcKdqx6kyWURUTCPpun2RioKRVNtGjYR338GjL68eQaTDm9uSe0XgrIoDqTNs23dBISkP45ONKDPU_CfU2e";
        this.deviceUID = "54e5c3b4c7a03372";
        this.deviceType = "A";
    }

    public String getUserName() {
        return userName;
    }

    public Merchant setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Merchant setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public Merchant setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public Merchant setDeviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public String getDeviceUID() {
        return deviceUID;
    }

    public Merchant setDeviceUID(String deviceUID) {
        this.deviceUID = deviceUID;
        return this;
    }

    @Override
    public String toString(){
        return userName;
    }
}
