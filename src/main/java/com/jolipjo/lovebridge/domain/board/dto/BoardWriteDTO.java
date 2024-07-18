package com.jolipjo.lovebridge.domain.board.dto;

public class BoardWriteDTO {
    private String title;
    private String text;

    public BoardWriteDTO() {}

    public BoardWriteDTO(String title, String text) {
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
        return "BoardWriteDTO{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
