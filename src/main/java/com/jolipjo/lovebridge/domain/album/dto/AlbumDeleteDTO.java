package com.jolipjo.lovebridge.domain.album.dto;

public class AlbumDeleteDTO {


    private int id;
    private String image;
    private String memo;
    private String date;

    public AlbumDeleteDTO() {
    }


    @Override
    public String toString() {
        return "AlbumDeleteDTO{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", memo='" + memo + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public AlbumDeleteDTO(String image, String memo, String date, int id) {
        this.image = image;
        this.memo = memo;
        this.date = date;
        this.id = id;
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

}