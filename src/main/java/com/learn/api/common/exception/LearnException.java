package com.learn.api.common.exception;

import com.learn.api.common.ErrorCode;

public class LearnException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ErrorCode code;

    public LearnException() {
        super();
    }

    public LearnException(ErrorCode code) {
        this.code = code;
    }

    public LearnException(ErrorCode code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public LearnException(ErrorCode code, String message) {
        super(message);
        this.code = code;
    }

    public LearnException(ErrorCode code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }


}
