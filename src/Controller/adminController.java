/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Admin;
import View.*;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Esperant
 */
public class adminController {
    static AdminView adminview = new AdminView();
    static Admin adminmodel = new Admin();
    static DefaultTableModel tablemodel = (DefaultTableModel)adminview.getTable().getModel();
    
    
    public static JFrame showPage(){
        adminview.setVisible(true);
        return adminview;
    }
    public void populateTable(){
        List<Object> items;
        try{
          items = adminmodel.populateTable();
          

            
            
            
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }        
    }
    
}
