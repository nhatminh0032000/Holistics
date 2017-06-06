package com.lqp.automation.database;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Thanh Chuong on 22/2/17.
 */
public class SQLHelperFacade {
    public static Connection getConnection(SQLType type) throws SQLException, ClassNotFoundException {
        switch (type){
            case ORACLE:
                return OracleSQLHelper.getOracleDatabaseConnection();
        }
        return null;
    }

    public static void closeConnection(SQLType type) throws Exception{
        switch (type){
            case ORACLE:
                OracleSQLHelper.closeConnection();
        }
    }

}
