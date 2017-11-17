/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.utils.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Esperant
 */
public  abstract class Base implements BaseUtils {
    public static String dbUsername ="root";
    public static String dbPassword="wamatu";
    public static String dbUrl="jdbc:mysql://localhost:3306/CarRental?useSSL=false";
    protected Statement stat = null;
    protected Connection conn = null;
    protected PreparedStatement pst = null;
    protected ResultSet rst = null;
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
    protected Base(){
        String sql;
      
        try{
        getConnection();
        stat = conn.createStatement();
        sql ="CREATE TABLE IF NOT EXISTS USER(ID INT NOT NULL AUTO_INCREMENT,"
                + "Username VARCHAR(25) NOT NULL,"
                + "Password VARCHAR(16) NOT NULL,"
                + "Created_At TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,"
                + "PRIMARY KEY(ID))";
        stat.addBatch(sql);
        sql="CREATE TABLE IF NOT EXISTS CARS_AVAILABLE("
                + "TAGNO INT NOT NULL,"
                + "MAKE VARCHAR(25) NOT NULL,"
                + "MODEL VARCHAR(25) NOT NULL,"
                + "YEAR DATE NOT NULL,"
                + "CATEGORY VARCHAR(25) NOT NULL,"
                + "PRIMARY KEY(TAGNO))";
        
        stat.addBatch(sql);
        sql="CREATE TABLE IF NOT EXISTS ADMINS("
                + "ID INT NOT NULL AUTO_INCREMENT,"
                + "Username VARCHAR(25) NOT NULL,"
                + "Password VARCHAR(15) NOT NULL,"
                + "Created_At TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,"
                + "PRIMARY KEY(ID))";
        stat.addBatch(sql);
        stat.executeBatch();
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try {
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
    }
}
