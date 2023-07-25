/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tasya.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Koneksi {
        private String url = "jdbc:mysql://localhost/pbo2_2101093002";
    private String username = "root";
    private String password = "";

  
    
    public Connection getKoneksi() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url,username, password);
    }
    
}
