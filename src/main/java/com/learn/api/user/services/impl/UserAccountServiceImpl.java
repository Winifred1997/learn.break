package com.learn.api.user.services.impl;


import com.learn.api.user.entities.UserAccount;
import com.learn.api.user.repos.UserAccountRepo;
import com.learn.api.user.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    UserAccountRepo userAccountRepo;

    @Override
    public UserAccount save(UserAccount entity) {
        return userAccountRepo.save(entity);
    }

    @Override
    public void delete(Long id) {
        userAccountRepo.delete(id);
    }

    @Override
    public void delete(UserAccount entity) {
        userAccountRepo.delete(entity);
    }

    @Override
    public UserAccount findById(Long id) {
        return userAccountRepo.findOne(id);
    }

    @Override
    public UserAccount findBySample(UserAccount sample) {
        return userAccountRepo.findOne(Example.of(sample));
    }

    @Override
    public List<UserAccount> findAll() {
        return userAccountRepo.findAll();
    }

    @Override
    public List<UserAccount> findAll(Sort sort) {
        return userAccountRepo.findAll(sort);
    }

    @Override
    public List<UserAccount> findBySamples(UserAccount sample) {
        return userAccountRepo.findAll(Example.of(sample));
    }

    @Override
    public List<UserAccount> findBySamples(UserAccount sample, Sort sort) {
        return userAccountRepo.findAll(Example.of(sample), sort);
    }

    @Override
    public Page<UserAccount> findBySamples(UserAccount sample, PageRequest pageRequest) {
        return userAccountRepo.findAll(Example.of(sample), pageRequest);
    }

    @Override
    public Page<UserAccount> findBySamples(PageRequest pageRequest) {
        return userAccountRepo.findAll(pageRequest);
    }

    @Override
    public UserAccount findByUserName(String userName) {
        return userAccountRepo.findByUserName(userName);
    }
}
