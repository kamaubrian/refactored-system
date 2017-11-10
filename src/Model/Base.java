/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.utils.*;
import java.sql.*;
/**
 *
 * @author Esperant
 */
public abstract class Base implements BaseUtils {
    public static String dbUsername ="root";
    public static String dbPassword="wamatu";
    public static String dbUrl="jdbc:mysql://localhost:3306/CarRental?useSSL=false";
    protected Statement stat = null;
    protected Connection conn = null;
    protected PreparedStatement pst = null;
    /*
    Include dbDriver if using java 1.5 -> com.mysql.cj.Driver
    include class.forName(dbDriver) for it to work
    */    
    @Override
    public boolean getConnection() throws SQLException{
        /*
        include class.forName(com.mysql.cj.Driver);
        */
        conn=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        return true;
    }
    @Override
    public boolean closeConnection() throws SQLException{
        if(!conn.isClosed()){
            conn.close();
        }
        return true;
    }
}
