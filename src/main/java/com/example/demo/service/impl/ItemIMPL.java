package com.example.demo.service.impl;

import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.ItemResponseDTO;
import com.example.demo.dto.ItemUpdateDTO;
import com.example.demo.dto.paginated.PaginatedResponseItemDTO;
import com.example.demo.entity.Item;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repo.ItemRepo;
import com.example.demo.service.ItemService;
import com.example.demo.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;



    @Override
    public String saveItem(ItemDTO itemDTO) {
    Item item =new Item(
            itemDTO.getItemId(),
            itemDTO.getItemName(),
            itemDTO.getMeasuringUnitType(),
            itemDTO.getBalanceQty(),
            itemDTO.getSupplierPrice(),
            itemDTO.getSellingPrice(),
            itemDTO.isActiveState()
    );
    itemRepo.save(item);
    return itemDTO.getItemName();
    }

    @Override
    public List<ItemResponseDTO> getItemByNameAndActiveState(String itemName) {
        boolean b = true;

        // 1. Repository එකෙන් Item (Entity) ලිස්ට් එකක් ගන්නවා
        List<Item> items = itemRepo.findAllByItemNameAndActiveState(itemName, b);

        // 2. දත්ත තියෙනවා නම් විතරක් ඉස්සරහට යනවා
        if (items.size() > 0) {
            // 3. අපි ආපහු යවන්න ඕන DTO ලිස්ට් එක මෙතන හදාගන්නවා
            List<ItemResponseDTO> itemResponseDTOS = new ArrayList<>();

            // 4. Entity ලිස්ට් එක ලූප් කරලා එකින් එක අරන් DTO එකකට දත්ත ටික අතින් පුරවනවා
            for (Item item : items) {
                ItemResponseDTO itemResponseDTO = new ItemResponseDTO(
                   item.getItemId(),
                   item.getItemName(),
                   item.getBalanceQty(),
                   item.getSupplierPrice(),
                   item.getSellingPrice(),
                   item.isActiveState()

                );
                // 5. හදාගත්ත DTO එක ලිස්ට් එකට දානවා
                itemResponseDTOS.add(itemResponseDTO);
            }

            return itemResponseDTOS;

        } else {
            // 6. දත්ත නැත්නම් Exception එකක් දෙනවා
            throw new NotFoundException("Not Found item");
        }
    }



    @Override
    public List<ItemResponseDTO> getItemByActiveState(Boolean activeState) {
      List<Item> items=itemRepo.findAllByActiveStateEquals( activeState);
      List<ItemResponseDTO> itemResponseDTOList=new ArrayList<>();

      for (Item item:items){
          ItemResponseDTO itemResponseDTO=new ItemResponseDTO(
                  item.getItemId(),
                  item.getItemName(),
                  item.getBalanceQty(),
                  item.getSupplierPrice(),
                  item.getSellingPrice(),
                  item.isActiveState()

          );
          itemResponseDTOList.add(itemResponseDTO);
      }
      return itemResponseDTOList;

    }



    @Override
    public PaginatedResponseItemDTO getItemByActiveStateWithPaginated(boolean activeState, int page, int size) {

        // 1. Database එකෙන් දත්ත පිටුව ගන්නවා
        Page<Item> itemPage = itemRepo.findAllByActiveStateEquals(activeState, PageRequest.of(page, size));

        // 2. දත්ත නැත්නම් Error එකක් දෙනවා
        if (itemPage.isEmpty()) {
            throw new NotFoundException("දත්ත කිසිවක් හමු නොවීය!");
        }

        // 3. Item (Entity) ටික ItemResponseDTO බවට හරවන්න හිස් List එකක් හදාගන්නවා
        List<ItemResponseDTO> dtoList = new ArrayList<>();

        // 4. Loop එකක් දාලා එකින් එක Item එක අරන් DTO එකට දානවා
        for (Item item : itemPage.getContent()) {
            ItemResponseDTO dto = new ItemResponseDTO(
                    item.getItemId(),
                    item.getItemName(),
                    item.getBalanceQty(),    // Entity එකේ qtyOnHand -> DTO එකේ balanceQty
                    item.getSupplierPrice(),    // Entity එකේ unitPrice -> DTO එකේ supplierPrice
                    item.getSellingPrice(),
                    item.isActiveState()
            );
            dtoList.add(dto);
        }

        // 5. අවසාන Response එක හදලා යවනවා
        return new PaginatedResponseItemDTO(
                dtoList,
                itemPage.getTotalElements()
        );
    }

    @Override
    public String updateItem(ItemUpdateDTO itemUpdateDTO) {
        if (itemRepo.existsById(itemUpdateDTO.getItemId())){
            Item item=itemRepo.getReferenceById(itemUpdateDTO.getItemId());
            item.setItemName(itemUpdateDTO.getItemName());
            item.setBalanceQty(itemUpdateDTO.getBalanceQty());
            item.setSellingPrice(item.getSellingPrice());

            itemRepo.save(item);
            return itemUpdateDTO.getItemName();
        }else {
            throw new NotFoundException("update unsuccessfully");
        }

    }

    @Override
    public String deleteItemById(int itemId) {
        if (itemRepo.existsById(itemId)){
            itemRepo.deleteById(itemId);
            return "successfully deleted " + itemId;
        }else {
            throw new NotFoundException("already updated");
        }

    }
}
