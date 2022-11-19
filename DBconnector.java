package framedemo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DBconnector {
    private Connection connect;
    
    void createtable(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/new", "root", "jashanniranjan");
        Statement stmt = connect.createStatement();
        int count = stmt.executeUpdate(" create table StudentDB(sid integer,name varchar(20),address varchar(50),dob date,contactno bigint,dept varchar(20),batch year);");
        System.out.println(count);
        count = stmt.executeUpdate("commit");
        System.out.println(count);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }


    String insert (int sid, String name,String address,String dob,String contactno,String dept,String batch){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/new", "root", "jashanniranjan");
        Statement stmt = connect.createStatement();
        stmt.executeUpdate("insert into StudentDB values("+sid+",'"+name+"','"+address+"','"+Date.valueOf(dob)+"',"+Long.parseLong(contactno)+",'"+dept+"',"+Integer.parseInt(batch)+")");
        stmt.executeUpdate("commit");
        return "insertion successful";
        }
        catch(Exception e){
            return "exception occured please try again";
        }
        
    }
    String delete(int sid){
        int count=-1;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/new", "root", "jashanniranjan");
        Statement stmt = connect.createStatement();
        count = stmt.executeUpdate("delete from StudentDB where sid="+sid);
        stmt.executeUpdate("commit");
        }
        catch(Exception e){
            return e.getLocalizedMessage();
        }
        return "operation successful";
    }
    String select(int select_id){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/new", "root", "jashanniranjan");
            Statement stmt = connect.createStatement();
            ResultSet result= stmt.executeQuery("select * from StudentDB where sid="+select_id);
            result.next();
            int sid=Integer.parseInt(result.getString("sid"));
            String name = result.getString("name");
            String address=result.getString("address");
            Date dob =Date.valueOf(result.getString("dob")) ;
            long contact_no = result.getLong("contactno");
            String dept=result.getString("dept");
            String batch=result.getString("batch");
            return "Sid: "+sid+",\nName: " + name + ",\nAddress: " + address + ",\nDOB:" + dob+ ",\nContact_No: " + contact_no + ",\nDept: " + dept + ",\nBatch: " + batch + "\n";
        }
        catch(Exception e){
            //return "exception occured please try again";
            return e.getLocalizedMessage();
        }
    }
    int generateSid(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/new", "root", "jashanniranjan");
            Statement stmt = connect.createStatement();
            ResultSet result= stmt.executeQuery("Select sid from StudentDb where sid =(select max(sid) from StudentDB)");
            result.next();
            return result.getInt("sid")+1;
            
        }
        catch(Exception e){
            //return "exception occured please try again";
            return 1;
        }

    }
    String overview_statement(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/new", "root", "jashanniranjan");
            Statement stmt = connect.createStatement();
            ResultSet result= stmt.executeQuery("Select count(*) from StudentDB");
            result.next();
            return "Total of "+result.getInt(1)+" rows are present in the database";
            
        }
        catch(Exception e){
            //return "exception occured please try again";
            return e.getLocalizedMessage();
        }
    }
    
}
