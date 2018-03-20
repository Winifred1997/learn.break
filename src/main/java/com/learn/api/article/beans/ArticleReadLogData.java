package com.learn.api.article.beans;

public class ArticleReadLogData {

    private Long accountId;

    private Long teacherAccountId;

    private String title;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getTeacherAccountId() {
        return teacherAccountId;
    }

    public void setTeacherAccountId(Long teacherAccountId) {
        this.teacherAccountId = teacherAccountId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
