package com.lqp.automation.database;

import com.lqp.automation.web.util.SerenityUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Thanh Chuong on 22/2/17.
 */
public class OracleSQLHelper {

    private static Connection connection = null;

    public static Connection getOracleDatabaseConnection() throws ClassNotFoundException, SQLException {
        if(connection == null || connection.isClosed()){
            String url = SerenityUtil.getEnv("database.url");
            String port = SerenityUtil.getEnv("database.port");
            String user = SerenityUtil.getEnv("database.username");
            String pwd = SerenityUtil.getEnv("database.password");
            String sid = SerenityUtil.getEnv("database.sid");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@"+url+":"+port+":"+sid+"", user, pwd);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException{
        if(connection!=null && !connection.isClosed()){
            connection.close();
        }
    }
}
