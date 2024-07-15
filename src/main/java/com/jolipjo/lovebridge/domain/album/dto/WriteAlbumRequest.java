package com.jolipjo.lovebridge.domain.album.dto;

public class WriteAlbumRequest {

    private String image;
    private String memo;
    private int date;

    public String getImage() {return image;}

    public void setImage(String image) {this.image = image;}

    public String getMemo() {return memo;}

    public void setMemo(String memo) {this.memo = memo;}

    public int getDate() {return date;}

    public void setDate(int date) {this.date = date;}
}
