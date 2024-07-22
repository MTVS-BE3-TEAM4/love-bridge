package com.jolipjo.lovebridge.domain.album.dto;

public class AlbumWriteRequestDTO {

    private int id;
    private String image;
    private String memo;
    private String date;

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

    public AlbumWriteRequestDTO(String image, String memo, String date, int id) {
        this.image = image;
        this.memo = memo;
        this.date = date;
        this.id = id;
    }

    public AlbumWriteRequestDTO() {}



    @Override
    public String toString() {
        return "AlbumWriteRequestDTO{" +
                "id='" + id + '\'' +
                ", image='" + image + '\'' +
                ", memo='" + memo + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
