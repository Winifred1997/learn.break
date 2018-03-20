package com.learn.api.integral.controllers;


import com.learn.api.common.ErrorCode;
import com.learn.api.common.RestResult;
import com.learn.api.common.RestResultGenerator;
import com.learn.api.integral.entities.Integral;
import com.learn.api.integral.services.IntegralService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("签到积分API")
@RestController
@RequestMapping("/integral")
public class IntegralController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntegralController.class);

    @Autowired
    IntegralService integralService;

    @ApiOperation(value = "签到增加积分")
    @GetMapping("/addIntegral")
    public RestResult<Integral> addIntegral(@RequestParam("accountId") Long accountId, @RequestParam("type") Integer type) {
        if(null == accountId || null == type){
            return RestResultGenerator.genErrorResult(ErrorCode.SERVER_ERROR_COMM);
        }
        return RestResultGenerator.genSuccessResult(integralService.addIntegral(accountId, type));
    }

    @ApiOperation(value = "检查当天是否签到")
    @GetMapping("/checkIntegral")
    public RestResult<Boolean> checkIntegral(@RequestParam("accountId") Long accountId) {
        if(null == accountId){
            return RestResultGenerator.genErrorResult(ErrorCode.SERVER_ERROR_COMM);
        }
        return RestResultGenerator.genSuccessResult(integralService.checkIntegral(accountId));
    }

}
