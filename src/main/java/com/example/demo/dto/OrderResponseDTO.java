package com.example.demo.dto;

import java.util.Date;
import java.util.List;

public class OrderResponseDTO {
    private int orderId;
    private String customerName; // Customer table එක join කරලා තියෙනවා නම්
    private Date date;
    private double total;

    // මේක තමයි වැදගත්ම කොටස - අයිටම් ටික මේ ලිස්ට් එකට එනවා
    private List<OrderDetailResponseDTO> orderDetails;

    public OrderResponseDTO() {
    }

    public OrderResponseDTO(int orderId, String customerName, Date date, double total, List<OrderDetailResponseDTO> orderDetails) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.date = date;
        this.total = total;
        this.orderDetails = orderDetails;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<OrderDetailResponseDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailResponseDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "OrderResponseDTO{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", date=" + date +
                ", total=" + total +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
