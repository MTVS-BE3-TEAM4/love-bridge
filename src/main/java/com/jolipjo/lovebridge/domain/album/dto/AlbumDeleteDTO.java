package com.jolipjo.lovebridge.domain.album.dto;

public class AlbumDeleteDTO {


    private int id;
    private String image;
    private String memo;
    private String date;
    private String memberId;

    public AlbumDeleteDTO() {}


    public AlbumDeleteDTO(int id, String image, String memo, String date, String memberId) {
        this.id = id;
        this.image = image;
        this.memo = memo;
        this.date = date;
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "AlbumDeleteDTO{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", memo='" + memo + '\'' +
                ", date='" + date + '\'' +
                ", memberId='" + memberId + '\'' +
                '}';
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

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}