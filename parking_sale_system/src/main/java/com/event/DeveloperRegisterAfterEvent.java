package com.event;
import org.springframework.context.ApplicationEvent;

/**
 * 申请通过后事件
 */
public class DeveloperRegisterAfterEvent extends ApplicationEvent{
    public DeveloperRegisterAfterEvent(Object source) {
        super(source);
        System.out.println("事件发生"+source);
    }
}
