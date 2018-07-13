package com.learn.api.user.repos;


import com.learn.api.user.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserAccountRepo extends JpaRepository<UserAccount, Long>, JpaSpecificationExecutor<UserAccount> {

    UserAccount findByUserName(String userName);

}
