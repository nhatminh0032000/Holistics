package com.lqp.automation.constants;

/**
 * Created by Thanh Chuong on 13/2/17.
 */
public interface ConsumerWSEndPoint {
    String LOGIN = "/liquidws/customer.ashx?DEVICETYPE=I&VER=1.0&ACTION=LOGIN";
    String TRANSFER_CASH = "/liquidws/sharing.ashx?DEVICETYPE=I&VER=1.0&ACTION=TRANSFERSVC";
    String GET_WALLET = "/liquidws/wallet.ashx?DEVICETYPE=I&VER=1.0&ACTION=GETMYWALLET";
    String LOGOUT = "/liquidws/member.ashx?ACTION=LOGOUT&DEVICETYPE=A&VER=1";
    String CHANGE_PWD = "/liquidws/member.ashx?ACTION=CHANGEPWD&DEVICETYPE=A&VER=1";
    String SEND_OTP = "/liquidws/customer.ashx?ACTION=SENDOTP&DEVICETYPE=A&VER=1";
    String REGISTRATION = "/liquidws/new_customer.ashx?ACTION=REGISTRATION&DEVICETYPE=A&VER=1";
    String UPDATE_EMAIL = "/liquidws/customer.ashx?ACTION=UPDATEEMAIL&DEVICETYPE=A&VER=1";
    String UPDATE_NOTIFICATION_LIST = "/liquidws/notification.ashx?ACTION=UPDATENOTIFICATION&DEVICETYPE=A&VER=1";
    String GET_NOTIFICATION_LIST = "/liquidws/notification.ashx?ACTION=GETNOTIFICATIONLIST&DEVICETYPE=A&VER=1";
    String GET_DETAILS = "/liquidws/new_member.ashx?DEVICETYPE=I&VER=1.0&ACTION=GETDETAILS";
    String UPDATE_DETAILS = "/liquidws/member.ashx?DEVICETYPE=I&VER=1.0&ACTION=PUT";
    String ACTIVATE_ACC = "/liquidws/new_member.ashx?ACTION=ACTIVATEACC&DEVICETYPE=A&VER=1";
    String VALIDATE_INFO = "/liquidws/new_customer.ashx?ACTION=VALIDATEINFO&DEVICETYPE=A&VER=1";
    String GET_CARD_INFO = "/liquidws/bininfo.ashx?DEVICETYPE=I&VER=1.0&ACTION=GET&CARDBIN=%s";
    String ADD_CARD = "/liquidws/card.ashx?DEVICETYPE=I&VER=1.0&ACTION=POST";
    String DELETE_CARD = "/liquidws/card.ashx?DEVICETYPE=I&VER=1.0&ACTION=DELETE";
    String DELETE_PURSE = "/liquidws/wallet.ashx?ACTION=DELETEWALLET&DEVICETYPE=A&VER=1";
    String UPDATE_PROFILE = "/liquidws/new_member.ashx?ACTION=UPDATEMERCTRLPROFILE&DEVICETYPE=A&VER=1";
    String ADD_PURSE = "/liquidws/cardsv.ashx?ACTION=POST&DEVICETYPE=A&VER=1";
}
