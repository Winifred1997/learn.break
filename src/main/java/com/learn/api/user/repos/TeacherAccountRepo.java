package com.learn.api.user.repos;


import com.learn.api.user.entities.TeacherAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherAccountRepo extends JpaRepository<TeacherAccount, Long>, JpaSpecificationExecutor<TeacherAccount> {

    TeacherAccount findByUserName(String userName);
}
