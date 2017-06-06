package com.lqp.automation.databuilder;

import com.lqp.automation.model.Card;
import com.lqp.automation.model.Consumer;
import com.lqp.automation.web.util.SerenityUtil;
import com.lqp.automation.web.util.XlsDataSrc;

/**
 * Created by Thanh Chuong on 20/2/17.
 */
public class WalletCardTestDataBuilder extends TestDataBuilder{

    private static final String DATA_FILE_PATH = SerenityUtil.getEnv("data.wallet.card");
    private static final String EMAIL = "B";
    private static final String PWD = "C";
    private static final String CARD_NO = "D";
    private static final String CARD_CVV = "E";
    private static final String CARD_NAME = "F";
    private static final String CARD_EXPIRY = "G";
    private static final String CARD_DEFAULT = "H";
    private static final String GMAIL_PWD = "I";

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
                        .setGmailPassword(array[XlsDataSrc.toNumber(GMAIL_PWD)]);
                Card card = new Card();
                card.setCardNo(array[XlsDataSrc.toNumber(CARD_NO)].trim())
                        .setCvv(array[XlsDataSrc.toNumber(CARD_CVV)].trim())
                        .setName(array[XlsDataSrc.toNumber(CARD_NAME)].trim())
                        .setExpiry(array[XlsDataSrc.toNumber(CARD_EXPIRY)].trim())
                        .setDefaultCard(array[XlsDataSrc.toNumber(CARD_DEFAULT)].trim());
                user.addCard(card);
            }
        }
        return user;
    }
}
