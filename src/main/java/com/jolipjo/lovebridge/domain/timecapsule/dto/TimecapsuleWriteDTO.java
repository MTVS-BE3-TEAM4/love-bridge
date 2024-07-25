package com.jolipjo.lovebridge.domain.timecapsule.dto;

public class TimecapsuleWriteDTO {

    private String tcsealingdate;  //봉인일
    private String tcreleasedate;  //개봉일
    private String tctitle;     //제목
    private String tcdetail;   //내용
    private String memberId;
    private String image;


    public TimecapsuleWriteDTO() {}

    public TimecapsuleWriteDTO(String tcsealingdate, String tcreleasedate, String tctitle, String tcdetail, String memberId, String image) {
        this.tcsealingdate = tcsealingdate;
        this.tcreleasedate = tcreleasedate;
        this.tctitle = tctitle;
        this.tcdetail = tcdetail;
        this.memberId = memberId;
        this.image = image;
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

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "TimecapsuleWriteDTO{" +
                "tcsealingdate='" + tcsealingdate + '\'' +
                ", tcreleasedate='" + tcreleasedate + '\'' +
                ", tctitle='" + tctitle + '\'' +
                ", tcdetail='" + tcdetail + '\'' +
                ", memberId='" + memberId + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
