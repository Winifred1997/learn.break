package com.learn.api.article.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.learn.api.common.Constants;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@DynamicUpdate
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleReadLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty("用户accountId")
    @Column(columnDefinition = "bigint(20) COMMENT '作者accountId'")
    private Long accountId;

    @ApiModelProperty("作者accountId")
    @Column(columnDefinition = "bigint(20) COMMENT '作者accountId'")
    private Long teacherAccountId;

    @ApiModelProperty("文章id")
    @Column(columnDefinition = "bigint(20) COMMENT '文章id'")
    private Long articleId;

    @ApiModelProperty("文章标题")
    @Column(columnDefinition = "varchar(256) COMMENT '文章标题'")
    private String title;

    @ApiModelProperty("创建时间")
    @CreationTimestamp
    @DateTimeFormat(pattern = Constants.DATE_TIME_FORMAT)
    @Column(columnDefinition = "datetime COMMENT '创建时间'")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
