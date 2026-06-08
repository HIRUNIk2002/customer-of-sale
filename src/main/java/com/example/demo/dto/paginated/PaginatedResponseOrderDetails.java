package com.example.demo.dto.paginated;

import java.util.List;

public class PaginatedResponseOrderDetails {
    private List<ResponseOrderDetailsDTO> list;
    private Long dataCount;

    public PaginatedResponseOrderDetails() {
    }

    public PaginatedResponseOrderDetails(List<ResponseOrderDetailsDTO> list, Long dataCount) {
        this.list = list;
        this.dataCount = dataCount;
    }

    public List<ResponseOrderDetailsDTO> getList() {
        return list;
    }

    public void setList(List<ResponseOrderDetailsDTO> list) {
        this.list = list;
    }

    public Long getDataCount() {
        return dataCount;
    }

    public void setDataCount(Long dataCount) {
        this.dataCount = dataCount;
    }

    @Override
    public String toString() {
        return "PaginatedResponseOrderDetails{" +
                "list=" + list +
                ", dataCount=" + dataCount +
                '}';
    }
}
