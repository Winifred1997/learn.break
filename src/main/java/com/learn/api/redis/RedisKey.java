package com.learn.api.redis;

public class RedisKey {

	private static final String SERVER = "learn_";

	/** 签到分数 */
	public final static String INTEGRAL = SERVER + "1";

	/** 浏览数 */
	public final static String LOOK = SERVER + "2";

	/** 点赞数 */
	public final static String LIKE = SERVER + "3";

	/** 评论数 */
	public final static String COMMENT = SERVER + "4";

}
