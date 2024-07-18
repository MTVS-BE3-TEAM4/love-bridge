package com.jolipjo.lovebridge.domain.board.dto;

public class BoardViewDTO {

    private String title;
    private String text;

    public BoardViewDTO() {}

    public BoardViewDTO(String title, String text) {
        this.title = title;
        this.text = text;
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

    @Override
    public String toString() {
        return "BoardViewDTO{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
