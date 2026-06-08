package com.example.demo.service;

import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.ItemResponseDTO;
import com.example.demo.dto.ItemUpdateDTO;
import com.example.demo.dto.paginated.PaginatedResponseItemDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemDTO itemDTO);

    List<ItemResponseDTO> getItemByNameAndActiveState(String itemName);

//    List<ItemResponseDTO> getItemByNameAndActiveStateByMapstruct(String itemName);

    List<ItemResponseDTO> getItemByActiveState(Boolean activeState);

    PaginatedResponseItemDTO getItemByActiveStateWithPaginated(boolean activeState, int page, int size);

    String updateItem(ItemUpdateDTO itemUpdateDTO);

    String deleteItemById(int itemId);
}
