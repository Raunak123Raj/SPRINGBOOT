package in.ashokit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import in.ashokit.binding.Country;

@Configuration
public class RedisConfig {

	@Bean
	public JedisConnectionFactory jedisConn() {
		JedisConnectionFactory jedis = new JedisConnectionFactory();
		// Redis server properties
		return jedis;
	}

	@Bean
	public RedisTemplate<String, Country> redisTemplate() {
		RedisTemplate<String, Country> rt = new RedisTemplate<>();
		rt.setConnectionFactory(jedisConn());
		return rt;
	}
}

