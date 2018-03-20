package com.learn.api.common.exception.handler;

import com.learn.api.common.ErrorCode;
import com.learn.api.common.RestResult;
import com.learn.api.common.RestResultGenerator;
import com.learn.api.common.exception.LearnException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kevinzou on 19/06/2017. RestExceptionHandler
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class RestExceptionHandler {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(RestExceptionHandler.class);

    @ExceptionHandler(LearnException.class)
    @ResponseBody
    private RestResult<String> HqqException(LearnException e) {
        if (LOGGER.isErrorEnabled()) {
            LOGGER.error("error:", e);
        }
        if(e.getCode()== ErrorCode.SERVER_ERROR_COMM&&e.getMessage()!=null)
        	return RestResultGenerator.genResult(e.getCode(),e.getMessage());
        return RestResultGenerator.genErrorResult(e.getCode());
    }
    
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    private RestResult<String> runtimeExceptionHandler(AccessDeniedException e) {
        if (LOGGER.isWarnEnabled()) {
            LOGGER.warn("warn:", e);
        }
        return RestResultGenerator.genErrorResult(ErrorCode.USER_FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    private RestResult<String> runtimeExceptionHandler(Exception e) {
        if (LOGGER.isWarnEnabled()) {
            LOGGER.error("error", e);
        }
        return RestResultGenerator.genResult(ErrorCode.SERVER_ERROR_COMM,
                "maybe has error,later try again");
    }
}
