package com.jolipjo.lovebridge.domain.board.dto;

public class BoardDeleteDTO {

    private int id;

    public BoardDeleteDTO() {}

    public BoardDeleteDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BoardDeleteDTO{" +
                "id=" + id +
                '}';
    }
}
