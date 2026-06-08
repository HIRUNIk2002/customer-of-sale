package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
     

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getById(int customerId);

    List<CustomerDTO> getAllCustomers();

    String deleteById(int customerId);


    List<CustomerDTO> getAllCustomersByActiveState(boolean activeState);

    String saveCustomer(CustomerDTO customerDTO);
}
