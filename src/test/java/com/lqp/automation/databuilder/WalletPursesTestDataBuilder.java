package com.lqp.automation.databuilder;

import com.lqp.automation.model.Consumer;
import com.lqp.automation.model.Purse;
import com.lqp.automation.web.util.SerenityUtil;
import com.lqp.automation.web.util.XlsDataSrc;

/**
 * Created by Thanh Chuong on 20/2/17.
 */
public class WalletPursesTestDataBuilder extends TestDataBuilder{

    private static final String DATA_FILE_PATH = SerenityUtil.getEnv("data.wallet.purses");
    private static final String EMAIL = "B";
    private static final String PWD = "C";
    private static final String MERCHANT_ID = "D";
    private static final String STORE_VALUE_TYPE = "E";

    public static Consumer prepareConsumer() throws Exception{
        Consumer user = new Consumer();
        if(obj==null || !DATA_FILE_PATH.equalsIgnoreCase(currentDataFile)){
            prepareTestData(SerenityUtil.getIssue(),DATA_FILE_PATH);
        }
        for(Object[] row: obj){
            String[] array = (String[]) row[1];
            if(array[0].equalsIgnoreCase(SerenityUtil.getIssue())){
                user.setEmail(array[XlsDataSrc.toNumber(EMAIL)].trim())
                        .setPassword(array[XlsDataSrc.toNumber(PWD)].trim());
                Purse purse = new Purse();
                purse.setMerchantId(array[XlsDataSrc.toNumber(MERCHANT_ID)].trim())
                    .setStoreValueType(array[XlsDataSrc.toNumber(STORE_VALUE_TYPE)].trim());
                user.addPurse(purse);
            }
        }
        return user;
    }
}
