package com.hailong.www.service;

import com.hailong.www.event.LoginSuccessEvent;
import com.hailong.www.model.User;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * 模拟登录成功事件驱动开发
 */
@Service
public class CouponService {

    @EventListener
    public void onEvent(LoginSuccessEvent loginSuccessEvent){
        User user =(User) loginSuccessEvent.getSource();
        addCoupon(user.getName());
    }
    /**
     * 添加优惠券
     *
     * @param username
     */
    public void addCoupon(String username) {
        System.out.println(username + "优惠券添加成功");
    }
}
