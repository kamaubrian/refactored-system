/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import javax.swing.JFrame;
import View.*;
/**
 *
 * @author Esperant
 */
public class RequestCar {
    static RequestView request = new RequestView();
    
    
    
    
    public static JFrame showPage(){
        request.setVisible(true);
        return request;
    }
    
}
