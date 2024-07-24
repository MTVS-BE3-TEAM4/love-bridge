package com.jolipjo.lovebridge.domain.timecapsule.dto;

import javax.xml.crypto.Data;

public class TimecapsuleViewDTO {

    private Long id;
    private String tcsealingdate;  //봉인일
    private String tcreleasedate;  //개봉일
    private String tctitle;     //제목
    private String tcdetail;   //내용

    public TimecapsuleViewDTO() {}

    public TimecapsuleViewDTO( Long id, String tcsealingdate, String tcreleasedate, String tctitle, String tcdetail) {
        this.id = id;
        this.tcsealingdate = tcsealingdate;
        this.tcreleasedate = tcreleasedate;
        this.tctitle = tctitle;
        this.tcdetail = tcdetail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTcsealingdate() {
        return tcsealingdate;
    }

    public String getTcreleasedate() {
        return tcreleasedate;
    }

    public String getTctitle() {
        return tctitle;
    }

    public String getTcdetail() {
        return tcdetail;
    }

    public void setTcsealingdate(String tcsealingdate) {
        this.tcsealingdate = tcsealingdate;
    }

    public void setTcreleasedate(String tcreleasedate) {
        this.tcreleasedate = tcreleasedate;
    }

    public void setTctitle(String tctitle) {
        this.tctitle = tctitle;
    }

    public void setTcdetail(String tcdetail) {
        this.tcdetail = tcdetail;
    }

    @Override
    public String toString() {
        return "TimecapsuleViewDTO{" +
                "id=" + id +
                "tcsealingdate=" + tcsealingdate +
                ", tcreleasedate=" + tcreleasedate +
                ", tctitle='" + tctitle + '\'' +
                ", tcdetail='" + tcdetail + '\'' +
                '}';
    }

}
