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

/**
 *
 * @author brian-kamau
 */
public class NewUserController {
        static newAccountHandler accounts = new newAccountHandler();
        static NewUserV newUser = new NewUserV();
    
    
    
       static class newAccountHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
       
       public static JFrame showPage(){
           newUser.setVisible(true);
           return newUser;
       }
}
