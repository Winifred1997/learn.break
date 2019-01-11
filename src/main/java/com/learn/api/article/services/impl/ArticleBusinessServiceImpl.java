package com.learn.api.article.services.impl;

import com.learn.api.article.services.ArticleBusinessService;
import com.learn.api.redis.services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleBusinessServiceImpl implements ArticleBusinessService {

    @Autowired
    RedisService redisService;

    @Override
    public Long lookArticle(Long articleId) {
        return redisService.lookArticle(articleId);
    }

    @Override
    public Long getLookNumber(Long articleId) {
        return redisService.getLookNumber(articleId);
    }

    @Override
    public Long likeArticle(Long userId, Long articleId) {
        return redisService.likeArticle(userId, articleId);
    }

    @Override
    public Long getLikeNumber(Long articleId) {
        return redisService.getLikeNumber(articleId);
    }

    @Override
    public Long commentArticle(Long userId, Long articleId) {
        return redisService.commentArticle(userId, articleId);
    }

    @Override
    public Long getCommentNumber(Long articleId) {
        return redisService.getCommentNumber(articleId);
    }

}
