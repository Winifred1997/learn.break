//package com.learn.api.redis;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.*;
//
///**
// * Created by wjl on 2018/1/13.
// */
//public class RedisBaseCache {
//
//    /**
//     *
//     */
//    protected Logger LOGGER = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    RedisTemplate<String, String> stringRedisTemplate;
//
//    @Autowired
//    RedisTemplate<String, ICacheBean> objectRedisTemplate;
//
//    /**
//     * 删除给定key
//     *
//     * @param key
//     */
//    public void delToString(String key) {
//        try {
//            stringRedisTemplate.delete(key);
//        } catch (Exception e) {
//            LOGGER.debug("Key delToString Exception key: {}", key);
//        }
//    }
//
//    /**
//     * 删除给定key
//     *
//     * @param key
//     */
//    public void delToObject(String key) {
//        try {
//            objectRedisTemplate.delete(key);
//        } catch (Exception e) {
//            LOGGER.debug("Key delToObject Exception key: {}", key);
//        }
//    }
//
//    /**
//     * 序列化给定 key ，并返回被序列化的值
//     *
//     * @param key 键
//     */
//    public void dumpToString(String key) {
//        try {
//            stringRedisTemplate.dump(key);
//        } catch (Exception e) {
//            LOGGER.debug("Key dumpToString Exception key: {}", key);
//        }
//    }
//
//    /**
//     * 序列化给定 key ，并返回被序列化的值
//     *
//     * @param key 键
//     */
//    public void dumpToObject(String key) {
//        try {
//            objectRedisTemplate.dump(key);
//        } catch (Exception e) {
//            LOGGER.debug("Key dumpToObject Exception key: {}", key);
//        }
//    }
//
//    /**
//     * redis是否有key
//     *
//     * @param key 键
//     * @return
//     */
//    public boolean existsToString(String key) {
//        try {
//            return stringRedisTemplate.hasKey(key);
//        } catch (Exception e) {
//            LOGGER.debug("Key existsToString Exception key: {}", key);
//        }
//        return false;
//    }
//
//    /**
//     * redis是否有key
//     *
//     * @param key 键
//     * @return
//     */
//    public boolean existsToObject(String key) {
//        try {
//            return objectRedisTemplate.hasKey(key);
//        } catch (Exception e) {
//            LOGGER.debug("Key existsToObject Exception key: {}", key);
//        }
//        return false;
//    }
//
//    /** ZSet -------------------------------------------------------------*/
//    /**
//     * 为有序集 key 的成员 member 的 score 值加上增量 increment
//     *
//     * @param key 键
//     * @param member 成员
//     * @param increment 增量
//     * @return
//     */
//    public Double zincrbyToString(String key, String member, Double increment) {
//        try {
//            return stringRedisTemplate.opsForZSet().incrementScore(key, member, increment);
//        } catch (Exception e) {
//            LOGGER.debug("Key zincrbyToString Exception key: {}", key);
//        }
//        return 0D;
//    }
//
//    /**
//     * 为有序集 key 的成员 member 的 score 值加上增量 increment
//     *
//     * @param key 键
//     * @param member 成员
//     * @param increment 增量
//     * @return
//     */
//    public Double zincrbyToObject(String key, ICacheBean member, Double increment) {
//        try {
//            return objectRedisTemplate.opsForZSet().incrementScore(key, member, increment);
//        } catch (Exception e) {
//            LOGGER.debug("Key zincrbyToObject Exception key: {}", key);
//        }
//        return 0D;
//    }
//
//    /**
//     * 返回有序集 key 中，成员 member 的 score 值。
//     *
//     * @param key 键
//     * @param member 成员
//     * @return
//     */
//    public Double zscoreToString(String key, String member) {
//        try {
//            return stringRedisTemplate.opsForZSet().score(key, member);
//        } catch (Exception e) {
//            LOGGER.debug("Key zscoreToString Exception key: {}", key);
//        }
//        return 0D;
//    }
//
//    /**
//     * 返回有序集 key 中，成员 member 的 score 值。
//     *
//     * @param key 键
//     * @param member 成员
//     * @return
//     */
//    public Double zscoreToObject(String key, ICacheBean member) {
//        try {
//            return objectRedisTemplate.opsForZSet().score(key, member);
//        } catch (Exception e) {
//            LOGGER.debug("Key zscoreToObject Exception key: {}", key);
//        }
//        return 0D;
//    }
//
//}