/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Admin;
import View.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    static Map itemlist = new HashMap();
    
    public static JFrame showPage(){
        adminview.setVisible(true);
        populateTable();
        return adminview;
    }
    public static void populateTable(){
        ArrayList<ArrayList<String>> items = new ArrayList();
        try{
          items = adminmodel.populateTable();
          if(tablemodel.getRowCount()!=0){
              tablemodel.setRowCount(0);
              itemlist.clear();
          }
          for(ArrayList<String> x: items) {
              Object[] list = {
                  x.get(0),x.get(1),x.get(2),x.get(3)
              };
              tablemodel.addRow(list);
              
          }            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }        
    }
    
}
