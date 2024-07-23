package com.jolipjo.lovebridge.domain.album.dto;


public class AlbumListRequestDTO {

    private String image;
    private String memo;
    private String date;
    private String memberId;

    public AlbumListRequestDTO() {}

    @Override
    public String toString() {
        return "AlbumListRequestDTO{" +
                "image='" + image + '\'' +
                ", memo='" + memo + '\'' +
                ", date='" + date + '\'' +
                ", memberId='" + memberId + '\'' +
                '}';
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

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public AlbumListRequestDTO(String image, String memo, String date, String memberId) {
        this.image = image;
        this.memo = memo;
        this.date = date;
        this.memberId = memberId;
    }
}