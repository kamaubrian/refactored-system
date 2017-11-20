/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
/**
 *
 * @author Esperant
 */
public class Deposits {
    static DepositsView deposit = new DepositsView();
    static DepositHandler depositHandler = new DepositHandler();
    static class DepositHandler implements  ActionListener{
        private int index =0;
        private int maxIndex = 100;
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                System.out.println("Ninja");
                deposit.getProgress().setValue(0);
                deposit.getProgress().setStringPainted(true);
                if(index<maxIndex){
                    for(int i =0;i<=maxIndex;i++){
                    deposit.getProgress().setValue(index);
                    index++;
                    }
                }else{
                    deposit.getProgress().setValue(maxIndex);
                }
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
            
        }
        
        
    }
    
    public JFrame showPage(){
        deposit.setLocationRelativeTo(null);
        deposit.setVisible(true);
        deposit.getDeposit().addActionListener(depositHandler);
        return deposit;
    }
}
