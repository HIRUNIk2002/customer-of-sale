package com.example.demo.dto;

import com.example.demo.entity.enums.MeasuringUnitType;

public class ItemUpdateDTO {
    private int itemId;
    private String itemName;
    private double balanceQty;
    private double sellingPrice;

    public ItemUpdateDTO() {
    }

    public ItemUpdateDTO(int itemId, String itemName, double balanceQty, double sellingPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.balanceQty = balanceQty;
        this.sellingPrice = sellingPrice;
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

    public double getBalanceQty() {
        return balanceQty;
    }

    public void setBalanceQty(double balanceQty) {
        this.balanceQty = balanceQty;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @Override
    public String toString() {
        return "ItemUpdateDTO{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", balanceQty=" + balanceQty +
                ", sellingPrice=" + sellingPrice +
                '}';
    }
}
