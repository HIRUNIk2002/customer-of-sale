package com.example.demo.controller;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.CustomerUpdateDTO;
import com.example.demo.service.CustomerService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        String messages=customerService.saveCustomer(customerDTO);
        ResponseEntity<StandardResponse> responseEntity=new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"success",messages),HttpStatus.CREATED
        );
        return responseEntity;
    }

     @PutMapping ("/update")
    public  ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        String update1=customerService.updateCustomer(customerUpdateDTO);
        ResponseEntity<StandardResponse> responseEntity=new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"updated",update1),HttpStatus.CREATED
        );
        return responseEntity ;
    }
    @GetMapping(
            path = "/get-by-id",
            params="id"
    )
    public  ResponseEntity<StandardResponse> getById(@RequestParam(value = "id")int customerId){
       CustomerDTO customerDTO  =customerService.getById(customerId);
       ResponseEntity<StandardResponse> responseEntity=new ResponseEntity<StandardResponse>(
               new StandardResponse(200,"success",customerDTO),HttpStatus.OK
        );
        return responseEntity;
    }
//    @GetMapping(
//            path = "/get-all-customers"
//    )
//    public List<CustomerDTO> getAllCustomers(){
//        List<CustomerDTO> allCustomers=customerService.getAllCustomers();
//        return allCustomers;
//    }

    @GetMapping(
            path = "/get-all-customers"
    )
    public ResponseEntity<StandardResponse> getAllCustomers(){
    List<CustomerDTO> allCustomers=customerService.getAllCustomers();
     ResponseEntity <StandardResponse> responseEntity=new ResponseEntity<StandardResponse>(
             new StandardResponse(200,"success",allCustomers), HttpStatus.OK
     );
        return  responseEntity;
    }


    @DeleteMapping(
            path="/delete-by-id",
            params="id"
    )
    public  ResponseEntity<StandardResponse> deleteById(@RequestParam(value ="id" )int customerId){
      String delete=customerService.deleteById(customerId);
      ResponseEntity<StandardResponse> responseEntity=new ResponseEntity<StandardResponse>(
              new StandardResponse(200,"deleted",delete),HttpStatus.OK
      );
      return  responseEntity;
    }
//    @GetMapping(
//            path = "/get-all-customers-by-active-state/{status}"
//    )
//    public List<CustomerDTO> getAllCustomersByActiveState(@PathVariable(value = "status") boolean activeState){
//        List<CustomerDTO> allCustomers=customerService.getAllCustomersByActiveState(activeState);
//        return allCustomers;
//
//    }

    @GetMapping(
            path = "/get-all-customers-by-active-state/{status}"
    )
    public  ResponseEntity<StandardResponse> getAllCustomersByActiveState(@PathVariable(value = "status") boolean activeState){
        List<CustomerDTO> allCustomers=customerService.getAllCustomersByActiveState(activeState);
        ResponseEntity<StandardResponse> responseEntity=new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Successfully got it",allCustomers),HttpStatus.OK
        );
        return responseEntity;

    }
}
