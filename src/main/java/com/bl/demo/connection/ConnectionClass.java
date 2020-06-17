/***********************************************************************************************************
 * @Purpose:- Connection Class used to connection with database
 * @Author:- priyanka
 * @Date:- 13/6/2020
 ************************************************************************************************************/
package com.bl.demo.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
    public static Connection getConnection () throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
    }
}
