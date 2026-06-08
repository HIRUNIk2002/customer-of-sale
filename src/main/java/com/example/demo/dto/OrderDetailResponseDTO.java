package com.example.demo.dto;

public class OrderDetailResponseDTO {
    private String itemName;
    private double unitPrice;
    private double qty;
    private double amount;

    public OrderDetailResponseDTO() {
    }

    public OrderDetailResponseDTO(String itemName, double unitPrice, double qty, double amount) {
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.amount = amount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderDetailResponseDTO{" +
                "itemName='" + itemName + '\'' +
                ", unitPrice=" + unitPrice +
                ", qty=" + qty +
                ", amount=" + amount +
                '}';
    }
}
