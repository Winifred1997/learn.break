package com.learn.api.user.repos;


import com.learn.api.user.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserInfoRepo extends JpaRepository<UserInfo, Long>, JpaSpecificationExecutor<UserInfo> {

    UserInfo findBySignature(String userName);

}
