package com.jolipjo.lovebridge.domain.board.dto;

public class BoardDeleteDTO {

    private int id;
    private int memberId;

    public BoardDeleteDTO() {}

    public BoardDeleteDTO(int id, int memberId) {
        this.id = id;
        this.memberId = memberId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "BoardDeleteDTO{" +
                "id=" + id +
                ", memberId=" + memberId +
                '}';
    }
}
