package com.jolipjo.lovebridge.domain.paginaition.dto;

import java.util.List;

public class PaginationDTO<T> {

    private int currentPage;
    private int pageSize;
    private int totalItems;
    private List<T> items;

    public PaginationDTO() {}

    public PaginationDTO(int currentPage, int pageSize, int totalItems, List<T> items) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalItems = totalItems;
        this.items = items;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "PaginationDTO{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalItems=" + totalItems +
                ", items=" + items +
                '}';
    }
}
