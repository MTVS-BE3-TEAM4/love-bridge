package com.jolipjo.lovebridge.domain.timecapsule.dto;

import javax.xml.crypto.Data;

public class TimecapsuleViewDTO {

    private int id;
    private String tcsealingdate;  //봉인일
    private String tcreleasedate;  //개봉일
    private String tctitle;     //제목
    private String tcdetail;   //내용
    private String memberid;
    private String createdat;
    private String image;

    public TimecapsuleViewDTO() {}

    public TimecapsuleViewDTO(int id, String tcsealingdate, String tcreleasedate, String tctitle, String tcdetail, String memberid, String createdat, String image) {
        this.id = id;
        this.tcsealingdate = tcsealingdate;
        this.tcreleasedate = tcreleasedate;
        this.tctitle = tctitle;
        this.tcdetail = tcdetail;
        this.memberid = memberid;
        this.createdat = createdat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTcsealingdate() {
        return tcsealingdate;
    }

    public void setTcsealingdate(String tcsealingdate) {
        this.tcsealingdate = tcsealingdate;
    }

    public String getTcreleasedate() {
        return tcreleasedate;
    }

    public void setTcreleasedate(String tcreleasedate) {
        this.tcreleasedate = tcreleasedate;
    }

    public String getTctitle() {
        return tctitle;
    }

    public void setTctitle(String tctitle) {
        this.tctitle = tctitle;
    }

    public String getTcdetail() {
        return tcdetail;
    }

    public void setTcdetail(String tcdetail) {
        this.tcdetail = tcdetail;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getCreatedat() {
        return createdat;
    }

    public void setCreatedat(String createdat) {
        this.createdat = createdat;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "TimecapsuleViewDTO{" +
                "id=" + id +
                ", tcsealingdate='" + tcsealingdate + '\'' +
                ", tcreleasedate='" + tcreleasedate + '\'' +
                ", tctitle='" + tctitle + '\'' +
                ", tcdetail='" + tcdetail + '\'' +
                ", memberid='" + memberid + '\'' +
                ", createdat='" + createdat + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
