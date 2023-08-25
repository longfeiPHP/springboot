package com.hailong.www.controller;

import com.hailong.www.mapper.UserMapper;
import com.hailong.www.model.User;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserMapper userMapper;

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
        return userMapper.insert(user);
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
}
