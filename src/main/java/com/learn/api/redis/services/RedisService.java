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

}
