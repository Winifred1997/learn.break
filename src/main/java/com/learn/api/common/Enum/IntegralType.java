package com.learn.api.common.Enum;

import com.learn.api.common.ErrorCode;
import com.learn.api.common.exception.LearnException;

/**
 * Created by wjl on 2018/3/19.
 */
public enum IntegralType {

    day(10),
    weekDay(100);

    long value;

    IntegralType(int value) {
        this.value = value;
    }

    public static IntegralType getMessageType(int index) {
        switch (index) {
            case 0:
                return IntegralType.day;
            case 1:
                return IntegralType.weekDay;
        }
        throw new LearnException(ErrorCode.SMS_ERROR_COMM);
    }

    public long getValue() {
        return value;
    }

}
