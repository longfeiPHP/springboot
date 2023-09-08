package com.hailong.www.service;

import com.hailong.www.event.LoginSuccessEvent;
import com.hailong.www.model.User;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * 模拟登录成功事件驱动开发  <LoginSuccessEvent>表示只该事件
 */
@Service
public class AccountService implements ApplicationListener<LoginSuccessEvent> {
    public void addAccount(String username) {
        System.out.println("登录成功：" + username + "添加积分成功");
    }

    @Override
    public void onApplicationEvent(LoginSuccessEvent event) {
        User user = (User) event.getSource();
        addAccount(user.getName());
    }
}
