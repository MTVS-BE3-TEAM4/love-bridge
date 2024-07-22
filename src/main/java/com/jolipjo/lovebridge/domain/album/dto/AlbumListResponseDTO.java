package com.jolipjo.lovebridge.domain.album.dto;

public class AlbumListResponseDTO {

    private String image;
    private String memo;
    private String date;
    private int id;
    private String memberId;

    public AlbumListResponseDTO() {}

    @Override
    public String toString() {
        return "AlbumListResponseDTO{" +
                "image='" + image + '\'' +
                ", memo='" + memo + '\'' +
                ", date='" + date + '\'' +
                ", id='" + id + '\'' +
                ", memberId='" + memberId + '\'' +
                '}';
    }

    public AlbumListResponseDTO(String image, String memo, String date, int id, String memberId) {
        this.image = image;
        this.memo = memo;
        this.date = date;
        this.id = id;
        this.memberId = memberId;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
