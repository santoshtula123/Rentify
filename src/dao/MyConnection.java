/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author zenni
 */
public class MyConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/rentify";
    private static final String USER = "root";
    private static final String PASS = "Rentification123!";
            
    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("MySQL driver not found: " + ex.getMessage());
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }
}