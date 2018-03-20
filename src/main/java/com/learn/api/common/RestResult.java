package com.learn.api.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by kevinzou on 19/06/2017. RestResult
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class RestResult<T> {

    private T data;
    private ErrorCode code;

    private RestResult() {
    }

    public static <T> RestResult<T> newInstance() {
        return new RestResult<>();
    }

    public RestResult(ErrorCode code, T t) {
        this.code = code;
        this.data = t;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }
}
