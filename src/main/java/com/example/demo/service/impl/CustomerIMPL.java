package com.example.demo.service.impl;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.CustomerUpdateDTO;
import com.example.demo.entity.Customer;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;


    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName();
        } else {
            throw new NotFoundException("no data found");
        }
    }

    @Override
    public CustomerDTO getById(int customerId) {
        if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.findById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumbers(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.isActiveState()

            );
            return customerDTO;
        } else {
            throw new NotFoundException("no data found in that id" );
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        // 1. DB එකේ ඉන්න ඔක්කොම Entity ලිස්ට් එක ගන්නවා
        List<Customer> getAllCustomers = customerRepo.findAll();
        // 2. ඒ හැම Entity එකක්ම DTO එකකට හරවලා අලුත් ලිස්ට් එකකට දානවා
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer : getAllCustomers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumbers(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.isActiveState()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;

    }

    @Override
    public String deleteById(int customerId) {
        if (customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
            return "deleted successfully" + customerId;

        } else {
            throw new NotFoundException("delete unsuccessfully");

        }

    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean activeState) {
        List<Customer> getAllCustomers = customerRepo.findAllByActiveStateEquals(activeState);
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : getAllCustomers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumbers(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.isActiveState()
            );
            customerDTOList.add(customerDTO);
        }
            return customerDTOList;
    }

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer=new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getContactNumbers(),
                customerDTO.getCustomerSalary(),
                customerDTO.getNic(),
                customerDTO.isActiveState()
        );
        customerRepo.save(customer);
        return customerDTO.getCustomerName();
    }
}

