/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tasya.dao;

import java.sql.Connection;
import java.util.List;
import tasya.model.Peminjaman;

/**
 *
 * @author User
 */
public interface PeminjamanDao {
    public void insert(Connection con, Peminjaman peminjaman) throws Exception;
    public void update(Connection con, Peminjaman peminjaman) throws Exception;
    public void delete(Connection con, Peminjaman peminjaman) throws Exception;
    public Peminjaman getPeminjaman(Connection con, String kodeanggota, String kodebuku, String tglpinjam) throws Exception;
    public List<Peminjaman> getAllPeminjaman(Connection con) throws Exception;
}
