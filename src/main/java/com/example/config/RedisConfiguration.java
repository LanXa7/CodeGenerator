package com.example.config;

import com.example.utils.FastJson2JsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis序列化
 */
@Configuration
public class RedisConfiguration {


    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        configureRedisTemplate(redisTemplate, redisConnectionFactory);
        return redisTemplate;
    }

    /**
     * 注入方式
     * Resource
     * Qualifier("redisStringTemplate")
     * private RedisTemplate<String, Object> redisTemplate;
     */
    @Bean
    public RedisTemplate<String, Object> redisStringTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        configureRedisTemplate(redisTemplate, redisConnectionFactory);
        return redisTemplate;
    }

    private void configureRedisTemplate(RedisTemplate<?, ?> redisTemplate, RedisConnectionFactory redisConnectionFactory) {
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        FastJson2JsonRedisSerializer<Object> serializer = new FastJson2JsonRedisSerializer<>(Object.class);
        // key 采用 String 的序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // value 序列化方式采用 FastJson2JsonRedisSerializer
        redisTemplate.setValueSerializer(serializer);
        // hash 的 key 也采用 String 的序列化方式
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        // hash 的 value 采用 FastJson2JsonRedisSerializer
        redisTemplate.setHashValueSerializer(serializer);
        redisTemplate.afterPropertiesSet();
    }
}


