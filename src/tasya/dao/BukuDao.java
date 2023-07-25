/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tasya.dao;

import java.sql.Connection;
import tasya.model.Buku;
import java.util.List;

/**
 *
 * @author User
 */
public interface BukuDao {
     void insert(Connection con, Buku buku) throws Exception;
    void update(Connection con, Buku  buku) throws Exception;
    void delete(Connection con, Buku buku) throws Exception;
    public Buku getBuku(Connection con, String kode) throws Exception;
    public List<Buku> getAllBuku(Connection con) throws Exception;
    
}
