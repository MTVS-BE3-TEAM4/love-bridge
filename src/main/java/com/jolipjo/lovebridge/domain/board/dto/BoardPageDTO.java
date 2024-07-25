package com.jolipjo.lovebridge.domain.board.dto;

public class BoardPageDTO {
    private int offset;
    private int limit;

    public BoardPageDTO() {}

    public BoardPageDTO(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "BoardPageDTO{" +
                "offset=" + offset +
                ", limit=" + limit +
                '}';
    }
}
