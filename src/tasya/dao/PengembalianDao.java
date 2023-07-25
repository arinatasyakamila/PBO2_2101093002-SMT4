/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tasya.dao;

import java.sql.Connection;
import java.util.List;
import tasya.model.Pengembalian;

/**
 *
 * @author User
 */
public interface PengembalianDao {
    public void insert(Connection con, Pengembalian pengembalian) throws Exception;
    public void update(Connection con, Pengembalian pengembalian) throws Exception;
    public void delete(Connection con, Pengembalian pengembalian) throws Exception;
    public Pengembalian getPengembalian(Connection con, String kodeanggota, String kodebuku, String tglpinjam) throws Exception;
    public List<Pengembalian> getAllPengembalian(Connection con) throws Exception;
    public int selisihTanggal(Connection con, String tgl1, String tgl2) throws Exception;
    
}
