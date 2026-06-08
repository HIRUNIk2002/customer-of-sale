package com.example.demo.dto.paginated;

import com.example.demo.dto.ItemResponseDTO;

import java.util.List;


public class PaginatedResponseItemDTO {
List<ItemResponseDTO> list;
private long dataCount;

    public PaginatedResponseItemDTO() {
    }

    public PaginatedResponseItemDTO(List<ItemResponseDTO> list, long dataCount) {
        this.list = list;
        this.dataCount = dataCount;
    }

    public List<ItemResponseDTO> getList() {
        return list;
    }

    public void setList(List<ItemResponseDTO> list) {
        this.list = list;
    }

    public long getDataCount() {
        return dataCount;
    }

    public void setDataCount(long dataCount) {
        this.dataCount = dataCount;
    }

    @Override
    public String toString() {
        return "PaginatedResponseItemDTO{" +
                "list=" + list +
                ", dataCount=" + dataCount +
                '}';
    }
}
