package com.example.demo.dto;

import com.example.demo.entity.Item;
import com.example.demo.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


public class RequestOrderDetailsSaveDTO {

    private String itemName;
    private double  qty;
    private  double amount;
    private  int Item;


    public RequestOrderDetailsSaveDTO() {
    }

    public RequestOrderDetailsSaveDTO(String itemName, double qty, double amount, int item) {
        this.itemName = itemName;
        this.qty = qty;
        this.amount = amount;
        Item = item;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public int getItem() {
        return Item;
    }

    public void setItem(int item) {
        Item = item;
    }

    @Override
    public String toString() {
        return "RequestOrderDetailsSaveDTO{" +
                "itemName='" + itemName + '\'' +
                ", qty=" + qty +
                ", amount=" + amount +
                ", Item=" + Item +
                '}';
    }
}
