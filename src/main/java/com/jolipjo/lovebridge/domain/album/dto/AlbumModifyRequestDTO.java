package com.jolipjo.lovebridge.domain.album.dto;

public class AlbumModifyRequestDTO {

    private String image;
    private String memo;
    private String date;
    private long id;

    public AlbumModifyRequestDTO() {}

    public AlbumModifyRequestDTO(String image, String memo, String date, long id) {
        this.image = image;
        this.memo = memo;
        this.date = date;
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

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AlbumModifyRequestDTO{" +
                "image='" + image + '\'' +
                ", memo='" + memo + '\'' +
                ", date='" + date + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
