package com.hailong.www.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.hailong.www.mapper.UserMapper;
import com.hailong.www.model.User;
import com.hailong.www.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 插入数据
     * @return 插入的条数据
     */
    @RequestMapping("insert")
    public int insert() {
        User user = new User();
        user.setAge(33);
        user.setName("hailong");
        user.setEmail("506698652@qq.com");
        return userService.add(user);/*mybatis*/
//        return userMapper.insert(user);/*mybatis plus*/
    }

    /**
     * 删除一条数据
     * @return 删除的条数
     */
    @RequestMapping("delete")
    public int delete(){
        return userMapper.deleteById(6);
    }

    /**
     * 更新一条数据
     * @return
     */
    @RequestMapping("update")
    public int update(){
        User user = userMapper.selectById(7);
        user.setName("海龙");
        return userMapper.updateById(user);
    }

    /**
     * 根据id查找一条数据
     * @return
     */
    @RequestMapping("select")
    public User select()
    {
        return userMapper.selectById(7);
    }

    /**
     * 查找多条数据
     *
     * @return
     */
    @RequestMapping("/list")
    public List<User> list() {
        List<User> userList = userMapper.selectList(null);
        return userList;
    }

    /**
     * redis 测试
     * @return
     */
    @RequestMapping("/redis")
    public Object redis() throws JsonProcessingException {
        /*存取 字符串*/
        redisTemplate.opsForValue().set("key-01","value-02");
        Object key01 = redisTemplate.opsForValue().get("key-01");
        return key01;

        /*对象转json 然后存redis*/
//        User user = userMapper.selectById(3);
//        JsonMapper jsonMapper = new JsonMapper();
//        String userStr = jsonMapper.writeValueAsString(user);
//        redisTemplate.opsForValue().set("user-string",userStr);
//        Object redisUserString = redisTemplate.opsForValue().get("user-string");
//        return redisUserString;
    }
}
