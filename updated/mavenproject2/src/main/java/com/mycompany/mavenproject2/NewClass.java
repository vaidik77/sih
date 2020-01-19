package com.mycompany.mavenproject2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;
import static spark.Spark.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class NewClass {
    public static void main(String[] args) {
        
        staticFiles.location("/public");
        
        post("/registerPageHandler" , (request,response) -> {
           Connection con = Connect.getMyConnection();
           String s = "INSERT into userdetails values(?,?,?,?,?,?,?)";
           PreparedStatement ps = con.prepareStatement(s);
            System.out.println(""+request.queryParams("firstname"));
            System.out.println(""+request.queryParams("lastname"));
            System.out.println(""+request.queryParams("email"));
            System.out.println(""+request.queryParams("dob"));
            System.out.println(""+request.queryParams("gender"));
//            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(request.queryParams("dob"));  
//            System.out.println(""+date1);
           String password=request.queryParams("firstname").substring(0, 3)+request.queryParams("dob").substring(0,4);
            System.out.println(password);
           ps.setString(1,request.queryParams("firstname"));
           ps.setString(2,request.queryParams("lastname"));
           ps.setString(3,request.queryParams("email"));
           ps.setString(4,request.queryParams("gender"));
           ps.setString(5,request.queryParams("mobile"));
           ps.setString(6,""+request.queryParams("dob"));
           ps.setString(7, password);
           
           int i = ps.executeUpdate();
           if(i==1)
           {
               response.redirect("/index.html");
           }
           else
           {
               response.redirect("/register.html");
           }
            return 0;
        });
        
        
        post("/loginPageHandler" , (request,response) -> {
           Connection con = Connect.getMyConnection();
           String s = "select * from userdetails where email=? and password=?";
           PreparedStatement ps = con.prepareStatement(s);
            System.out.println(""+request.queryParams("uname"));
            System.out.println(""+request.queryParams("psw"));
           ps.setString(1, request.queryParams("uname"));
           ps.setString(2, request.queryParams("psw"));
           ResultSet rs=ps.executeQuery();
           ResultSetMetaData rmd = rs.getMetaData();
           JSONObject json = new JSONObject();
           if(rs.next()){
            
            int columncount = rmd.getColumnCount();
                for(int i=1;i<=columncount;i++)
                {
                    json.put(rmd.getColumnName(i), rs.getString(i));
                    System.out.println("working");
                }
                        System.out.println("coming");
                json.put("status", "correct");
               
           }
           else{
               System.out.println("Wrong email id password");
               json.put("status","wrong");
               
           }
           return json;
        });
        
//        post("/getdata", (request,response) -> {        //Get the data of user entered at the time of registration.
//           
//            Connection con = Connect.getMyConnection();
//
//            String s = "select * from userdetails where email=?";
//            PreparedStatement ps= con.prepareStatement(s);
//            ps.setString(1, request.queryParams("email"));
//            ResultSet rs = ps.executeQuery();
//            ResultSetMetaData rmd = rs.getMetaData();
//            
//            JSONObject json = new JSONObject();
//            if(rs.next())
//            {
//                int columncount = rmd.getColumnCount();
//                for(int i=1;i<=columncount;i++)
//                {
//                json.put(rmd.getColumnName(i), rs.getString(i));
//                }
//                        
//            }
//            return json;
//        });
        
    }
    
}
