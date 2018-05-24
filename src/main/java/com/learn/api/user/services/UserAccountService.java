package com.learn.api.user.services;

import com.learn.api.common.BaseService;
import com.learn.api.user.entities.UserAccount;

public interface UserAccountService extends BaseService<UserAccount> {

    UserAccount findByUserName(String userName);
}
