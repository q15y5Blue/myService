package cn.yqius.config;

import cn.yqius.entity.Users;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    private Jackson2JsonRedisSerializer<Users> serializer;

    @Bean
    ReactiveRedisOperations<String, Users> redisOperations(ReactiveRedisConnectionFactory factory) {
        Jackson2JsonRedisSerializer<Users> serializer = new Jackson2JsonRedisSerializer<>(Users.class);
        RedisSerializationContext.RedisSerializationContextBuilder<String, Users> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
        RedisSerializationContext<String, Users> context = builder.value(serializer).build();
        return new ReactiveRedisTemplate<>(factory, context);
    }
}
