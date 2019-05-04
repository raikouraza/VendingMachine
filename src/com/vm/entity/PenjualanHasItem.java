package com.vm.entity;
// Generated May 4, 2019 7:35:30 PM by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PenjualanHasItem generated by hbm2java
 */
@Entity
@Table(name="penjualan_has_item"
    ,catalog="mydb"
)
public class PenjualanHasItem  implements java.io.Serializable {


     private PenjualanHasItemId id;
     private Item item;
     private Penjualan penjualan;
     private int quantity;
     private int harga;

    public PenjualanHasItem() {
    }

    public PenjualanHasItem(PenjualanHasItemId id, Item item, Penjualan penjualan, int quantity, int harga) {
       this.id = id;
       this.item = item;
       this.penjualan = penjualan;
       this.quantity = quantity;
       this.harga = harga;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="penjualanIdPenjualan", column=@Column(name="Penjualan_idPenjualan", nullable=false) ), 
        @AttributeOverride(name="itemIdItem", column=@Column(name="Item_idItem", nullable=false) ), 
        @AttributeOverride(name="penjualanHasItemId", column=@Column(name="Penjualan_has_ItemId", nullable=false) ) } )
    public PenjualanHasItemId getId() {
        return this.id;
    }
    
    public void setId(PenjualanHasItemId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Item_idItem", nullable=false, insertable=false, updatable=false)
    public Item getItem() {
        return this.item;
    }
    
    public void setItem(Item item) {
        this.item = item;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Penjualan_idPenjualan", nullable=false, insertable=false, updatable=false)
    public Penjualan getPenjualan() {
        return this.penjualan;
    }
    
    public void setPenjualan(Penjualan penjualan) {
        this.penjualan = penjualan;
    }

    
    @Column(name="quantity", nullable=false)
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    @Column(name="harga", nullable=false)
    public int getHarga() {
        return this.harga;
    }
    
    public void setHarga(int harga) {
        this.harga = harga;
    }




}

