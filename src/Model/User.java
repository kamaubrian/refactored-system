/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Esperant
 */
public class User extends Base{
    
    private String username;
    private String password;
    
    public boolean addUser(String passport,String firstname,String lastname,
            String username,String phone,String password) throws SQLException{
        boolean success = true;
        String sql;
        try{
            getConnection();
            sql="INSERT INTO USER(ID_PASSPORT,FirstName,LastName,Username,Phone,Password) VALUES(?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1,passport);
            pst.setString(2,firstname);
            pst.setString(3,lastname);
            pst.setString(4,username);
            pst.setString(5,phone);
            pst.setString(6,password);
            pst.executeUpdate();
            success=true;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            closeConnection();
        }        
        return success;
    }
    
    public boolean lookUpUsername(String username) throws SQLException{
        boolean success= true;
        String sql;
        try{
            getConnection();
            sql="SELECT * FROM USER WHERE Username=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,username);
            rst=pst.executeQuery();
            if(rst.next()){
                System.out.println("Username Found");
                success= true;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            closeConnection();
        }
       
        return success;
    }
       public ArrayList<String> getRequestDetails(String username)throws SQLException{
        ArrayList<String> userdetails = new ArrayList();
        String sql;
        try{
            getConnection();
            sql="SELECT * FROM USER WHERE Username =?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, username);
            rst=pst.executeQuery();
            if(rst.next()){
                userdetails.add(rst.getString("FirstName"));
                userdetails.add(rst.getString("ID_PASSPORT"));
                userdetails.add(rst.getString("Username"));
                
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            closeConnection();
        }
        return userdetails;
               
    }
       public List<Object> getSubscriptionDetails(String username) throws SQLException{
          String sql;
          List<Object> subscription = new ArrayList();
           try{
               getConnection();
               sql="SELECT * FROM ACCOUNT WHERE Username=?";
               pst=conn.prepareStatement(sql);
               pst.setString(1, username);
               rst=pst.executeQuery();
               if(rst.next()){
                   subscription.add(rst.getInt("ACC_NO"));
                   subscription.add(rst.getString("Credit_Balance"));
                   subscription.add(rst.getString("Subscription"));
               }
               
           }catch(Exception ex){
               ex.printStackTrace();
           }finally{
               closeConnection();
           }
           return subscription;
       }

    
}
