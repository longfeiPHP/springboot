package com.hailong.www.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hailong.www.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
