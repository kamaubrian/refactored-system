/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author Esperant
 */
public class Admin extends Base {
    public List<Object> populateTable() throws SQLException{
        String sql;
        List<Object> tableitems = new ArrayList();
        try{
            getConnection();
            sql="SELECT * FROM BOOKING";
            pst=conn.prepareStatement(sql);
            rst = pst.executeQuery();
            while(rst.next()){
                List<Object> items = new ArrayList();
                items.add(rst.getString("Username"));
                items.add(rst.getString("MAKE"));
                items.add(rst.getString("MODEL"));
                items.add(rst.getString("Created_At"));
                
                tableitems.add(items);
            }
            
            
                                                            
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            closeConnection();
        }        
        return tableitems;
    } 
    
    
    
}