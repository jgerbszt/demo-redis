package pl.javour;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisOperations;

public class DemoRepository {
    
    private static final String DEMO_HASH_KEY = "demo-hash";
    private final HashOperations<String, String, String> hashOps;

    public DemoRepository(RedisOperations<String, String> redisTemplate) {
        this.hashOps = redisTemplate.opsForHash();
    }

    public void put(String key, String value) {
        hashOps.put(DEMO_HASH_KEY, key, value);
    }
    
    public String get(String key) {
        return hashOps.get(DEMO_HASH_KEY, key);
    }
    
    public Map<String, String> getAll() {
        return hashOps.entries(DEMO_HASH_KEY);
    }
}
