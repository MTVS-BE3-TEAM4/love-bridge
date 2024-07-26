package com.jolipjo.lovebridge.domain.paginaition.service;

import com.jolipjo.lovebridge.domain.paginaition.dao.PaginationMapper;
import com.jolipjo.lovebridge.domain.paginaition.dto.PaginationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaginationService<T> {

    private final PaginationMapper paginationMapper;

    public PaginationService(PaginationMapper paginationMapper) {
        this.paginationMapper = paginationMapper;
    }

    public PaginationDTO<T> getItemsWithPagination(int page, int size) {
        int offset = (page - 1) * size;

        // Fetching paginated items
        List<T> items = paginationMapper.findAllByPage(offset, page);

        // Fetching total number of items
        int totalItems = paginationMapper.countTotalItems();

        // Creating and returning PaginationDTO
        return new PaginationDTO<>(page, size, items, totalItems);
    }
}
