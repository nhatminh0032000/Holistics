package com.lqp.automation.pages;

/**
 * Created by thuan549 on 4/26/2017.
 */
public class DataPrepare {
    public String sqlString01 ="Select * from quicksell.users" +
            "                \"where sign_up_date >={{start_date}}\\\\n\" +\n" +
            "                \"and sign_up_date <={{end_date}}";
    public    String queryStr1 = "Select *\\n" +
            "from quicksell.users\\n" +
            "where sign_up_date >={{start_date}}\\n" +
            "and sign_up_date <={{end_date}}";
}
