package com.example.demo.repo;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Customer findById(int customerId);




    List<Customer> findAllByActiveStateEquals(boolean activeState);
}
