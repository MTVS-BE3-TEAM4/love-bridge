package com.jolipjo.lovebridge.domain.paginaition.dto;

import java.util.List;

public class PaginationDTO<T> {

    private int currentPage;
    private int pageSize;
    private int totalItems;
    private int totalPages;
    private boolean hasNextPage;
    private boolean hasPreviousPage;
    private List<T> items;
    private String sortOrder;

    public PaginationDTO() {}

    public PaginationDTO(int currentPage, int pageSize, List<T> items, int totalItems) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalItems = totalItems;
        this.totalPages = (int) Math.ceil((double) totalItems / pageSize);
        this.hasNextPage = currentPage < totalPages;
        this.hasPreviousPage = currentPage > 1;
        setItems(items); // 초기화 시 아이템 설정
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        this.hasPreviousPage = currentPage > 1;
        this.hasNextPage = currentPage < totalPages;
        updateItems(); // 페이지 변경 시 아이템 업데이트
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.totalPages = (int) Math.ceil((double) totalItems / pageSize);
        this.hasNextPage = currentPage < totalPages;
        updateItems(); // 페이지 크기 변경 시 아이템 업데이트
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
        this.totalPages = (int) Math.ceil((double) totalItems / pageSize);
        this.hasNextPage = currentPage < totalPages;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
        updateItems(); // 아이템 리스트 설정 시 페이지네이션 반영
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        return "PaginationDTO{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalItems=" + totalItems +
                ", totalPages=" + totalPages +
                ", hasNextPage=" + hasNextPage +
                ", hasPreviousPage=" + hasPreviousPage +
                ", items=" + items +
                ", sortOrder='" + sortOrder + '\'' +
                '}';
    }

    private void updateItems() {
        if (items != null && !items.isEmpty()) {
            int start = (currentPage - 1) * pageSize;
            int end = Math.min(start + pageSize, totalItems-1);
            this.items = items.subList(start, end);
        }
    }

    public PaginationDTO<T> nextPage() {
        if (this.hasNextPage) {
            setCurrentPage(this.currentPage + 1);
        }
        return this;
    }

    public PaginationDTO<T> prevPage() {
        if (this.hasPreviousPage) {
            setCurrentPage(this.currentPage - 1);
        }
        return this;
    }
}
