/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts_b.controller;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tasya.dao.Koneksi;
import uts_b.dao.PenjualanDao;
import uts_b.model.Penjualan;
import uts_b.view.FrormPenjualan;


/**
 *
 * @author User
 */
public class PenjualanController {
    
    private FrormPenjualan formPenjualan;
    private Penjualan penjualan;
    private PenjualanDao dao;
    private Connection con;
    private Koneksi K;
    
    public PenjualanController(FrormPenjualan formPenjualan){
       
        try {
             this.formPenjualan = formPenjualan;
            //dao = new PenjualanDaoImpl();
             K = new Koneksi();
            con = K.getKoneksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PenjualanController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
      public void clearForm(){
       
        //formPenjualan.getTxtKode().setText("");
        //formPenjualan.getTxtTgl().setText("");
        //formPenjualan.getTxtNama().setText("");
        //formPenjualan.getTxtTotBayar().setText("");
        //formPenjualan.getTxtOngkos().setText("");
        //formPenjualan.getTxtDiskon().setText("");
        
    }
      
public void cari(){
    
       // try {
          //  String ode = formPenjualan.getTxtKode().getText();
            //penjualan  = dao.getPenjualan(con, kode);
            //if(penjualan != null){
            //    formPenjualan.getTxtTgl().setText(penjualan.getTgl());
            //    formPenjualan.getTxtNama().setText(penjualan.getNama());
            //    formPenjualan.getTxtTotBayar().setText(penjualan.getTotbayar());
            //   formPenjualan.getTxtOngkos().setText(penjualan.getOngkos());
              
            //}else{ 
                JOptionPane.showMessageDialog(formPenjualan, "Data Tidak Data");
            }
        //} catch (Exception ex) {
          //  Logger.getLogger(PenjualanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   // }

      //public void tampil(){
/**
        try {
            DefaultTableModel tabel = (DefaultTableModel) formPenjualan.getTblPenjualan().getModel();
            tabel.setRowCount(0);
            List<Penjualan> list = dao.getAllPenjualan(con);
            for(Penjualan penjualan1 : list){
                //array yg datanya langsung diisi
                Object[] row = {
                    penjualan1.getKode(),
		   penjualan1.getTgl(),
                    penjualan1.getNama(),
	          penjualan1.getTotbayar(),
		penjualan1.getOngkos(),
		penjualan1.getDiskon(),
			  
                };
                tabel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(PenjualanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void delete(){
        try {
            dao.delete(con, penjualan);
            JOptionPane.showMessageDialog(formPenjualan, "Delete OK");
        } catch (Exception ex) {
            Logger.getLogger(PenjualanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    


    public void update(){
    
        try {
            penjualan = new Penjualan();
            penjualan.setKodeanggota(formPenjualan.getTxtKodeAnggota().getText());
            penjualan.setTgl(
                    formPenjualan.getTxtTgl().getText());
            penjualan.setNamaanggota(
                    formPenjualan.getTxtNama().getText());
            penjualan.setTotbayar(
                    formPenjualan.getTxtTotBayar().getText());
            penjualan.setOngkos(
                    formPenjualan.getTxtOngkos().getText());
            penjualan.setDiskon(
                    formPenjualan.getTxtDiskon().getText());
            JOptionPane.showMessageDialog(formPenjualan, "Update Ok");
        } catch (Exception ex) {
            Logger.getLogger(PenjualanController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
    }
    
    
    
    public void insert(){
        
            
        try {
            penjualan = new Penjualan();
            penjualan .setKodeanggota(formPenjualan.getTxtKodeAnggota().getText());
          penjualan.setTgl(
                    formPenjualan.getTxtTgl().getText());
            penjualan.setNamaanggota(
                    formPenjualan.getTxtNama().getText());
            penjualan.setTotbayar(
                    formPenjualan.getTxtTotBayar().getText());
            penjualan.setOngkos(
                    formPenjualan.getTxtOngkos().getText());
            penjualan.setDiskon(
                    formPenjualan.getTxtDiskon().getText());
            JOptionPane.showMessageDialog(formPenjualan, "Entri Ok");
        } catch (Exception ex) {
            Logger.getLogger(PenjualanController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           
        
        
    }
    
    
    
    
}
*/ 