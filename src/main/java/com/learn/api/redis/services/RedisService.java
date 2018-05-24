package com.learn.api.redis.services;

public interface RedisService {

	/**
	 * 查询签到分值
	 * @param accountId
	 * @return
	 */
	Long findIntegral(Long accountId);

	/**
	 * 增加签到积分
	 * @param accountId
	 * @param integral
	 * @return
	 */
    Long addIntegral(Long accountId, Long integral);

	/**
	 * 浏览文章
	 * @param userId
	 * @param articleId
	 * @return
	 */
	Long lookArticle(Long userId, Long articleId);

	/**
	 * 查询文章浏览数
	 * @param articleId
	 * @return
	 */
	Long getLookNumber(Long articleId);

	/**
	 * 对文章点赞
	 * @param userId
	 * @param articleId
	 * @return
	 */
	Long likeArticle(Long userId, Long articleId);

	/**
	 * 查询文章点赞数
	 * @param articleId
	 * @return
	 */
	Long getLikeNumber(Long articleId);

	/**
	 * 评论文章
	 * @param userId
	 * @param articleId
	 * @return
	 */
	Long commentArticle(Long userId, Long articleId);

	/**
	 * 查询文章评论数
	 * @param articleId
	 * @return
	 */
	Long getCommentNumber(Long articleId);
}
