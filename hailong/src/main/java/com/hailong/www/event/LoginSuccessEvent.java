package com.hailong.www.event;

import com.hailong.www.model.User;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * 登录成功事件
 */
public class LoginSuccessEvent extends ApplicationEvent
{
    public LoginSuccessEvent(User source) {
        super(source);
    }
}
