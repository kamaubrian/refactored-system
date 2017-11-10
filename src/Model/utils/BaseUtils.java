/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.utils;
import java.sql.*;
/**
 *
 * @author brian-kamau
 */
public interface BaseUtils {
    
    public boolean getConnection() throws SQLException;
    public boolean closeConnection() throws SQLException;
}
