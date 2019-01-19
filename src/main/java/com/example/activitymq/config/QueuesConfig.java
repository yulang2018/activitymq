package com.example.activitymq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;
import javax.jms.Session;

@Configuration
public class QueuesConfig {
    @Value("${queues}")
    private String queues;

    /**
     * 创建queues的bean
     * @return
     */
    @Bean
    public Queue queue(){
        return new ActiveMQQueue(queues);
    }

   /* @Bean
    public JmsTemplate jmsTemplate(ActiveMQConnectionFactory activeMQConnectionFactory, Queue queue){
        JmsTemplate jmsTemplate=new JmsTemplate();
        jmsTemplate.setDeliveryMode(2);//持久化配置---1.非持久化配置---2.持久化配置
        jmsTemplate.setConnectionFactory(activeMQConnectionFactory);
        jmsTemplate.setDefaultDestination(queue);
        jmsTemplate.setSessionAcknowledgeMode(4);//客户端签收模式
        return jmsTemplate;
    }

    @Bean("jmsQueuesListener")
    public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory(ActiveMQConnectionFactory activeMQConnectionFactory){
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory=new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setConnectionFactory(activeMQConnectionFactory);
        defaultJmsListenerContainerFactory.setConcurrency("1-10");
        defaultJmsListenerContainerFactory.setRecoveryInterval(1000L);
        defaultJmsListenerContainerFactory.setSessionAcknowledgeMode(4);
        return defaultJmsListenerContainerFactory;
    }*/
}
