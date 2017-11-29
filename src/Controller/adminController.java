/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Admin;
import View.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

/**
 *
 * 
 */
public class adminController {
    static AdminView adminview = new AdminView();
    static Admin adminmodel = new Admin();
    static DefaultTableModel tablemodel = (DefaultTableModel)adminview.getTable().getModel();
    static Map itemlist = new HashMap();
    
    public static JFrame showPage(){
        adminview.setVisible(true);
        adminview.setTitle("Administrator View");
        adminview.setResizable(false);
        adminview.setLocationRelativeTo(null);
        populateTable();
        adminview.getAccountsPane().setBackground(Color.white);
        XYDataset data = createDataset();
        JFreeChart chart = ChartFactory.createXYLineChart("Test Chart",
                        "x", "y", data, PlotOrientation.VERTICAL, true, true,
                        false);
        adminview.getAccountsPane().setLayout(new java.awt.BorderLayout());
        ChartPanel charww = new ChartPanel(chart);
        adminview.getAccountsPane().add(charww);
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
    public static XYDataset createDataset(){
        DefaultXYDataset finance = new DefaultXYDataset();
        try{
            double[][] data ={{0.1,0.2,0.3},{1,2,3}};
            finance.addSeries("Financial Info", data);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return finance;
    }
    
}
