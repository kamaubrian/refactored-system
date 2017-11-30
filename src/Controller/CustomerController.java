/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import javax.swing.*;
import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
/**
 *
 */
public class CustomerController {
    static Customers customerview = new Customers();
    static User usermodel =  new User();
    static DefaultTableModel tablemodel = (DefaultTableModel)customerview.getCustomersTable().getModel();
    static Map itemlist = new HashMap();
    static HomeHandler homehandler = new HomeHandler();
    
    static class HomeHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                customerview.dispose();
                AdminController.showPage();
            }catch(Exception ex){
                ex.printStackTrace();
            }            
        }        
    }
    
    public static JFrame showCustomers(){
        customerview.setLocationRelativeTo(null);
        customerview.setResizable(false);
        populateTable();
        customerview.goHome().addActionListener(homehandler);
        customerview.setVisible(true);                
        return customerview;
    }
    
    public static void populateTable(){
        ArrayList<ArrayList<String>> tabledetails;
        try{
            tabledetails = usermodel.getUserDetails();
            if(tablemodel.getRowCount()!=0){
               tablemodel.setRowCount(0);
               itemlist.clear();
            }
            for(ArrayList<String> x: tabledetails){
                Object [] items ={
                  x.get(0),x.get(1),x.get(2),x.get(3),x.get(4)
                };
                tablemodel.addRow(items);
            }                                         
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
