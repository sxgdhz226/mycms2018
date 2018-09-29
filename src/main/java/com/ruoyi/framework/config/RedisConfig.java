package com.ruoyi.framework.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;
import java.util.Map;

@Configuration
public class RedisConfig  extends CachingConfigurerSupport {
    @Bean
    public static RedisTemplate<String, List<Map<String, Object>>> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, List<Map<String, Object>>> template = new RedisTemplate<String, List<Map<String, Object>>>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }

    /**
     * 必须配置缓存管理器否则不生效
     * @return
     */
//    @Bean
//    public CacheManager cacheManager() {
//        return new ConcurrentMapCacheManager("'menu_'+menu");
//    }
}
