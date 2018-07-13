package com.learn.api.common;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wjl on 19/06/2017. RestResultGenerator
 */
public class RestResultGenerator {

    private static final Logger LOGGER = LoggerFactory
        .getLogger(RestResultGenerator.class);

    /**
     * normal
     *
     * @param data
     * @param code
     * @return
     */
    public static <T> RestResult<T> genResult(ErrorCode code, T data) {
        RestResult<T> result = RestResult.newInstance();
        result.setData(data);
        result.setCode(code);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("generate rest result:{}", JSON.toJSONString(result));
        }
        return result;
    }

    /**
     * success
     *
     * @param data
     * @return
     */
    public static <T> RestResult<T> genSuccessResult(T data) {
        return genResult(ErrorCode.OK_ERROR, data);
    }

    /**
     * error
     *
     * @param code
     * @return
     */
    public static <T> RestResult<T> genErrorResult(ErrorCode code) {
        return genResult(code, null);
    }

}
