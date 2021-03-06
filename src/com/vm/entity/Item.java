package com.vm.entity;
// Generated May 5, 2019 5:32:06 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Item generated by hbm2java
 */
@Entity
@Table(name="item"
    ,catalog="mydb"
)
public class Item  implements java.io.Serializable {


     private Integer idItem;
     private byte jenis;
     private String nama;
     private int harga;
     private String gambar;
     private Integer stock;
     private Set<PenjualanHasItem> penjualanHasItems = new HashSet<PenjualanHasItem>(0);

    public Item() {
    }

	
    public Item(byte jenis, String nama, int harga, String gambar) {
        this.jenis = jenis;
        this.nama = nama;
        this.harga = harga;
        this.gambar = gambar;
    }
    public Item(byte jenis, String nama, int harga, String gambar, Integer stock, Set<PenjualanHasItem> penjualanHasItems) {
       this.jenis = jenis;
       this.nama = nama;
       this.harga = harga;
       this.gambar = gambar;
       this.stock = stock;
       this.penjualanHasItems = penjualanHasItems;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idItem", unique=true, nullable=false)
    public Integer getIdItem() {
        return this.idItem;
    }
    
    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    
    @Column(name="Jenis", nullable=false)
    public byte getJenis() {
        return this.jenis;
    }
    
    public void setJenis(byte jenis) {
        this.jenis = jenis;
    }

    
    @Column(name="Nama", nullable=false, length=50)
    public String getNama() {
        return this.nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }

    
    @Column(name="Harga", nullable=false)
    public int getHarga() {
        return this.harga;
    }
    
    public void setHarga(int harga) {
        this.harga = harga;
    }

    
    @Column(name="gambar", nullable=false, length=100)
    public String getGambar() {
        return this.gambar;
    }
    
    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    
    @Column(name="Stock")
    public Integer getStock() {
        return this.stock;
    }
    
    public void setStock(Integer stock) {
        this.stock = stock;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="item")
    public Set<PenjualanHasItem> getPenjualanHasItems() {
        return this.penjualanHasItems;
    }
    
    public void setPenjualanHasItems(Set<PenjualanHasItem> penjualanHasItems) {
        this.penjualanHasItems = penjualanHasItems;
    }




}


