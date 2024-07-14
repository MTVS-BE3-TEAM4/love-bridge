package com.jolipjo.lovebridge.domain.quiz.dto;

public class Quiz {
    /*
    1. 퀴즈목록ID > 디테일 조회용 코드
    2. 퀴즈그룹ID > 페이징처리
    3. 순번 > 정렬용
    4. 퀴즈제목 
    5. 완료여부 > 하트
     */
    private int listId;
    private int groupId;
    private int listNum;
    private String quizTitle;
    private boolean complete;

    public Quiz() {}

    public Quiz(int listId, int groupId, int listNum, String quizTitle, boolean complete) {
        this.listId = listId;
        this.groupId = groupId;
        this.listNum = listNum;
        this.quizTitle = quizTitle;
        this.complete = complete;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getListNum() {
        return listNum;
    }

    public void setListNum(int listNum) {
        this.listNum = listNum;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "listId=" + listId +
                ", groupId=" + groupId +
                ", listNum=" + listNum +
                ", quizTitle='" + quizTitle + '\'' +
                ", complete=" + complete +
                '}';
    }
}
