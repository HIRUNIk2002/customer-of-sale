package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="order_details")

public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_details_id",length = 45)
    private int orderDetailsId;

    @Column(name = "item_name",length = 100,nullable = false)
    private String itemName;

    @Column(name = "qty",length = 100,nullable = false)
    private double  qty;

    @Column(name = "amount",nullable = false)
    private  double amount;

    @ManyToOne
    @JoinColumn(name = "item_id",nullable = false)
    private  Item item;


    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private  Order order;

    public OrderDetails() {
    }

    public OrderDetails(int orderDetailsId, String itemName, double qty, double amount, Item item, Order order) {
        this.orderDetailsId = orderDetailsId;
        this.itemName = itemName;
        this.qty = qty;
        this.amount = amount;
        this.item = item;
        this.order = order;
    }

    public int getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(int orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderDetailsId=" + orderDetailsId +
                ", itemName='" + itemName + '\'' +
                ", qty=" + qty +
                ", amount=" + amount +

                '}';
    }
}
