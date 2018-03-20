package com.learn.api.common.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wjl on 2018/3/19.
 */
public class DateUtils {

    /**
     * 判断时间是不是今天
     * @param date
     * @return    是返回true，不是返回false
     */
    public static boolean isNow(Date date) {
        //当前时间
        Date now = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        //获取今天的日期
        String nowDay = sf.format(now);
        //对比的时间
        String day = sf.format(date);
        return day.equals(nowDay);
    }

}
