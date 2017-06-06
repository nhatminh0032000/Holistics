package com.lqp.automation.databuilder;

import com.lqp.automation.model.Consumer;
import com.lqp.automation.model.Merchant;
import com.lqp.automation.web.util.SerenityUtil;
import com.lqp.automation.web.util.XlsDataSrc;

/**
 * Created by Thanh Chuong on 20/2/17.
 */
public class RegistrationTestDataBuilder extends TestDataBuilder{

    private static final String DATA_FILE_PATH = SerenityUtil.getEnv("data.reg");
    private static final String EMAIL = "B";
    private static final String PWD = "C";
    private static final String F_NAME = "D";
    private static final String L_NAME = "E";
    private static final String DIALING_CODE = "F";
    private static final String DIALING_COUNTRY_CODE = "G";
    private static final String MOBILE = "H";
    private static final String GMAIL_PWD = "I";
    private static final String MERCHANT_USER = "J";
    private static final String MERCHANT_PWD = "K";

    public static Consumer prepareConsumer() throws Exception{
        Consumer user = new Consumer();
        if(obj==null || !DATA_FILE_PATH.equalsIgnoreCase(currentDataFile)){
            prepareTestData(SerenityUtil.getIssue(),DATA_FILE_PATH);
        }
        for(Object[] row: obj){
            String[] array = (String[]) row[1];
            if(array[0].equalsIgnoreCase(SerenityUtil.getIssue())){
                user.setEmail(array[XlsDataSrc.toNumber(EMAIL)].trim())
                        .setPassword(array[XlsDataSrc.toNumber(PWD)].trim())
                        .setFirstName(array[XlsDataSrc.toNumber(F_NAME)].trim())
                        .setLastName(array[XlsDataSrc.toNumber(L_NAME)])
                        .setDialingCode(array[XlsDataSrc.toNumber(DIALING_CODE)])
                        .setDialingCountryCode(array[XlsDataSrc.toNumber(DIALING_COUNTRY_CODE)])
                        .setNumber(array[XlsDataSrc.toNumber(MOBILE)])
                        .setGmailPassword(array[XlsDataSrc.toNumber(GMAIL_PWD)]);
            }
        }
        return user;
    }

    public static Merchant prepareMerchant() throws Exception{
        Merchant user = new Merchant();
        if(obj==null || !DATA_FILE_PATH.equalsIgnoreCase(currentDataFile)){
            prepareTestData(SerenityUtil.getIssue(),DATA_FILE_PATH);
        }
        for(Object[] row: obj){
            String[] array = (String[]) row[1];
            if(array[0].equalsIgnoreCase(SerenityUtil.getIssue())){
                user.setUserName(array[XlsDataSrc.toNumber(MERCHANT_USER)].trim())
                        .setPassword(array[XlsDataSrc.toNumber(MERCHANT_PWD)].trim());
            }
        }
        return user;
    }

}
