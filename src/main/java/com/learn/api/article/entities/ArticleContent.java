package com.learn.api.article.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.learn.api.common.Constants;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@DynamicUpdate
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleContent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty("作者accountId")
    @Column(columnDefinition = "bigint(20) COMMENT '作者accountId'")
    private Long teacherAccountId;

    @ApiModelProperty("作者名称")
    @Transient
    private String teacherName;

    @ApiModelProperty("文章标题")
    @Column(columnDefinition = "varchar(256) COMMENT '文章标题'")
    private String title;

    @ApiModelProperty("文章封面")
    @Column(columnDefinition = "varchar(256) COMMENT '文章封面'")
    private String pic;

    @ApiModelProperty("文章内容")
    @Column(columnDefinition = "text(4096) COMMENT '文章内容'")
    private String content;

    @ApiModelProperty("文章类型，0：语文；1：数学；2：英语；3：物理；4：化学；5、生物；6、政治；7、地理。")
    @Column(columnDefinition = "int(4) COMMENT '文章类型，0：语文；1：数学；2：英语；3：物理；4：化学；5、生物；6、政治；7、地理。'")
    private Integer type;

    @ApiModelProperty("创建时间")
    @CreationTimestamp
    @DateTimeFormat(pattern = Constants.DATE_TIME_FORMAT)
    @Column(columnDefinition = "datetime COMMENT '创建时间'")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @UpdateTimestamp
    @DateTimeFormat(pattern = Constants.DATE_TIME_FORMAT)
    @Column(columnDefinition = "datetime COMMENT '更新时间'")
    private Date updateTime;

    @ApiModelProperty("文章浏览数")
    @Transient
    private Long lookNumber;

    @ApiModelProperty("文章点赞数")
    @Transient
    private Long likeNumber;

    @ApiModelProperty("文章评论数")
    @Transient
    private Long commentNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeacherAccountId() {
        return teacherAccountId;
    }

    public void setTeacherAccountId(Long teacherAccountId) {
        this.teacherAccountId = teacherAccountId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getLookNumber() {
        return lookNumber;
    }

    public void setLookNumber(Long lookNumber) {
        this.lookNumber = lookNumber;
    }

    public Long getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Long likeNumber) {
        this.likeNumber = likeNumber;
    }

    public Long getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Long commentNumber) {
        this.commentNumber = commentNumber;
    }
}
