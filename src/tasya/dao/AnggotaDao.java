/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasya.dao;

import java.sql.Connection;
import tasya.model.Anggota;
import java.util.List;

/**
 *
 * @author User
 */
public interface AnggotaDao {
   void insert(Connection con, Anggota anggota) throws Exception;
    void update(Connection con, Anggota anggota) throws Exception;
    void delete(Connection con, Anggota anggota) throws Exception;
    public Anggota getAnggota(Connection con, String Kode) throws Exception;
    public List<Anggota> getAllAnggota(Connection con) throws Exception;
}
