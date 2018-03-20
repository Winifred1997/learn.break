package com.learn.api.user.services.impl;


import com.learn.api.user.entities.UserInfo;
import com.learn.api.user.repos.UserInfoRepo;
import com.learn.api.user.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoRepo userInfoRepo;

    @Override
    public UserInfo findBySignature(String userName) {
        return userInfoRepo.findBySignature(userName);
    }

    @Override
    public UserInfo save(UserInfo entity) {
        return userInfoRepo.save(entity);
    }

    @Override
    public void delete(Long id) {
        userInfoRepo.delete(id);
    }

    @Override
    public void delete(UserInfo entity) {
        userInfoRepo.delete(entity);
    }

    @Override
    public UserInfo findById(Long id) {
        return userInfoRepo.findOne(id);
    }

    @Override
    public UserInfo findBySample(UserInfo sample) {
        return userInfoRepo.findOne(Example.of(sample));
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoRepo.findAll();
    }

    @Override
    public List<UserInfo> findAll(Sort sort) {
        return userInfoRepo.findAll(sort);
    }

    @Override
    public List<UserInfo> findBySamples(UserInfo sample) {
        return userInfoRepo.findAll(Example.of(sample));
    }

    @Override
    public List<UserInfo> findBySamples(UserInfo sample, Sort sort) {
        return userInfoRepo.findAll(Example.of(sample), sort);
    }

    @Override
    public Page<UserInfo> findBySamples(UserInfo sample, PageRequest pageRequest) {
        return userInfoRepo.findAll(Example.of(sample), pageRequest);
    }

    @Override
    public Page<UserInfo> findBySamples(PageRequest pageRequest) {
        return userInfoRepo.findAll(pageRequest);
    }
}
