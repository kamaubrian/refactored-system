/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.*;
import javax.swing.JFrame;
/**
 *
 * @author Esperant
 */
public class adminController {
    static AdminView adminview = new AdminView();
    
    
    
    public static JFrame showPage(){
        adminview.setVisible(true);
        return adminview;
    }
    
}
