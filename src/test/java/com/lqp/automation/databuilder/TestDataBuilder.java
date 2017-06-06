package com.lqp.automation.databuilder;

import com.lqp.automation.web.util.XlsDataSrc;

import java.util.List;

/**
 * Created by Thanh Chuong on 20/2/17.
 */
public class TestDataBuilder {
    protected static Object[][] obj = null;
    protected static String currentDataFile="";

    protected static void prepareTestData(String issue, String datafile) throws Exception {
        currentDataFile=datafile;
        XlsDataSrc xls = new XlsDataSrc();
        List<String[]> datasrc = xls.readXLSFile(datafile, 0);
        int size = datasrc.size() - 1;
        Object[][] obj = new Object[size][];
        LCTestDataBuilder.obj = obj;
        //Remove header
        for (int key = 1; key < datasrc.size(); key++) {
            String[] row = datasrc.get(key);
            obj[key - 1] = new Object[]{key - 1, row};
        }
    }
}
