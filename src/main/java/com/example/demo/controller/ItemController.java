package com.example.demo.controller;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.ItemResponseDTO;
import com.example.demo.dto.ItemUpdateDTO;
import com.example.demo.dto.paginated.PaginatedResponseItemDTO;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ItemService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

//    @PostMapping("/save")
//    public String saveCustomer(@RequestBody ItemDTO itemDTO) {
//        itemService.saveItem(itemDTO);
//        return "saved";
//    }

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemDTO itemDTO) {
        String message = itemService.saveItem(itemDTO);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "success", message), HttpStatus.CREATED
        );
        return responseEntity;
    }

    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public  ResponseEntity<StandardResponse> getItemByNameAndActiveState(@RequestParam(value = "name") String itemName) {
        List<ItemResponseDTO> itemResponseDTOS = itemService.getItemByNameAndActiveState(itemName);
        ResponseEntity<StandardResponse>responseEntity=new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"successfully got it",itemResponseDTOS),HttpStatus.OK
        );
        return responseEntity;

    }

//    @GetMapping(
//            path = "/get-by-name-with-mapstruct",
//            params = "name"
//    )
//    public ResponseEntity<StandardResponse>  getItemByNameAndActiveStateByMapstruct(@RequestParam(value = "name") String itemName) {
//        List<ItemResponseDTO> itemResponseDTOS = itemService.getItemByNameAndActiveStateByMapstruct(itemName);
//        ResponseEntity<StandardResponse> responseEntity=new ResponseEntity<StandardResponse>(
//                new StandardResponse(200,"successfully got it",itemResponseDTOS),HttpStatus.OK
//        );
//        return  responseEntity;
//
//    }

    @GetMapping(
            path = "/get-all-item-by-state",
            params = "activeState"
    )
    public ResponseEntity<StandardResponse> getItemByActiveState(@RequestParam(value = "activeState") Boolean activeState) {
        List<ItemResponseDTO> itemResponseDTOS = itemService.getItemByActiveState(activeState);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Successfully got it", itemResponseDTOS), HttpStatus.OK
        );
        return responseEntity;
    }
    @PutMapping("/update")
    public ResponseEntity<StandardResponse>   updateItem(@RequestBody ItemUpdateDTO itemUpdateDTO){
        String update=itemService.updateItem(itemUpdateDTO);
        ResponseEntity<StandardResponse> responseEntity=new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"successfully updated",update),HttpStatus.CREATED
        );
        return responseEntity;
    }
    @DeleteMapping(
            path = "/delete-by-id",
            params = "id"
    )
    public ResponseEntity<StandardResponse> deleteItemById(@RequestParam(value = "id") int itemId){
        String delete=itemService.deleteItemById(itemId);
        ResponseEntity<StandardResponse> responseEntity=new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"successfully deleted",delete),HttpStatus.OK
        );
        return responseEntity;
    }

    @GetMapping(
            path = "/get-all-item-by-state",
            params = {"activeState", "page", "size"}
    )
    public ResponseEntity<StandardResponse> getItemByActiveStateWithPaginated(
            @RequestParam(value = "activeState") boolean activeState,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size
    ) {
//        List<ItemResponseDTO> itemResponseDTOS=itemService.getItemByActiveState(activeState,page,size);
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getItemByActiveStateWithPaginated(activeState, page, size);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Successfully got it", paginatedResponseItemDTO), HttpStatus.OK
        );
        return responseEntity;
    }

}