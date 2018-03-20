package com.learn.api.user.services;

import com.learn.api.common.BaseService;
import com.learn.api.user.entities.TeacherAccount;

public interface TeacherAccountService extends BaseService<TeacherAccount> {

    TeacherAccount findByUserName(String userName);
}
