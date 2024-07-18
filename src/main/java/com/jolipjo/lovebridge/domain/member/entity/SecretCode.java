package com.jolipjo.lovebridge.domain.member.entity;

public class SecretCode {
    Long id;
    String code;
    Integer count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "SecretCode{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", count=" + count +
                '}';
    }
}
