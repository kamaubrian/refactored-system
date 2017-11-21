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
import java.awt.Image;
import java.util.List;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author Esperant
 */
public class RequestCar {
    static RequestView request = new RequestView();
    static searchHandler searchcar = new searchHandler();
    static DepositHandler deposit = new DepositHandler();
    static AvailableCars carsmodel = new AvailableCars();
    static User usermodel = new User();
    static Login login = new Login();
    static Deposits depo = new Deposits();
    public static List<Object> subscription_details;
    
    
    static class DepositHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            depo.showPage();
        }
        
        
        
    }
    static class searchHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            try{
                String model = request.getModel().getText();
                String make = request.getMake().getSelectedItem().toString();
                if(!model.isEmpty()){
                if(carsmodel.findCarExists(model, make)){
                    
                    carsmodel.getCarExists(model, make);
                    request.getTagNo().setText(carsmodel.getCarExists(model, make).get(0));
                    request.getCategory().setText(carsmodel.getCarExists(model, make).get(1));
                    request.getMaker().setText(make);
                    
                    request.getModeler().setText(model);
                    request.getYear().setText(carsmodel.getCarExists(model, make).get(4));
                    request.getMaker().setEditable(false);
                    request.getTagNo().setEditable(false);
                    request.getCategory().setEditable(false);
                    request.getModeler().setEditable(false);
                    request.getYear().setEditable(false);
                    
                    
                }else{
                    System.out.println("Car Not Found");
                    JOptionPane.showMessageDialog(request, "Car Not Found");
                }
                }else{
                    JOptionPane.showMessageDialog(request,"Enter Car Model");
                    return;
                }
                
                
                
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
                                    
            
        }
        
        
        
    }
    
    
    
    public static JFrame showPage() {
        try{
        request.getCustomername().setText(Login.details.get(0));
        request.getPassport().setText(Login.details.get(1));
        request.getUsername().setText(Login.details.get(2));
        subscription_details=usermodel.getSubscriptionDetails(request.getUsername().getText());
        request.getAccount().setText(subscription_details.get(0).toString());
        request.getCreditBalance().setText(subscription_details.get(1).toString());
        request.getSubscription().setText(subscription_details.get(2).toString());
        request.setVisible(true);
        request.getAccount().setEnabled(false);
        request.getSubscription().setEnabled(false);
        request.getCreditBalance().setEnabled(false);
        request.searchCar().addActionListener(searchcar);
        request.getDeposit().addActionListener(deposit);
       
        }catch(Exception ex){
            ex.printStackTrace();
        }
          return request;
    }
    
    
    
}
