package com.learn.api.user.services;

import com.learn.api.common.BaseService;
import com.learn.api.user.entities.UserInfo;

public interface UserInfoService extends BaseService<UserInfo> {

    UserInfo findBySignature(String userName);
}
