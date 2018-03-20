package com.learn.api.redis.services.impl;

//import com.learn.api.redis.RedisBaseCache;
import com.learn.api.redis.RedisKey;
import com.learn.api.redis.services.RedisService;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Override
    public Long findIntegral(Long accountId) {
//        return this.zscoreToString(RedisKey.INTEGRAL, accountId.toString()).longValue();
        return 0L;
    }

    @Override
    public Long addIntegral(Long accountId, Long integral) {
        return 0L;
    }
}
