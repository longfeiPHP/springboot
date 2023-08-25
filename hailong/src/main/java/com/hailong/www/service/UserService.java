package com.hailong.www.service;

import com.hailong.www.mapper.UserMapper;
import com.hailong.www.model.User;
import com.hailong.www.service.i.UserServiceI;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("UserServiceI")
public class UserService implements UserServiceI {
    @Resource
    private UserMapper userMapper;
    @Override
    public int add(User user){
        return this.userMapper.add(user);
    }
}
