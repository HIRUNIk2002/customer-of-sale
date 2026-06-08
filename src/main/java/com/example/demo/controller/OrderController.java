package com.example.demo.controller;

import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.OrderResponseDTO;
import com.example.demo.dto.RequestOrderSaveDTO;
import com.example.demo.dto.paginated.PaginatedResponseItemDTO;
import com.example.demo.dto.paginated.PaginatedResponseOrderDetails;
import com.example.demo.service.ItemService;
import com.example.demo.service.OrderService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveOrder(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO) {
        String id = orderService.addOrder(requestOrderSaveDTO);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "success", id), HttpStatus.CREATED
        );
        return responseEntity;
    }


    @GetMapping(
            path="/get-order-details-by-id",
            params = "id"
    )
    public ResponseEntity<StandardResponse>  getOrderDetailsById(@RequestParam(value="id") int orderId){
        OrderResponseDTO orderResponseDTO=orderService.getOrderDetailsById(orderId);
        ResponseEntity<StandardResponse> responseEntity=new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",orderResponseDTO),HttpStatus.OK
        );
        return responseEntity;
    }


    @GetMapping(
            path = "/get-order-details",
            params = {"stateType", "page", "size"}
    )
    public ResponseEntity<StandardResponse> getAllOrderDetails(
            @RequestParam(value = "stateType") String stateType,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        // 1. මුලින්ම status එක හරියට තීරණය කරමු
        boolean status;
        if (stateType.equalsIgnoreCase("active")) {
            status = true;
        } else if (stateType.equalsIgnoreCase("inactive")) {
            status = false;
        } else {
            // active හෝ inactive නෙවෙයි නම් මෙතනින්ම වැරැද්ද කියනවා
            return new ResponseEntity<>(
                    new StandardResponse(400, "Invalid stateType. Use 'active' or 'inactive'.", null),
                    HttpStatus.BAD_REQUEST
            );
        }

        // 2. Service එකට ගිහින් දත්ත අරන් එමු
        PaginatedResponseOrderDetails result = orderService.getAllOrders(status, page, size);

        // 3. Response එක යවමු
        return new ResponseEntity<>(
                new StandardResponse(200, "Successfully got it", result),
                HttpStatus.OK
        );
    }
}
