/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import View.*;
import javax.swing.JOptionPane;
import Model.*;

/**
 *
 * @author Esperant
 */
public class NewUserController {
        static newAccountHandler accounts = new newAccountHandler();
        static exitHandler exit = new exitHandler();
        static NewUserV newUser = new NewUserV();
        static LoginModel loginmodel = new LoginModel();
        static User usermodel = new User();
        
    
    
    
       static class newAccountHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
            String passport = newUser.getPassport().getText();
            String firstname = newUser.getFirstName().getText();
            String lastname = newUser.getLastName().getText();
            String username = newUser.getUsername().getText();
            String phone = newUser.getPhone().getText();
            String password = newUser.getPassword().getText();
            String c_Password=newUser.getPassword2().getText();
            if(passport.isEmpty()){
                JOptionPane.showMessageDialog(newUser,"Enter Passport Number");
                return;
            }
            if(firstname.isEmpty()){
                JOptionPane.showMessageDialog(newUser,"Enter First Name");
                return;
            }
            if(lastname.isEmpty()){
                JOptionPane.showMessageDialog(newUser,"Enter Last Name");
                return;
            }
            
            if(username.isEmpty()){
                JOptionPane.showMessageDialog(newUser, "Enter Username");
                return;
            }
            if(phone.isEmpty()){
                JOptionPane.showMessageDialog(newUser,"Enter Phone Number");
                return;
            }
            if(password.isEmpty()){
                JOptionPane.showMessageDialog(newUser,"Enter Password");
                return;
            }if(c_Password.isEmpty()){
                JOptionPane.showMessageDialog(newUser,"Confirm Password");
                return;
            }
            if(!password.equals(c_Password)){
                JOptionPane.showMessageDialog(newUser,"Passwords Do Not Match");
                return;
            }
            else{
               String table ="customer";
               if(loginmodel.getUsername(table,username).toLowerCase().isEmpty()){
                   usermodel.addUser(passport,firstname,lastname,username,phone,password);
                   
                   JOptionPane.showMessageDialog(newUser,"User Added Successfully");
                   clear();
                   newUser.dispose();
                   
               }else{
                   JOptionPane.showMessageDialog(newUser, "Username Already Exists");
                   clear();
               }
            }
                       
            
            
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
        }
        
    }
       static class exitHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            try{
                newUser.dispose();
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
            
        }
           
           
           
       }
       
       public static JFrame showPage(){
           newUser.exit().addActionListener(exit);
           newUser.signUp().addActionListener(accounts);
           newUser.setVisible(true);
           return newUser;
       }
       public static void clear(){
           newUser.getFirstName().setText("");
           newUser.getUsername().setText("");
           newUser.getLastName().setText("");
           newUser.getPassport().setText("");
           newUser.getPassword2().setText("");
           newUser.getPassword().setText("");
           newUser.getPhone().setText("");
       }
}
