package com.hailong.www.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.hailong.www.event.EventPublish;
import com.hailong.www.event.LoginSuccessEvent;
import com.hailong.www.mapper.SchoolMapper;
import com.hailong.www.mapper.UserMapper;
import com.hailong.www.model.Person;
import com.hailong.www.model.Pig;
import com.hailong.www.model.School;
import com.hailong.www.model.User;
import com.hailong.www.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    private User user01;
    @Autowired
    private User user02;
    @Autowired
    private Pig pig;
    @Autowired
    private Person person;
    @Autowired
    private SchoolMapper schoolMapper;

    @Autowired
    private EventPublish eventPublish;

    /**
     * 插入数据
     *
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
     *
     * @return 删除的条数
     */
    @RequestMapping("delete")
    public int delete() {
        return userMapper.deleteById(6);
    }

    /**
     * 更新一条数据
     *
     * @return
     */
    @RequestMapping("update")
    public int update() {
        User user = userMapper.selectById(7);
        user.setName("海龙");
        return userMapper.updateById(user);
    }

    /**
     * 根据id查找一条数据
     *
     * @return
     */
    @RequestMapping("select")
    public User select() {
        User user = userMapper.selectById(7);
        user.setSchool(schoolMapper.getSchoolById(user.getSchoolId()));
        return user;
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
     *
     * @return
     */
    @RequestMapping("/redis")
    public Object redis() throws JsonProcessingException {
        /*存取 字符串*/
//        stringRedisTemplate.opsForValue().set("key-01","value-02");
//        Object key01 = stringRedisTemplate.opsForValue().get("key-01");
//        return key01;

        /*对象转json 然后存redis*/
//        User user = userMapper.selectById(3);
//        JsonMapper jsonMapper = new JsonMapper();
//        String userStr = jsonMapper.writeValueAsString(user);
//        stringRedisTemplate.opsForValue().set("user-string",userStr);
//        Object redisUserString = stringRedisTemplate.opsForValue().get("user-string");
//        return redisUserString;

        /*对象直接存redis*/
        User user = userMapper.selectById(3);
        String userKey = "userModel";
        redisTemplate.opsForValue().set(userKey, user);
        User u = (User) redisTemplate.opsForValue().get(userKey);
        return u;
    }

    @RequestMapping("test")
    public String test() {
//        return user01.getName();
//        return user02.getName();
        return pig.getName();
    }

    @RequestMapping("log")
    public String log(HttpServletRequest request) {
        log.info("request");
        log.info(request.getRequestURI());
        return "hello";
    }


    @RequestMapping("/person")
    public Person person() {
        person.setName("hailong123456");
        person.setAge(33);
        return person;
    }

    @GetMapping("school/{id}")
    public School getSchool(@PathVariable("id") Long id) {
        return schoolMapper.getSchoolById(id);
    }

    @GetMapping("login")
    public String login(@RequestParam("username") String username, @RequestParam("passwd") String passwd) {

        User user = new User();
        user.setName(username);
        LoginSuccessEvent event = new LoginSuccessEvent(user);
        eventPublish.sendEvent(event);
        return username + "登录成功";
    }

}
