/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.*;
/**
 *
 * @author brian-kamau
 */
public class Book extends Base {
    public boolean makeBooking(String username,String make,String model,int hourly_price,int hours_booked,double total_price ) throws SQLException{
        String sql;
        try{
            getConnection();
            sql="INSERT INTO BOOKING(USERNAME,MAKE,MODEL,PRICE_HOURLY,HOURS_BOOKED,TOTAL_PRICE) VALUES(?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1,username);
            pst.setString(2,make);
            pst.setString(3,model);
            pst.setInt(4, hourly_price);
            pst.setInt(5,hours_booked);
            pst.setDouble(6,total_price);
            pst.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            closeConnection();
        }
        
        return true;
    }
    
    
    
}
