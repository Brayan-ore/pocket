package com.bootcamp.pocketbook.repository;

import com.bootcamp.pocketbook.model.Pocketbook;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.UUID;

public class PocketbookRepository implements PocketbookRepositoryImpl {
    private static final String KEY = "Pocketbook";


    private RedisTemplate<String, Pocketbook> redisTemplate;
    private HashOperations hashOperations;

    public PocketbookRepository(RedisTemplate<String, Pocketbook> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<String, Pocketbook> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public Pocketbook findById(String id) {
        return (Pocketbook) hashOperations.get(KEY, id);
    }

    @Override
    public void save(Pocketbook pocketbook) {
        hashOperations.put(KEY, UUID.randomUUID().toString(), pocketbook);

    }

    @Override
    public void delete(String id) {
    hashOperations.delete(KEY , id);
    }
}
