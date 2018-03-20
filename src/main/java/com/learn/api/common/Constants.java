package com.learn.api.common;

/**
 * Created by kevinzou on 20/06/2017.
 * Constants
 */
public class Constants {
    /**
     * 日期格式
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_WITHOUT_SECONDS_FORMAT = "yyyy-MM-dd HH:mm";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 比价认知配置
     */
    public final static String PERCENTILE = "1";
    public final static String TENTH = "2";
    public final static String ONE = "3";
    public final static String TEN = "4";
    public final static String HECTO = "5";
    public final static String KILO = "6";
    public final static String MILLION = "7";
    public final static String LAKH = "8";
    public final static String ONE_MILLION = "9";
    public final static String TEN_MILLION = "10";

    /**
     * 测试手机号码
     */
    public final static String PHONE_NUMBER_ONE = "15211111111";
    public final static String PHONE_NUMBER_TWO = "15222222222";

    /**
     * 生意专家活动ID，对应数据库主键，暂时写死处理
     */
    public static final Long BUSINESS_ACTIVE_ID = 19L;
    /**
     * App投放红包活动ID，对应数据库主键。
     */
    public static final Long ADVERTISEMENT_ACTIVE_ID = 2040L;
    /**
     * 杂货铺邀请杂货铺红包活动ID，对应数据库主键。
     */
    public static final Long INVITATION_ACTIVE_ID = 2600L;

    // 红包
    public enum RedPacketType {
        // 小红包
        SMALL,
        // 大红包
        LARGE,
        // 生意专家红包
        BUSINESS,
        // App投放红包
        ADVERTISEMENT,
        // 杂货铺邀请杂货铺红包
        INVITATION,
    }

    /**
     * 用户类型
     */
    public enum UserType {
        // 杂货铺
        SUNDRY,
        // 供应商
        MERCHANT,
    }

}
