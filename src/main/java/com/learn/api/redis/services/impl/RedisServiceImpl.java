package com.learn.api.redis.services.impl;

import com.learn.api.redis.RedisKey;
import com.learn.api.redis.services.RedisService;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl extends RedisService {

    @Override
    public Long addIntegral(Long accountId, Long integral) {
        Double integralNumber = this.zincrbyToString(RedisKey.INTEGRAL, accountId.toString(), integral.doubleValue());
        return null == integralNumber ? 0 : integralNumber.longValue();
    }

    @Override
    public Long getIntegralNumber(Long accountId) {
//        Double integralNumber = this.zscoreToString(RedisKey.INTEGRAL, accountId.toString());
//        return null == integralNumber ? 0 : integralNumber.longValue();
        return 0L;
    }

    @Override
    public Long lookArticle(Long userId, Long articleId) {
        Double lookNumber = this.zscoreToString(RedisKey.LOOK, articleId.toString());
        return null == lookNumber ? 0 : lookNumber.longValue();
    }

    @Override
    public Long getLookNumber(Long articleId) {
//        Double lookNumber = this.zscoreToString(RedisKey.INTEGRAL, articleId.toString());
//        return null == lookNumber ? 0 : lookNumber.longValue();
        return 0L;
    }

    @Override
    public Long likeArticle(Long userId, Long articleId) {
        Double articleNumber = this.zscoreToString(RedisKey.LIKE, articleId.toString());
        return null == articleNumber ? 0 : articleNumber.longValue();
    }

    @Override
    public Long getLikeNumber(Long articleId) {
//        Double likeNumber = this.zscoreToString(RedisKey.LIKE, articleId.toString());
//        return null == likeNumber ? 0 : likeNumber.longValue();
        return 0L;
    }

    @Override
    public Long commentArticle(Long userId, Long articleId) {
        Double commentNumber = this.zscoreToString(RedisKey.COMMENT, articleId.toString());
        return null == commentNumber ? 0 : commentNumber.longValue();
    }

    @Override
    public Long getCommentNumber(Long articleId) {
        Double commentNumber = this.zscoreToString(RedisKey.COMMENT, articleId.toString());
        return null == commentNumber ? 0 : commentNumber.longValue();
    }

}
