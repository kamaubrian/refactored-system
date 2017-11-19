/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import javax.swing.JFrame;
import View.*;
import java.awt.event.ActionEvent;
import Model.*;
import java.awt.event.ActionListener;
/**
 *
 * @author Esperant
 */
public class RequestCar {
    static RequestView request = new RequestView();
    static searchHandler searchcar = new searchHandler();
    static AvailableCars carsmodel = new AvailableCars();
    
    static class searchHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            try{
                String model = request.getModel().getText();
                String make = request.getMake().getSelectedItem().toString();
                if(carsmodel.findCarExists(model, make)){
                    System.out.println("Car is Found");
                }else{
                    System.out.println("Car Not Found");
                }
                
                
                
                
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
                                    
            
        }
        
        
        
    }
    
    
    
    public static JFrame showPage(){
        request.setVisible(true);
        request.searchCar().addActionListener(searchcar);
        return request;
    }
    
    
    
}
