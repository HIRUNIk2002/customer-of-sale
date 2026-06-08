package com.example.demo.service;

import com.example.demo.dto.OrderResponseDTO;
import com.example.demo.dto.RequestOrderSaveDTO;
import com.example.demo.dto.paginated.PaginatedResponseOrderDetails;

public interface OrderService {


     String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);

     PaginatedResponseOrderDetails getAllOrders(boolean status, int page, int size);


    OrderResponseDTO getOrderDetailsById(int orderId);
}
