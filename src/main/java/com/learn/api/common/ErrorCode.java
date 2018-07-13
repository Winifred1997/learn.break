package com.learn.api.common;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by wjl on 19/06/2017. ErrorCode,按照数据段来定义
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    /**
     * 验证码相关错误
     **/
    SMS_ERROR_COMM(1000, "短信通用错误"), SMS_ERROR_PHONE(1001, "号码有误，请重新输入"), SMS_ERROR_TIME(1002, "发送太频繁"),
    SMS_ERROR_SERVICE(1003, "短信服务不可用"), SMS_ERROR_CODE_NOT_EXIST(1004, "验证码有误，请重新输入"),
    /**
     * 200x成功和部分成功
     **/
    OK_ERROR(2000, "请求成功"), DELIVERY_ADDRESS_NOT_EXIST(2001, "不存在收货地址"), USER_VERIFY_INFO_NOT_COMMIT(2002, "用户审核信息未提交"),
    USER_VERIFY_INFO_WAIT_VERIFY(2003, "用户审核信息等待审核"), USER_VERIFY_NOT_PASS(2004, "用户审核信息未通过"),
    USER_IS_LIMITED(2005, "用户已禁用,请联系客服"),
    /**
     * 收货地址错误
     */
    DELIVERY_ADDRESS_ERROR(3000, "无法解析收货地址"), DELIVERY_ADDRESS_NOT_FOUND(3001, "没找到默认地址"),
    MERCHANT_RULE_NOT_FOUND(3001, "找不到供应商配送范围"), GET_LOCATION_ERROR(3002, "获取地理位置有误"),
    /**
     * 700x用户相关错误
     **/
    USER_ERROR_COMM(7000, "用户类通用错误"), USER_NOT_FOUND(7001, "这个手机号还没注册，请先注册"),
    USER_PWD_WRONG(7002, "用户名密码错误"), USER_HAS_EXIST(7003, "用户名已存在"), USER_IS_NOT(7004, "用户不存在"),
    USER_FORBIDDEN(7403, "用户无权限"), USER_AUTHORIZATION_FAIL(7401, "用户TOKEN到期"), USER_HAS_STOP(7404, "用户已停用"),
    USER_NOT_HAS_INFO(7405, "用户信息不完整"),
    /**
     * 800x服务器错误
     **/
    SERVER_ERROR_COMM(8000, "服务忙"), PARAMETER_ERROR(8001, "参数传入错误"),
    /**
     * 城市错误
     */
    CITY_NOT_SUPPORT(5000, "城市暂不支持"),
    /**
     * 1000x文件错误
     **/
    ADD_FILE_ERROR(10000, "文件上传错误"),
    /**
     * 1100x邀请码错误
     **/
    INVITE_CODE_ERROR(11000, "当前邀请码不存在"), INVITE_CODE_HAS_MORE(11001, "邀请码已存在"),
    /**
     * 1200x红包相关错误
     **/
    SYSTEM_ATTR_CODE_ERROR(12000, "没有这个配置项"), SYSTEM_ATTR_TYPE_ERROR(12001, "参数类型错误"),
    SYSTEM_CALL_ERROR(12002, "非法调用"), ACTIVITY_CLOSE_ERROR(12003, "活动已经结束"),
    USER_PARTICIPATED_ERROR(12004, "用户参与过"), UPPER_LIMIT_ERROR(12005, "达到上限，账号需要审核"),
    NO_RED_PACKAGE_ERROR(12006, "红包已经被抢完"), EXPIRE_ORIGIN_ID(12007, "第三方单号超出分享时间"),
    RED_PACKET_BUSY(12008, "抢红包人太多,请稍后再试"), RED_PACKET_USE_BUSY(12009, "红包正在被使用,请稍候"),
    RED_PACKET_USE_EXPIRE(12010, "红包已过期"), WX_USER_NOT_FOUND(7501, "微信用户信息不完整"),

    /**
     * 营业状态修改错误提示
     **/
    CAN_NOT_UPDATE_BUSINESS_STATUS(12011, "你无法修改营业状态，请联系货小蜜微信：huoquan2016"),

    /**
     * 自定义
     */
    ARTICLE_NOT_HAVE_TYPE(13001, "请补全个人信息，才能发表文章");

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
