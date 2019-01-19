package com.example.activitymq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
@EnableScheduling
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    /**
     * 每隔3秒发送一次消息
     */
    @Scheduled(fixedDelay = 3000)
    public void send(){
        jmsMessagingTemplate.convertAndSend(queue,System.currentTimeMillis()+"==============测试消息");
    }
}
