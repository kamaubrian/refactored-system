/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Esperant
 */

public class Login {
    static LoginView loginview = new LoginView();
    static loginHandler login = new loginHandler();
    static exitHandler exit = new exitHandler();
    static LoginModel loginmodel = new LoginModel();
    
    
    static class loginHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String username = loginview.getUsername().getText();
                String password = loginview.getPassword().getText();
                String pass =loginmodel.getPassword(password);
                String usern = loginmodel.getUsername(username);
                if(username.isEmpty()){
                    JOptionPane.showMessageDialog(loginview,"Please Enter Username");
                    return;
                }
                if(password.isEmpty()){
                    JOptionPane.showMessageDialog(loginview, "Please Enter Password");
                    return;
                }
                if(username.equals(usern) && password.equals(pass)){
                    System.out.println("Correct Credentials ");
                }else{
                    System.out.println("Incorrect Password");
                }
                
               /* if(!loginmodel.getAdmin(username).isEmpty()){
                    usern = loginmodel.getAdmin(username).get(0);
                    pass = loginmodel.getAdmin(username).get(1);
                   if(pass.equals(password)){
                       System.out.println("Correct Password");
                   }else{
                       System.out.println("Incorrect Password");
                   } 
                   
                }*/
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
            
        }
        
    }
    static class exitHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
        
    }
    
    static{
        try{
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE,null,ex);
        }
    
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        showPage();
    }
    
    public static JFrame showPage(){
        loginview.exitSystem().addActionListener(exit);
        loginview.loginSystem().addActionListener(login);
        loginview.setVisible(true);
        return loginview;
       
    }
    
    
    
    
    
}

