package com.learn.api.integral.services.impl;


import com.learn.api.common.Enum.IntegralType;
import com.learn.api.common.Utils.DateUtils;
import com.learn.api.integral.entities.Integral;
import com.learn.api.integral.repos.IntegralRepo;
import com.learn.api.integral.services.IntegralService;
import com.learn.api.redis.services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class IntegralServiceImpl implements IntegralService {

    @Autowired
    IntegralRepo integralRepo;

    @Autowired
    RedisService redisService;

    @Override
    public Integral addIntegral(Long accountId, Integer type) {
        //查询之前分值
        Long integral = redisService.findIntegral(accountId);
        //加上新分值
        long value = IntegralType.getMessageType(type).getValue();
        Long nowIntegral = redisService.addIntegral(accountId, integral + value);
        //保存签到记录
        Integral record = integralRepo.findByAccountId(accountId);
        if (null == record) {
            record = new Integral();
            record.setAccountId(accountId);
            record.setIntegral(value);
            record.setNowIntegral(nowIntegral);
            record.setCreateTime(Calendar.getInstance().getTime());
            record.setUpdateTime(Calendar.getInstance().getTime());
        } else {
            record.setIntegral(value);
            record.setNowIntegral(nowIntegral);
            record.setUpdateTime(Calendar.getInstance().getTime());
        }
        return integralRepo.save(record);
    }

    @Override
    public Boolean checkIntegral(Long accountId) {
        Integral record = integralRepo.findByAccountId(accountId);
        if (null == record) {
            return Boolean.FALSE;
        }
        Boolean isNow = DateUtils.isNow(record.getUpdateTime());
        if (isNow) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public Integral save(Integral entity) {
        return integralRepo.save(entity);
    }

    @Override
    public void delete(Long id) {
        integralRepo.delete(id);
    }

    @Override
    public void delete(Integral entity) {
        integralRepo.delete(entity);
    }

    @Override
    public Integral findById(Long id) {
        return integralRepo.findOne(id);
    }

    @Override
    public Integral findBySample(Integral sample) {
        return integralRepo.findOne(Example.of(sample));
    }

    @Override
    public List<Integral> findAll() {
        return integralRepo.findAll();
    }

    @Override
    public List<Integral> findAll(Sort sort) {
        return integralRepo.findAll(sort);
    }

    @Override
    public List<Integral> findBySamples(Integral sample) {
        return integralRepo.findAll(Example.of(sample));
    }

    @Override
    public List<Integral> findBySamples(Integral sample, Sort sort) {
        return integralRepo.findAll(Example.of(sample), sort);
    }

    @Override
    public Page<Integral> findBySamples(Integral sample, PageRequest pageRequest) {
        return integralRepo.findAll(Example.of(sample), pageRequest);
    }

    @Override
    public Page<Integral> findBySamples(PageRequest pageRequest) {
        return integralRepo.findAll(pageRequest);
    }
}
