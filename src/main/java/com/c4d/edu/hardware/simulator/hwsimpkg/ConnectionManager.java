/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c4d.edu.hardware.simulator.hwsimpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ROBERT
 */
public class ConnectionManager {
    
    public static String userName = "root";
    public static String password = "";
    public static String server = "localhost";
    public static String port = "3306";
    public static String database = "edudb";

    private static Connection conn = null;
    
    public static Connection getConnection() throws SQLException
    {
//        if(conn != null)
//        {
//            return conn;
//        }
        
        String connURL = "jdbc:mysql://"+server+":"+port+"/"+database;
        conn = DriverManager.getConnection(connURL, userName, password);
        return conn;
    }
}
