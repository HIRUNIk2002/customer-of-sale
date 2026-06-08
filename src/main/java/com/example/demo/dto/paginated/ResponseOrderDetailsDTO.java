package com.example.demo.dto.paginated;

import java.util.Date;
import java.util.List;

public class ResponseOrderDetailsDTO {
//    customer
    private String customerName;
    private String customerAddress;
    private List<String> contactNumbers;

//    order
    private Date date;
    private   Double total;

    public ResponseOrderDetailsDTO() {
    }

    public ResponseOrderDetailsDTO(String customerName, String customerAddress, List<String> contactNumbers, Date date, Double total) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.contactNumbers = contactNumbers;
        this.date = date;
        this.total = total;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<String> getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(List<String> contactNumbers) {
        this.contactNumbers = contactNumbers;
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

    @Override
    public String toString() {
        return "ResponseOrderDetailsDTO{" +
                "customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", contactNumbers=" + contactNumbers +
                ", date=" + date +
                ", total=" + total +
                '}';
    }
}
