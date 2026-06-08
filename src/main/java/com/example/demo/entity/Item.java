package com.example.demo.entity;

import com.example.demo.entity.enums.MeasuringUnitType;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="Item")


public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id",length = 45)
    private int itemId;

    @Column(name = "item_name",length = 100,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measuring_type",length = 100,nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name = "balance_qty",length = 100,nullable = false)
    private double balanceQty;

    @Column(name = "supplier_price",length = 100,nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price",length = 100,nullable = false)
    private double sellingPrice;

    @Column(name = "active_state",columnDefinition = "TINYINT default 0")
    private boolean activeState;

    @OneToMany(mappedBy ="item")
    private Set<OrderDetails> orderDetails;


    public Item() {
    }

    public Item(int itemId, String itemName, MeasuringUnitType measuringUnitType, double balanceQty, double supplierPrice, double sellingPrice, boolean activeState, Set<OrderDetails> orderDetails) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.measuringUnitType = measuringUnitType;
        this.balanceQty = balanceQty;
        this.supplierPrice = supplierPrice;
        this.sellingPrice = sellingPrice;
        this.activeState = activeState;
        this.orderDetails = orderDetails;
    }

    public Item(int itemId, String itemName, MeasuringUnitType measuringUnitType, double balanceQty, double supplierPrice, double sellingPrice, boolean activeState) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.measuringUnitType = measuringUnitType;
        this.balanceQty = balanceQty;
        this.supplierPrice = supplierPrice;
        this.sellingPrice = sellingPrice;
        this.activeState = activeState;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public MeasuringUnitType getMeasuringUnitType() {
        return measuringUnitType;
    }

    public void setMeasuringUnitType(MeasuringUnitType measuringUnitType) {
        this.measuringUnitType = measuringUnitType;
    }

    public double getBalanceQty() {
        return balanceQty;
    }

    public void setBalanceQty(double balanceQty) {
        this.balanceQty = balanceQty;
    }

    public double getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(double supplierPrice) {
        this.supplierPrice = supplierPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public boolean isActiveState() {
        return activeState;
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }

    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", measuringUnitType=" + measuringUnitType +
                ", balanceQty=" + balanceQty +
                ", supplierPrice=" + supplierPrice +
                ", sellingPrice=" + sellingPrice +
                ", activeState=" + activeState +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
