package com.lqp.automation.databuilder;

import com.lqp.automation.model.Consumer;
import com.lqp.automation.web.util.SerenityUtil;
import com.lqp.automation.web.util.XlsDataSrc;

/**
 * Created by Thanh Chuong on 20/2/17.
 */
public class AccountInfoTestDataBuilder extends TestDataBuilder{

    private static final String DATA_FILE_PATH = SerenityUtil.getEnv("data.ai");
    private static final String EMAIL = "B";
    private static final String PWD = "C";
    private static final String F_NAME = "D";
    private static final String L_NAME = "E";
    private static final String NEW_PWD = "F";
    private static final String NEW_F_NAME = "G";
    private static final String NEW_L_NAME = "H";


    public static Consumer createUser() throws Exception{
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
                        .setNewPassword(array[XlsDataSrc.toNumber(NEW_PWD)])
                        .setNewFirstName(array[XlsDataSrc.toNumber(NEW_F_NAME)])
                        .setNewLastName(array[XlsDataSrc.toNumber(NEW_L_NAME)]);
            }
        }
        return user;
    }

}
