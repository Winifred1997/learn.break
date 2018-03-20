package com.learn.api.user.services.impl;


import com.learn.api.user.entities.TeacherAccount;
import com.learn.api.user.repos.TeacherAccountRepo;
import com.learn.api.user.services.TeacherAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherAccountServiceImpl implements TeacherAccountService {

    @Autowired
    TeacherAccountRepo teacherAccountRepo;

    @Override
    public TeacherAccount save(TeacherAccount entity) {
        return teacherAccountRepo.save(entity);
    }

    @Override
    public void delete(Long id) {
        teacherAccountRepo.delete(id);
    }

    @Override
    public void delete(TeacherAccount entity) {
        teacherAccountRepo.delete(entity);
    }

    @Override
    public TeacherAccount findById(Long id) {
        return teacherAccountRepo.findOne(id);
    }

    @Override
    public TeacherAccount findBySample(TeacherAccount sample) {
        return teacherAccountRepo.findOne(Example.of(sample));
    }

    @Override
    public List<TeacherAccount> findAll() {
        return teacherAccountRepo.findAll();
    }

    @Override
    public List<TeacherAccount> findAll(Sort sort) {
        return teacherAccountRepo.findAll(sort);
    }

    @Override
    public List<TeacherAccount> findBySamples(TeacherAccount sample) {
        return teacherAccountRepo.findAll(Example.of(sample));
    }

    @Override
    public List<TeacherAccount> findBySamples(TeacherAccount sample, Sort sort) {
        return teacherAccountRepo.findAll(Example.of(sample), sort);
    }

    @Override
    public Page<TeacherAccount> findBySamples(TeacherAccount sample, PageRequest pageRequest) {
        return teacherAccountRepo.findAll(Example.of(sample), pageRequest);
    }

    @Override
    public Page<TeacherAccount> findBySamples(PageRequest pageRequest) {
        return teacherAccountRepo.findAll(pageRequest);
    }

    @Override
    public TeacherAccount findByUserName(String userName) {
        return teacherAccountRepo.findByUserName(userName);
    }
}
