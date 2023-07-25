/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts_b.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import uts_b.model.Penjualan;

/**
 *
 * @author User
 */
public class PenjualanDaoImpl extends PenjualanDao {
    
    public void insert(Connection con, Penjualan penjualan)throws Exception {
        String sql = "Insert into anggota values (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, penjualan.getKode());
        ps.setString(2, penjualan.getTgl());
        ps.setString(3, penjualan.getNama());
         ps.setInt(4, penjualan.getTotbayar());
          ps.setInt(5, penjualan.getOngkos());
           ps.setInt(6, penjualan.getDiskon());
         
        
        ps.executeUpdate();
    }
    
    

    public void update(Connection con, Penjualan penjualan) throws Exception {
         String sql = "Update anggota set tgl=?, nama=?, totbayar=?, ongkos=?, diskon=? where kodeanggota=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, penjualan.getKode());
        ps.setString(2, penjualan.getTgl());
        ps.setString(3, penjualan.getNama());
         ps.setInt(4, penjualan.getTotbayar());
          ps.setInt(5, penjualan.getOngkos());
           ps.setInt(6, penjualan.getDiskon());
        ps.executeUpdate();
        
    }
    
  
    
}
