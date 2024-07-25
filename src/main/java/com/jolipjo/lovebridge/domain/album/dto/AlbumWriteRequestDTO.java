package com.jolipjo.lovebridge.domain.album.dto;

public class AlbumWriteRequestDTO {

    private int id;
    private String image;
    private String memo;
    private String date;
    private Long memberId;
    private int totalItems;


    public AlbumWriteRequestDTO() {}

    @Override
    public String toString() {
        return "AlbumWriteRequestDTO{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", memo='" + memo + '\'' +
                ", date='" + date + '\'' +
                ", memberId=" + memberId +
                ", totalItems=" + totalItems +
                '}';
    }

    public AlbumWriteRequestDTO(int id, String image, String memo, String date, Long memberId, int totalItems) {
        this.id = id;
        this.image = image;
        this.memo = memo;
        this.date = date;
        this.memberId = memberId;
        this.totalItems = totalItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }
}


