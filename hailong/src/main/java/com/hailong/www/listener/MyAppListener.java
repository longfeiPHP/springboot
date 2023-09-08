package com.hailong.www.listener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

/**
 * 自定义 spring boot 启动的监听器
 */
public class MyAppListener implements SpringApplicationRunListener {
    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("==========starting===========正在启动============");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        System.out.println("==========environmentPrepared===========环境准备完成============");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("==========contextPrepared===========IOC容器准备完成============");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("==========contextLoaded===========IOC容器加载完成============");
    }

    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("==========started===========容器启动完成============");
    }

    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("==========ready===========应用准备就绪============");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("==========failed===========启动失败============");
    }
}
