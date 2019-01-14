package com.learn.api.redis.services;

import com.learn.api.redis.RedisBaseCache;

public abstract class RedisService extends RedisBaseCache {

	/**
	 * 增加签到积分
	 * @param accountId
	 * @param integral
	 * @return
	 */
	public abstract Long addIntegral(Long accountId, Long integral);

	/**
	 * 查询签到分值
	 * @param accountId
	 * @return
	 */
	public abstract Long getIntegralNumber(Long accountId);

	/**
	 * 浏览文章
	 * @param articleId
	 * @return
	 */
	public abstract Long lookArticle(Long articleId);

	/**
	 * 查询文章浏览数
	 * @param articleId
	 * @return
	 */
	public abstract Long getLookNumber(Long articleId);

	/**
	 * 对文章点赞
	 * @param articleId
	 * @return
	 */
	public abstract Long likeArticle(Long articleId);

	/**
	 * 查询文章点赞数
	 * @param articleId
	 * @return
	 */
	public abstract Long getLikeNumber(Long articleId);

	/**
	 * 评论文章
	 * @param userId
	 * @param articleId
	 * @return
	 */
	public abstract Long commentArticle(Long userId, Long articleId);

	/**
	 * 查询文章评论数
	 * @param articleId
	 * @return
	 */
	public abstract Long getCommentNumber(Long articleId);
}
