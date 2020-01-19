package com.mycompany.mavenproject2;
import java.sql.*;
import com.mysql.jdbc.Driver;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Connect {
    static Connection con;
    public static Connection getMyConnection() {  
        try {  
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sihtesting","root","root"); 
            System.out.println("yes");
            System.out.println(con.toString());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return con; 
}
}
