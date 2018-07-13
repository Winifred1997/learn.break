package com.learn.api.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * Created by wjl on 16/11/2017.
 * RedisMessageSubscriber
 * 监听redis 的 key 触发事件
 */
public class RedisMessageSubscriber implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisMessageSubscriber.class);

    public static final String ORDER_UPDATE = "order:update";

    @Override
    public void onMessage(Message message, byte[] pattern) {
        LOGGER.debug("1、message: {}, pattern: {}", message, pattern);
        String channel = new String(pattern);
        String orderId = new String(message.getBody());
        LOGGER.debug("2、message: {}, pattern: {}", message, channel);
        try {

        } catch (Exception e) {
            LOGGER.error("update order {}:{} error", ORDER_UPDATE, orderId, e);
        }
    }

}
