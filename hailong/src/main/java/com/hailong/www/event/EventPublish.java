package com.hailong.www.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * 事件发布器
 */
@Service
public class EventPublish implements ApplicationEventPublisherAware {

    ApplicationEventPublisher applicationEventPublisher;

    /**
     * 使用底层原理发事件
     * @param event
     */
    public void sendEvent(ApplicationEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher=applicationEventPublisher;
    }
}
