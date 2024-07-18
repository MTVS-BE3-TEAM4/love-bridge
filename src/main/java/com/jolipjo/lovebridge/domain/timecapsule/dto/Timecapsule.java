package com.jolipjo.lovebridge.domain.timecapsule.dto;

import javax.xml.crypto.Data;

public class Timecapsule {
    /*
    1. 시크릿코드
    2. 봉인일
    3. 개봉일
    4. 제목
    5. 내용
    6. 사진 url
     */
    private String tcsecretcode; //시크릿코드
    private Data tcsealingdate;  //봉인일
    private Data tcreleasedate;  //개봉일
    private String tctitle;     //제목
    private String tcdetail;   //내용
    private String tcpicture;   //사진

    public Timecapsule(){}

    public Timecapsule(String tcsecretcode, Data tcsealingdate, Data tcreleasedate, String tctitle, String tcdetail, String tcpicture) {
        this.tcsecretcode = tcsecretcode;
        this.tcsealingdate = tcsealingdate;
        this.tcreleasedate = tcreleasedate;
        this.tctitle = tctitle;
        this.tcdetail = tcdetail;
        this.tcpicture = tcpicture;
    }

    public void setTcsecretcode(String tcsecretcode) {
        this.tcsecretcode = tcsecretcode;
    }

    public void setTcsealingdate(Data tcsealingdate) {
        this.tcsealingdate = tcsealingdate;
    }

    public void setTcreleasedate(Data tcreleasedate) {
        this.tcreleasedate = tcreleasedate;
    }

    public void setTctitle(String tctitle) {
        this.tctitle = tctitle;
    }

    public void setTcdetail(String tcdetail) {
        this.tcdetail = tcdetail;
    }

    public void setTcpicture(String tcpicture) {
        this.tcpicture = tcpicture;
    }

    public String getTcsecretcode() {
        return tcsecretcode;
    }

    public Data getTcsealingdate() {
        return tcsealingdate;
    }

    public Data getTcreleasedate() {
        return tcreleasedate;
    }

    public String getTctitle() {
        return tctitle;
    }

    public String getTcdetail() {
        return tcdetail;
    }

    public String getTcpicture() {
        return tcpicture;
    }

    @Override
    public String toString() {
        return "Timecapsule{" +
                "tcsecretcode=" + tcsecretcode +
                ", tcsealingdate=" + tcsealingdate +
                ", tcreleasedate=" + tcreleasedate +
                ", tctitle='" + tctitle + '\'' +
                ", tcdetail=" + tcdetail +
                ", tcpicture='" + tcpicture + '\'' +
                '}';
    }
}
