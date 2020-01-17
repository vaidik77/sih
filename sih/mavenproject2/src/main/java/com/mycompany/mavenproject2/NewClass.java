package com.mycompany.mavenproject2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static spark.Spark.*;

public class NewClass {
    public static void main(String[] args) {
        get("/first" , (request,response) -> {
           Connection con = Connect.getMyConnection();
           String s = "select * from checktable";
           PreparedStatement ps = con.prepareStatement(s);
           ResultSet rs = ps.executeQuery();
           while(rs.next())
           {
               System.out.println(""+rs.getString(1)+" "+rs.getString(2));
           }
            return 0;
        });
        
        
    }
    
}
