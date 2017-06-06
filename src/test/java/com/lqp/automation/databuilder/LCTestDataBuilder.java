package com.lqp.automation.databuilder;

import com.lqp.automation.model.Consumer;
import com.lqp.automation.web.util.SerenityUtil;
import com.lqp.automation.web.util.XlsDataSrc;

/**
 * Created by Thanh Chuong on 15/2/17.
 */
public class LCTestDataBuilder extends TestDataBuilder{

    private static final String DATA_FILE_PATH = SerenityUtil.getEnv("data.lc");
    private static final String SENDER_EMAIL = "B";
    private static final String SENDER_PWD = "C";
    private static final String SENDER_NUM = "D";
    private static final String RECIPIENT_EMAIL = "E";
    private static final String RECIPIENT_PWD = "F";
    private static final String RECIPIENT_NUM = "G";
    private static final String SENDER_IDNO = "H";
    private static final String RECIPIENT_IDNO = "I";

//    private static Object[][] obj = null;

    public static Consumer prepareSenderUser() throws Exception{
        Consumer user = new Consumer();
        if(obj==null || !DATA_FILE_PATH.equalsIgnoreCase(currentDataFile)){
            prepareTestData(SerenityUtil.getIssue(), DATA_FILE_PATH);
        }
        for(Object[] row: obj){
            String[] array = (String[]) row[1];
            if(array[0].equalsIgnoreCase(SerenityUtil.getIssue())){
                user.setEmail(array[XlsDataSrc.toNumber(SENDER_EMAIL)].trim())
                        .setPassword(array[XlsDataSrc.toNumber(SENDER_PWD)].trim())
                        .setNumber(array[XlsDataSrc.toNumber(SENDER_NUM)].trim())
                        .setIdNo(array[XlsDataSrc.toNumber(SENDER_IDNO)].trim());
            }
        }
        return user;
    }

    public static Consumer prepareRecipientUSer() throws Exception{
        Consumer user = new Consumer();
        if(obj==null){
            prepareTestData(SerenityUtil.getIssue(), DATA_FILE_PATH);
        }
        for(Object[] row: obj){
            String[] array = (String[]) row[1];
            if(array[0].equalsIgnoreCase(SerenityUtil.getIssue())){
                user.setEmail(array[XlsDataSrc.toNumber(RECIPIENT_EMAIL)].trim())
                        .setPassword(array[XlsDataSrc.toNumber(RECIPIENT_PWD)].trim())
                        .setNumber(array[XlsDataSrc.toNumber(RECIPIENT_NUM)].trim())
                        .setIdNo(array[XlsDataSrc.toNumber(RECIPIENT_IDNO)].trim());
            }
        }
        return user;
    }

}
