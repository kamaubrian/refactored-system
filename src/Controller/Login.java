/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author brian-kamau
 */

public class Login {
    static LoginView loginview = new LoginView();
    
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
        loginview.setVisible(true);
        return loginview;
       
    }
}

