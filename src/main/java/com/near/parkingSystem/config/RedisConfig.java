package com.near.parkingSystem.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories(basePackages = "com.near.parkingSystem.redisDatabase.repository")
public class RedisConfig {

  @Bean
  public JedisConnectionFactory redisConnectionFactory(){
    return new JedisConnectionFactory();
  }

}

