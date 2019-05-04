package com.vm.entity;
// Generated May 4, 2019 7:35:30 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PenjualanHasItemId generated by hbm2java
 */
@Embeddable
public class PenjualanHasItemId  implements java.io.Serializable {


     private int penjualanIdPenjualan;
     private int itemIdItem;
     private int penjualanHasItemId;

    public PenjualanHasItemId() {
    }

    public PenjualanHasItemId(int penjualanIdPenjualan, int itemIdItem, int penjualanHasItemId) {
       this.penjualanIdPenjualan = penjualanIdPenjualan;
       this.itemIdItem = itemIdItem;
       this.penjualanHasItemId = penjualanHasItemId;
    }
   


    @Column(name="Penjualan_idPenjualan", nullable=false)
    public int getPenjualanIdPenjualan() {
        return this.penjualanIdPenjualan;
    }
    
    public void setPenjualanIdPenjualan(int penjualanIdPenjualan) {
        this.penjualanIdPenjualan = penjualanIdPenjualan;
    }


    @Column(name="Item_idItem", nullable=false)
    public int getItemIdItem() {
        return this.itemIdItem;
    }
    
    public void setItemIdItem(int itemIdItem) {
        this.itemIdItem = itemIdItem;
    }


    @Column(name="Penjualan_has_ItemId", nullable=false)
    public int getPenjualanHasItemId() {
        return this.penjualanHasItemId;
    }
    
    public void setPenjualanHasItemId(int penjualanHasItemId) {
        this.penjualanHasItemId = penjualanHasItemId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PenjualanHasItemId) ) return false;
		 PenjualanHasItemId castOther = ( PenjualanHasItemId ) other; 
         
		 return (this.getPenjualanIdPenjualan()==castOther.getPenjualanIdPenjualan())
 && (this.getItemIdItem()==castOther.getItemIdItem())
 && (this.getPenjualanHasItemId()==castOther.getPenjualanHasItemId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getPenjualanIdPenjualan();
         result = 37 * result + this.getItemIdItem();
         result = 37 * result + this.getPenjualanHasItemId();
         return result;
   }   


}

