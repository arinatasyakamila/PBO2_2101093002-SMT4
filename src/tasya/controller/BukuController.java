/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tasya.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tasya.dao.BukuDao;
import tasya.dao.BukuDaoImpl;
import tasya.dao.Koneksi;
import tasya.model.Buku;
import tasya.view.FormBuku;

/**
 *
 * @author User
 */
public class BukuController {
    
    private FormBuku formBuku;
    private Buku buku;
    private BukuDao dao;
    private Connection con;
    private Koneksi K;
    
    public BukuController(FormBuku formBuku){
        try {
            this.formBuku = formBuku;
            dao = new BukuDaoImpl();
            K = new Koneksi();
            con = K.getKoneksi();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    public void bersihForm(){
        formBuku.getTxtKodeBuku().setText("");
        formBuku.getTxtJudul().setText("");
        formBuku.getTxtPengarang().setText("");
        formBuku.getTxtPenerbit().setText("");   
    }
    
    public void insert(){
        try {
            buku = new Buku();
            buku.setKodebuku(formBuku.getTxtKodeBuku().getText());
            buku.setJudul(formBuku.getTxtJudul().getText());
            buku.setPengarang(formBuku.getTxtPengarang().getText());
            buku.setPenerbit(formBuku.getTxtPenerbit().getText());
            dao.insert(con, buku);
            JOptionPane.showMessageDialog(formBuku, "Entri OK"); 
        } catch (Exception ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void update(){
        try {
            buku = new Buku();
            buku.setKodebuku(formBuku.getTxtKodeBuku().getText());
            buku.setJudul(formBuku.getTxtJudul().getText());
            buku.setPengarang(formBuku.getTxtPengarang().getText());
            buku.setPenerbit(formBuku.getTxtPenerbit().getText());
            dao.update(con, buku);   
            JOptionPane.showMessageDialog(formBuku, "Update OK");
        } catch (Exception ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        try {
            dao.delete(con, buku);
            JOptionPane.showMessageDialog(formBuku, "Delete OK");
        } catch (Exception ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cari(){
        try {
            String kode = formBuku.getTxtKodeBuku().getText();
            buku = dao.getBuku(con, kode);
            if(buku != null){
                formBuku.getTxtJudul().setText(buku.getJudul());
                formBuku.getTxtPengarang().setText(buku.getPengarang());
                formBuku.getTxtPenerbit().setText(buku.getPenerbit());
            }else{
                JOptionPane.showMessageDialog(formBuku, "Data Tidak Ada");
            }
        } catch (Exception ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tampil(){
        try {
            DefaultTableModel tabel = (DefaultTableModel) formBuku.getTblBuku().getModel();
            tabel.setRowCount(0);
            List<Buku> list = dao.getAllBuku(con);
            for(Buku buku1 : list){
                Object[] row = {
                    buku1.getKodebuku(),
                    buku1.getJudul(),
                    buku1.getPengarang(),
                    buku1.getPenerbit()
                        
                };
                tabel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
}
