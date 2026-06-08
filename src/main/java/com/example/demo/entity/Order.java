package com.example.demo.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name ="orders")
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id",length = 45)
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private   Customer customer;

    @Column(name = "order_date",columnDefinition = "DATETIME")
    private Date date;

    @Column(name = "total",nullable = false)
    private  Double total;

    @Column(name = "active_state",columnDefinition = "TINYINT default 0")
    private boolean activeState;

    @OneToMany(mappedBy ="order")
    private Set<OrderDetails> orderDetails;

    public Order() {
    }

    public Order(int orderId, Customer customer, Date date, Double total, boolean activeState, Set<OrderDetails> orderDetails) {
        this.orderId = orderId;
        this.customer = customer;
        this.date = date;
        this.total = total;
        this.activeState = activeState;
        this.orderDetails = orderDetails;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", date=" + date +
                ", total=" + total +
                ", activeState=" + activeState +

                '}';
    }
}
