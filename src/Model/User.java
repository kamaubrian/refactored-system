/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Esperant
 */
public class User extends Base{
    
    private String username;
    private String password;
    
    public boolean addUser(String username,String password){
        boolean success = true;
        String sql;
        try{
            getConnection();
            sql="INSERT INTO USER(Username,Password) VALUES(?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1,username);
            pst.setString(2,password);
            pst.executeUpdate();
            success=true;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }        
        return success;
    }
    
}
