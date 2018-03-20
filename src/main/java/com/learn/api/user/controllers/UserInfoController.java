package com.learn.api.user.controllers;


import com.alibaba.fastjson.JSON;
import com.learn.api.common.RestResult;
import com.learn.api.common.RestResultGenerator;
import com.learn.api.common.Utils.StringUtils;
import com.learn.api.common.Utils.Utils;
import com.learn.api.user.entities.TeacherAccount;
import com.learn.api.user.entities.UserInfo;
import com.learn.api.user.services.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;

@Api("用户账号API")
@RestController
@RequestMapping("/user")
public class UserInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    UserInfoService userInfoService;

    @ApiOperation(value = "保存用户信息")
    @PostMapping("/saveUserInfo")
    public RestResult<UserInfo> saveUserInfo(@RequestBody UserInfo userInfo) {
        try {
            userInfo.setNickName(StringUtils.emojiConvert1(userInfo.getNickName()));
        } catch (UnsupportedEncodingException e) {
            LOGGER.debug("StringUtils.emojiRecovery2 is error userInfo:{}", JSON.toJSONString(userInfo));
        }
        //根据唯一标识查询是否存在这个信息
        if (null != userInfo.getSignature()) {
            //查询是否存在这个用户信息
            UserInfo info = userInfoService.findBySignature(userInfo.getSignature());
            if (null != info) {
                info.setUpdateTime(Calendar.getInstance().getTime());
                BeanUtils.copyProperties(userInfo, info, Utils.getNullPropertyNames(userInfo));
            } else {
                info = new UserInfo();
                BeanUtils.copyProperties(userInfo, info, Utils.getNullPropertyNames(userInfo));
                info.setCreateTime(Calendar.getInstance().getTime());
                info.setUpdateTime(Calendar.getInstance().getTime());
            }
            userInfo = userInfoService.save(info);
        }
        return RestResultGenerator.genSuccessResult(userInfo);
    }

}
