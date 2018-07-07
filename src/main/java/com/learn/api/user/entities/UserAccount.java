package com.learn.api.user.entities;

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
public class UserAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty("账号")
    @Column(columnDefinition = "varchar(16) COMMENT '账号'")
    private String userName;

    @ApiModelProperty("密码")
    @Column(columnDefinition = "varchar(16) COMMENT '密码'")
    private String password;

    @ApiModelProperty("昵称")
    @Column(columnDefinition = "varchar(16) COMMENT '昵称'")
    private String nickName;

    @ApiModelProperty("头像")
    @Column(columnDefinition = "varchar(16) COMMENT '头像'")
    private String icon;

    @ApiModelProperty("权限")
    @Column(columnDefinition = "int(1) COMMENT '权限'")
    private Integer role;

    @ApiModelProperty("（教师）所授科目")
    @Column(columnDefinition = "int(4) COMMENT '所授科目'")
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

    public static UserAccount getUserAccount(UserAccount userAccount){
        userAccount.setPassword(null);
        return userAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
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
}
