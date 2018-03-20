package com.learn.api.user.controllers;


import com.learn.api.common.ErrorCode;
import com.learn.api.common.RestResult;
import com.learn.api.common.RestResultGenerator;
import com.learn.api.user.entities.TeacherAccount;
import com.learn.api.user.services.TeacherAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("用户账号API")
@RestController
@RequestMapping("/teacher")
public class TeacherAccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherAccountController.class);

    @Autowired
    TeacherAccountService teacherAccountService;

    @ApiOperation(value = "查看账号密码")
    @GetMapping("/getAccount")
    public RestResult<TeacherAccount> getAccount(@RequestParam("userName") String userName) {
        if(null == userName){
            return RestResultGenerator.genErrorResult(ErrorCode.SERVER_ERROR_COMM);
        }
        return RestResultGenerator.genSuccessResult(teacherAccountService.findByUserName(userName));
    }

}
