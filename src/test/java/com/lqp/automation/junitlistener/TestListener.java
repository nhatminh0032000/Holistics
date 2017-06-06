package com.lqp.automation.junitlistener;

import com.lqp.automation.database.SQLHelperFacade;
import com.lqp.automation.database.SQLType;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

/**
 * Created by Thanh Chuong on 23/2/17.
 */
public class TestListener extends RunListener{
    @Override
    public void testRunStarted(Description description) throws Exception {
    }
    @Override
    public void testRunFinished(Result result) throws Exception {
//        System.out.println("Close SQL Connection if exist");
//        SQLHelperFacade.closeConnection(SQLType.ORACLE);
    }
}
