package com.example.demo.repo;

import com.example.demo.dto.paginated.ResponseOrderDetailsDTO;
import com.example.demo.dto.queary.OrderDetailsInterface;
import com.example.demo.entity.Item;
import com.example.demo.entity.Order;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@EnableJpaRepositories
@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {
@Query(value = "select c.customer_name as customerName ,c.customer_address as customerAddress, " +
        "c.customer_contact_numbers as customerContactNumbers ,o.order_date as date,o.total as total  from customer c,orders o where o.active_state=?1 and c.customer_id=o.customer_id",nativeQuery = true)
List<OrderDetailsInterface>getAllOrderDetails(boolean status, Pageable pageable );

@Query(value = "select count(*) from customer c,orders o where o.active_state=?1 and c.customer_id=o.customer_id",nativeQuery = true)
    Long countAllOrderDetails(boolean status);
}
