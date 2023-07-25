/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts_b.model;

/**
 *
 * @author User
 */
public class Penjualan {
    
    private String kode;
    private String tgl;
    private String nama;
    private int totbayar;
    private int ongkos;
    private int diskon;
    

    public Penjualan() {
    }

    public Penjualan(String kode, String nama, String tgl, int totbayar, int ongkos, int diskon) {
        this.kode = kode;
        this.nama = nama;
        this.tgl = tgl;
        this.totbayar = totbayar;
        this.ongkos = ongkos;
        this.diskon = diskon;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getTotbayar() {
        return totbayar;
    }

    public void setTotbayar(int totbayar) {
        this.totbayar = totbayar;
    }

    public int getOngkos() {
        return ongkos;
    }

    public void setOngkos(int ongkos) {
        this.ongkos = ongkos;
    }

    public int getDiskon() {
        return diskon;
    }

    public void setDiskon(int diskon) {
        this.diskon = diskon;
    }
    
    
    
}
