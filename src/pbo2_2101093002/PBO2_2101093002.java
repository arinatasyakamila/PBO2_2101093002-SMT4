/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo2_2101093002;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tasya.dao.Koneksi;

/**
 *
 * @author User
 */
public class PBO2_2101093002 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            // TODO code application logic here
            Koneksi koneksi = new Koneksi();
            Connection con = koneksi.getKoneksi();
            JOptionPane.showMessageDialog(null, "Koneksi ok");
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error :"+ ex.getMessage());
            Logger.getLogger(PBO2_2101093002.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
