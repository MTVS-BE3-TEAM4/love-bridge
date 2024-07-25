package com.jolipjo.lovebridge.domain.board.dto;

import java.time.LocalDateTime;

public class BoardWriteDTO {

    private long id;
    private long memberId;
    private String title;
    private LocalDateTime date;
    private String text;
    private String field;

    public BoardWriteDTO() {}

    public BoardWriteDTO(long id, long memberId, String title, LocalDateTime date, String text, String field) {
        this.id = id;
        this.memberId = memberId;
        this.title = title;
        this.date = date;
        this.text = text;
        this.field = field;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "BoardWriteDTO{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", text='" + text + '\'' +
                ", field='" + field + '\'' +
                '}';
    }
}
