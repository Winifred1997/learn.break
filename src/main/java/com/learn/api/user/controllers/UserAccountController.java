package com.learn.api.user.controllers;


import com.learn.api.common.ErrorCode;
import com.learn.api.common.RestResult;
import com.learn.api.common.RestResultGenerator;
import com.learn.api.user.entities.UserAccount;
import com.learn.api.user.entities.UserInfo;
import com.learn.api.user.services.UserAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("用户账号API")
@RestController
@RequestMapping("/user/account")
public class UserAccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserAccountController.class);

    @Autowired
    UserAccountService userAccountService;

    @ApiOperation(value = "查看账号密码")
    @GetMapping("/getAccount")
    public RestResult<UserAccount> getAccount(@RequestParam("userName") String userName) {
        if (null == userName) {
            return RestResultGenerator.genErrorResult(ErrorCode.PARAMETER_ERROR);
        }
        return RestResultGenerator.genSuccessResult(userAccountService.findByUserName(userName));
    }

    @ApiOperation(value = "注册账号（前台）")
    @PostMapping("/register")
    public RestResult<UserAccount> register(@RequestBody UserAccount account) {
        if (null == account.getUserName() || null == account.getPassword()) {
            return RestResultGenerator.genErrorResult(ErrorCode.PARAMETER_ERROR);
        }
        //验证账号是否存在
        UserAccount userAccount = userAccountService.findByUserName(account.getUserName());
        if (null != userAccount) {
            return RestResultGenerator.genErrorResult(ErrorCode.USER_HAS_EXIST);
        } else {
            userAccount = userAccountService.save(account);
        }
        return RestResultGenerator.genSuccessResult(userAccount);
    }

    @ApiOperation(value = "登陆账号（前台）")
    @PostMapping("/login")
    public RestResult<UserAccount> login(@RequestBody UserAccount account) {
        if (null == account.getUserName() || null == account.getPassword()) {
            return RestResultGenerator.genErrorResult(ErrorCode.PARAMETER_ERROR);
        }
        //验证账号是否存在
        UserAccount userAccount = userAccountService.findByUserName(account.getUserName());
        if (null == userAccount || !account.getPassword().equals(userAccount.getPassword())) {
            return RestResultGenerator.genErrorResult(ErrorCode.USER_IS_NOT);
        }
        return RestResultGenerator.genSuccessResult(userAccount);
    }

    @ApiOperation(value = "登录账号（后台）")
    @PostMapping("/toLogin")
    public RestResult<UserAccount> toLogin(@RequestBody UserAccount account) {
        if (null == account.getUserName() || null == account.getPassword()) {
            return RestResultGenerator.genErrorResult(ErrorCode.PARAMETER_ERROR);
        }
        //验证账号是否存在
        UserAccount userAccount = userAccountService.findByUserName(account.getUserName());
        if (null == userAccount || !account.getPassword().equals(userAccount.getPassword())) {
            return RestResultGenerator.genErrorResult(ErrorCode.USER_IS_NOT);
        }
        return RestResultGenerator.genSuccessResult(userAccount);
    }

}
