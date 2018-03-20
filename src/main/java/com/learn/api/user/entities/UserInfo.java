package com.learn.api.user.entities;

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
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty("唯一标识")
    @Column(columnDefinition = "varchar(256) COMMENT '唯一标识'")
    private String signature;

    @ApiModelProperty("头像")
    @Column(columnDefinition = "varchar(256) COMMENT '头像'")
    private String avatarUrl;

    @ApiModelProperty("城市")
    @Column(columnDefinition = "varchar(16) COMMENT '城市'")
    private String city;

    @ApiModelProperty("国家")
    @Column(columnDefinition = "varchar(16) COMMENT '国家'")
    private String country;

    @ApiModelProperty("性别")
    @Column(columnDefinition = "int(1) COMMENT '性别'")
    private Integer gender;

    @ApiModelProperty("语言")
    @Column(columnDefinition = "varchar(32) COMMENT '语言'")
    private String language;

    @ApiModelProperty("昵称")
    @Column(columnDefinition = "varchar(64) COMMENT '昵称'")
    private String nickName;

    @ApiModelProperty("省份")
    @Column(columnDefinition = "varchar(64) COMMENT '省份'")
    private String province;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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
