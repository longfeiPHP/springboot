package com.hailong.www;

import com.hailong.www.mapper.UserMapper;
import com.hailong.www.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.util.Assert;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.isTrue(5 == userList.size(), "");
        userList.forEach(System.out::println);
    }

    @Test
    public void testRedis() {
        /*string*/
//        redisTemplate.opsForValue().set("haha", UUID.randomUUID().toString());
//        String haha = redisTemplate.opsForValue().get("haha");
//        System.out.println(haha);
        /*list*/
        String listName = "test";
//        redisTemplate.opsForList().leftPush(listName,"1");
//        redisTemplate.opsForList().leftPush(listName,"2");
//        redisTemplate.opsForList().leftPush(listName,"3");
//        redisTemplate.opsForList().leftPop(listName);
        /*set*/
//        redisTemplate.opsForSet().add(listName,"1","2","3");
//        Boolean a = redisTemplate.opsForSet().isMember(listName,"2");
//        Assertions.assertTrue(a);
//        Boolean b = redisTemplate.opsForSet().isMember(listName,"5");
//        Assertions.assertFalse(b);
        /*zset*/
        listName = "testZset";
        redisTemplate.opsForZSet().add(listName,"张三",90);
        redisTemplate.opsForZSet().add(listName,"李四",80);
        redisTemplate.opsForZSet().add(listName,"王五",70);
        ZSetOperations.TypedTuple<String> popMax = redisTemplate.opsForZSet().popMax(listName);
        String value = popMax.getValue();
        Double score = popMax.getScore();
        System.out.println(value);
        System.out.println(score);
    }

}
