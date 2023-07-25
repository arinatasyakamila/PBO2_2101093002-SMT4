/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasya.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tasya.dao.AnggotaDao;
import tasya.dao.AnggotaDaoImpl;
import tasya.dao.Koneksi;
import tasya.model.Anggota;
import tasya.view.FormAnggota;

/**
 *
 * @author User
 */
public class AnggotaController {
    
    private FormAnggota formAnggota;
    private Anggota anggota;
    private AnggotaDao dao;
    private Connection con;
    private Koneksi K;
    
    public AnggotaController(FormAnggota formAnggota){
        try {
            this.formAnggota = formAnggota;
            dao = new AnggotaDaoImpl();
            K = new Koneksi();
            con = K.getKoneksi();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clearForm(){
       
        formAnggota.getTxtKodeAnggota().setText("");
        formAnggota.getTxtNamaAnggota().setText("");
        formAnggota.getTxtAlamat().setText("");
    }
    
    
    
    public void isiCboJenisKelamin(){
        formAnggota.getCboJenisKelamin().removeAllItems();
        formAnggota.getCboJenisKelamin().addItem("L");
        formAnggota.getCboJenisKelamin().addItem("P");
    }
    
    
public void cari(){
    
        try {
            String kode = formAnggota.getTxtKodeAnggota().getText();
            anggota = dao.getAnggota(con, kode);
            if(anggota != null){
                formAnggota.getTxtNamaAnggota().setText(anggota.getNamaanggota());
                formAnggota.getTxtAlamat().setText(anggota.getAlamat());
                formAnggota.getCboJenisKelamin().setSelectedItem(anggota.getJeniskelamin());
            }else{ 
                JOptionPane.showMessageDialog(formAnggota, "Data Tidak Data");
            }
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void tampil(){
        try {
            DefaultTableModel tabel = (DefaultTableModel) formAnggota.getTblAnggota().getModel();
            tabel.setRowCount(0);
            List<Anggota> list = dao.getAllAnggota(con);
            for(Anggota anggota1 : list){
                //array yg datanya langsung diisi
                Object[] row = {
                    anggota1.getKodeanggota(),
                    anggota1.getNamaanggota(),
                    anggota1.getAlamat(),
                    anggota1.getJeniskelamin()
                };
                tabel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void delete(){
        try {
            dao.delete(con, anggota);
            JOptionPane.showMessageDialog(formAnggota, "Delete OK");
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
   
public void update(){
    
        try {
            anggota = new Anggota();
            anggota.setKodeanggota(formAnggota.getTxtKodeAnggota().getText());
            anggota.setNamaanggota(
                    formAnggota.getTxtNamaAnggota().getText());
            anggota.setAlamat(
                    formAnggota.getTxtAlamat().getText());
            anggota.setJeniskelamin (
                    formAnggota.getCboJenisKelamin().getSelectedItem().toString());
            dao.update(con,anggota);
            JOptionPane.showMessageDialog(formAnggota, "Update Ok");
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
    }
    
    
    
   
    public void insert(){
        
            
        try {
            anggota = new Anggota();
            anggota.setKodeanggota(formAnggota.getTxtKodeAnggota().getText());
            anggota.setNamaanggota(
                    formAnggota.getTxtNamaAnggota().getText());
            anggota.setAlamat(
                    formAnggota.getTxtAlamat().getText());
            anggota.setJeniskelamin (
                    formAnggota.getCboJenisKelamin().getSelectedItem().toString());
            dao.insert(con,anggota);
            JOptionPane.showMessageDialog(formAnggota, "Entri Ok");
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        
        
    }
    
    
}
