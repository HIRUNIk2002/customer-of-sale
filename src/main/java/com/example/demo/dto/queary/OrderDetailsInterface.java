package com.example.demo.dto.queary;

import java.util.List;

import java.util.Date;

public interface OrderDetailsInterface {
    String getCustomerName();
    String getCustomerAddress();
    List getCustomerContactNumbers();
    Date getDate();
    Double getTotal();

}
