package com.hailong.www.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hailong.www.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * mybatis plus
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Insert("INSERT INTO `user`(name,age,email,created,updated) VALUES(#{name},#{age},#{email},#{created},#{updated})")
    int add(User user);
}
