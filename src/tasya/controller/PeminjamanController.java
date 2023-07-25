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
import tasya.dao.AnggotaDao;
import tasya.dao.AnggotaDaoImpl;
import tasya.dao.BukuDao;
import tasya.dao.BukuDaoImpl;
import tasya.dao.Koneksi;
import tasya.dao.PeminjamanDao;
import tasya.dao.PeminjamanDaoImpl;
import tasya.model.Anggota;
import tasya.model.Buku;
import tasya.model.Peminjaman;
import tasya.view.FormPeminjaman;

/**
 *
 * @author User
 */
public class PeminjamanController {
    private FormPeminjaman formPeminjaman;
    private Peminjaman peminjaman;
    private PeminjamanDao peminjamanDao;
    private AnggotaDao anggotaDao;
    private BukuDao bukuDao;
    private Connection connection;
    
    public PeminjamanController(FormPeminjaman formPeminjaman){
        try {
            this.formPeminjaman = formPeminjaman;
            peminjamanDao = new PeminjamanDaoImpl() ;
            anggotaDao = new AnggotaDaoImpl();
            bukuDao = new BukuDaoImpl();
            Koneksi k = new Koneksi();
            connection = k.getKoneksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clearForm(){
        formPeminjaman.getTxtTglpinjam().setText("");
        formPeminjaman.getTxtTglkembali().setText("");
    }
    
    public void isiCombo(){
        try {
            formPeminjaman.getCboKodeanggota().removeAllItems();
            formPeminjaman.getCboKodebuku().removeAllItems();
            List<Anggota> anggotaList = anggotaDao.getAllAnggota(connection);
            List<Buku> bukuList = bukuDao.getAllBuku(connection);
            for (Anggota anggota : anggotaList){
                formPeminjaman.getCboKodeanggota().addItem(anggota.getKodeanggota()+"-"+anggota.getNamaanggota());
            }
            for (Buku buku : bukuList){
                formPeminjaman.getCboKodebuku().addItem(buku.getKodebuku());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(){
        try {
            peminjaman = new Peminjaman();
            peminjaman.setKodeanggota(formPeminjaman.getCboKodeanggota().getSelectedItem().toString().split("-")[0]);
            peminjaman.setKodebuku(formPeminjaman.getCboKodebuku().getSelectedItem().toString());
            peminjaman.setTglpinjam(formPeminjaman.getTxtTglpinjam().getText());
            peminjaman.setTglkembali(formPeminjaman.getTxtTglkembali().getText());
            peminjamanDao.insert(connection, peminjaman);
            JOptionPane.showMessageDialog(formPeminjaman, "Entri Data OKE");
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(){
        try {
            peminjaman = new Peminjaman();
            peminjaman.setKodeanggota(formPeminjaman.getCboKodeanggota().getSelectedItem().toString().split("-")[0]);
            peminjaman.setKodebuku(formPeminjaman.getCboKodebuku().getSelectedItem().toString());
            peminjaman.setTglpinjam(formPeminjaman.getTxtTglpinjam().getText());
            peminjaman.setTglkembali(formPeminjaman.getTxtTglkembali().getText());
            peminjamanDao.update(connection, peminjaman);
            JOptionPane.showMessageDialog(formPeminjaman, "Update Data OKE");
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        try {
            peminjamanDao.delete(connection, peminjaman);
            JOptionPane.showMessageDialog(formPeminjaman, "Delete OK");
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getPeminjaman(){
        try {
            String kodeanggota = formPeminjaman.getTblPeminjaman().getValueAt(formPeminjaman.getTblPeminjaman().getSelectedRow(), 0).toString();
            String kodebuku = formPeminjaman.getTblPeminjaman().getValueAt(formPeminjaman.getTblPeminjaman().getSelectedRow(), 1).toString();
            String tglpinjam = formPeminjaman.getTblPeminjaman().getValueAt(formPeminjaman.getTblPeminjaman().getSelectedRow(), 2).toString();
            peminjaman = peminjamanDao.getPeminjaman(connection, kodeanggota, kodebuku, tglpinjam);
            if(peminjaman!=null){
                Anggota anggota = anggotaDao.getAnggota(connection, peminjaman.getKodeanggota());
                formPeminjaman.getCboKodeanggota().setSelectedItem(anggota.getKodeanggota()+"-"+anggota.getNamaanggota());
                formPeminjaman.getCboKodebuku().setSelectedItem(peminjaman.getKodebuku());
                formPeminjaman.getTxtTglpinjam().setText(peminjaman.getTglpinjam());
                formPeminjaman.getTxtTglkembali().setText(peminjaman.getTglkembali());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tampil(){
        try {
            DefaultTableModel tabel = (DefaultTableModel) formPeminjaman.getTblPeminjaman().getModel();
            tabel.setRowCount(0);
            List<Peminjaman> list = peminjamanDao.getAllPeminjaman(connection);
            for (Peminjaman peminjaman1 : list) {
                Object[] row = {
                    peminjaman1.getKodeanggota(),
                    peminjaman1.getKodebuku(),
                    peminjaman1.getTglpinjam(),
                    peminjaman1.getTglkembali()
                };
                tabel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

            
            
            
            
}
