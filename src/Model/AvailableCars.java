/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Esperant
 */
public class AvailableCars extends Base {
    
    public ArrayList<String> getFilePath(int id){
        ArrayList<String> path = new ArrayList();
        String sql;
        try{
            getConnection();
            sql="SELECT * FROM CARS_AVAILABLE WHERE TAGNO = ?";
            pst=conn.prepareStatement(sql);
            pst.setInt(1,id);
            rst=pst.executeQuery();
            if(rst.next()){
                path.add(rst.getString("Resource_Path"));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try {
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(AvailableCars.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        return path;
    }
    public ArrayList<String> getCarExists(String model,String make){
        String sql;
        ArrayList<String> carfound = new ArrayList();
        try{
            getConnection();
            sql="SELECT * FROM CARS_AVAILABLE WHERE Model =? AND Make=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,model);
            pst.setString(2,make);
            rst=pst.executeQuery();
            if(rst.next()){
                carfound.add(rst.getString("TAGNO"));
                carfound.add(rst.getString("CATEGORY"));
                carfound.add(rst.getString("MAKE"));
                carfound.add(rst.getString("MODEL"));
                carfound.add(rst.getString("YEAR"));
            }else{
                
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try {
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(AvailableCars.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return carfound;
    }
    public boolean findCarExists(String model,String make){
        return !getCarExists(model,make).isEmpty();
    }
    
    
}
