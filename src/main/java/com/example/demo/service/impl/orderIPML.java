package com.example.demo.service.impl;

import com.example.demo.dto.OrderDetailResponseDTO;
import com.example.demo.dto.OrderResponseDTO;
import com.example.demo.dto.RequestOrderDetailsSaveDTO;
import com.example.demo.dto.RequestOrderSaveDTO;
import com.example.demo.dto.paginated.PaginatedResponseItemDTO;
import com.example.demo.dto.paginated.PaginatedResponseOrderDetails;
import com.example.demo.dto.paginated.ResponseOrderDetailsDTO;
import com.example.demo.dto.queary.OrderDetailsInterface;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetails;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.repo.ItemRepo;
import com.example.demo.repo.OrderDetailsRepo;
import com.example.demo.repo.OrderRepo;
import com.example.demo.service.OrderService;
import com.example.demo.util.mappers.OrderMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.demo.dto.OrderDetailResponseDTO;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class orderIPML implements OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private OrderDetailsRepo orderDetailsRepo;
    @Autowired
    private ItemRepo itemRepo;


    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        // 1. Order එක හදලා save කරනවා
        Order order = new Order();
        order.setCustomer(customerRepo.getReferenceById(requestOrderSaveDTO.getCustomer()));
        order.setDate(requestOrderSaveDTO.getDate());
        order.setTotal(requestOrderSaveDTO.getTotal());
        order.setActiveState(true);

        // save කරපු ගමන් ලැබෙන object එක ගන්න
        Order savedOrder = orderRepo.save(order);

        // 2. මෙන්න මෙතන 'if (existsById)' එක අයින් කරලා මේක දාන්න
        if (savedOrder != null) {
            for (RequestOrderDetailsSaveDTO detailDTO : requestOrderSaveDTO.getOrderDetails()) {
                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setItemName(detailDTO.getItemName());
                orderDetails.setQty(detailDTO.getQty());
                orderDetails.setAmount(detailDTO.getAmount());

                orderDetails.setOrder(savedOrder); // අලුතින් ලැබුණු savedOrder එකම පාවිච්චි කරන්න
                orderDetails.setItem(itemRepo.getReferenceById(detailDTO.getItem()));

                orderDetailsRepo.save(orderDetails);


            }
            return "Saved Order ID: " + savedOrder.getOrderId();
        }

        return "Order Failed";

    }

    @Override
    public PaginatedResponseOrderDetails getAllOrders(boolean status, int page, int size) {
        List<OrderDetailsInterface> responseOrderDetailsDTOS = orderRepo.getAllOrderDetails(status, PageRequest.of(page, size));

        List<ResponseOrderDetailsDTO> list = new ArrayList<>();


        for (OrderDetailsInterface orderDetailsInterface : responseOrderDetailsDTOS) {

            ResponseOrderDetailsDTO responseOrderDetailsDTO = new ResponseOrderDetailsDTO(

                    orderDetailsInterface.getCustomerName(),
                    orderDetailsInterface.getCustomerAddress(),
                    (List<String>) orderDetailsInterface.getCustomerContactNumbers(),
                    orderDetailsInterface.getDate(),
                    orderDetailsInterface.getTotal()
            );

            list.add(responseOrderDetailsDTO);
        }
        long totalCount= orderRepo.countAllOrderDetails(status);
        return new PaginatedResponseOrderDetails(list, totalCount);
    }

    @Override
    public OrderResponseDTO getOrderDetailsById(int orderId) {
        // 1. Database එකේ ඒ ID එක තියෙනවද බලනවා
        if (orderRepo.existsById(orderId)) {
            Order order = orderRepo.getReferenceById(orderId);

            // 2. අයිටම් ටික දාන්න ලිස්ට් එකක් හදනවා
            List<OrderDetailResponseDTO> orderDetailResponseDTOList = new ArrayList<>();

            for (OrderDetails orderDetails : order.getOrderDetails()) {

                // Unit Price එක calculate කරමු (Amount / Qty)
                double calculatedUnitPrice = 0;
                if (orderDetails.getQty() > 0) {
                    calculatedUnitPrice = orderDetails.getAmount() / orderDetails.getQty();
                }

                // DTO එක හදනවා
                OrderDetailResponseDTO orderDetailResponseDTO = new OrderDetailResponseDTO(
                        orderDetails.getItemName(),
                        calculatedUnitPrice, // මෙන්න මෙතනට අර calculate කරපු එක දෙනවා
                        orderDetails.getQty(),
                        orderDetails.getAmount()
                );

                // ලිස්ට් එකට එකතු කරනවා
                orderDetailResponseDTOList.add(orderDetailResponseDTO);
            }

            // 3. අවසානයේ සම්පූර්ණ OrderResponseDTO එක return කරනවා
            return new OrderResponseDTO(
                    order.getOrderId(),
                    order.getCustomer().getCustomerName(), // Customer නම ගන්න
                    order.getDate(),
                    order.getTotal(),
                    orderDetailResponseDTOList
            );
        }
        return null;
    }


}





