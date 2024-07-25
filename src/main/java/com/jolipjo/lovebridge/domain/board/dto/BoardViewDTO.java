package com.jolipjo.lovebridge.domain.board.dto;

import java.time.LocalDateTime;

public class BoardViewDTO {

    private String title;
    private String text;
    private String nickName;
    private int id;
    private LocalDateTime date;

    public BoardViewDTO() {}

    public BoardViewDTO(String title, String text, String nickName, int id, LocalDateTime date) {
        this.title = title;
        this.text = text;
        this.nickName = nickName;
        this.id = id;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BoardViewDTO{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", nickName='" + nickName + '\'' +
                ", id=" + id +
                ", date='" + date + '\'' +
                '}';
    }
}
