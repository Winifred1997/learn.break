package com.learn.api.integral.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.learn.api.common.Constants;
import com.learn.api.redis.ICacheBean;
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
public class Integral implements ICacheBean {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty("用户accountId")
    @Column(columnDefinition = "bigint(20) COMMENT '作者accountId'")
    private Long accountId;

    @ApiModelProperty("增加积分")
    @Column(columnDefinition = "bigint(20) COMMENT '当前积分'")
    private Long integral;

    @ApiModelProperty("当前积分")
    @Column(columnDefinition = "bigint(20) COMMENT '当前积分'")
    private Long nowIntegral;

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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getIntegral() {
        return integral;
    }

    public void setIntegral(Long integral) {
        this.integral = integral;
    }

    public Long getNowIntegral() {
        return nowIntegral;
    }

    public void setNowIntegral(Long nowIntegral) {
        this.nowIntegral = nowIntegral;
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
