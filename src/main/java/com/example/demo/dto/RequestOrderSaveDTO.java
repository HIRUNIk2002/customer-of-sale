package com.example.demo.dto;

import com.example.demo.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class RequestOrderSaveDTO {
    private  int customer;
    private Date date;
    private   Double total;
    private List<RequestOrderDetailsSaveDTO> orderDetails;

    public RequestOrderSaveDTO() {
    }

    public RequestOrderSaveDTO(int customer, Date date, Double total, List<RequestOrderDetailsSaveDTO> orderDetails) {
        this.customer = customer;
        this.date = date;
        this.total = total;
        this.orderDetails = orderDetails;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
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

    public List<RequestOrderDetailsSaveDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<RequestOrderDetailsSaveDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "RequestOrderSaveDTO{" +
                "customer=" + customer +
                ", date=" + date +
                ", total=" + total +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
