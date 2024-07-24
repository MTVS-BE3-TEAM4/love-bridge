package com.jolipjo.lovebridge.domain.timecapsule.dto;

import org.springframework.web.bind.annotation.GetMapping;

public class TimecapsuleListDTO {

    private String id;
    private String memberId;
    private String startdate;
    private String enddate;
    private String createdat;
    private String title;
    private String content;
    private String email;// 이메일

    public TimecapsuleListDTO() {}

    public TimecapsuleListDTO(String id, String memberId, String startdate, String enddate, String createdat, String title, String content) {
        this.id = id;
        this.memberId = memberId;
        this.startdate = startdate;
        this.enddate = enddate;
        this.createdat = createdat;
        this.title = title;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedat() {
        return createdat;
    }

    public void setCreatedat(String createdat) {
        this.createdat = createdat;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "TimecapsuleListDTO{" +
                "id='" + id + '\'' +
                ", memberId='" + memberId + '\'' +
                ", startdate='" + startdate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", createdat='" + createdat + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
