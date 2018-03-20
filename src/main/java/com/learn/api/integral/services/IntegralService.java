package com.learn.api.integral.services;

import com.learn.api.common.BaseService;
import com.learn.api.integral.entities.Integral;

public interface IntegralService extends BaseService<Integral> {

    Integral addIntegral(Long accountId, Integer type);

    Boolean checkIntegral(Long accountId);
}
