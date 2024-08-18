package com.dingjiaxiong.subject.application.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "first-topic", consumerGroup = "test-consumer")
@Slf4j
public class TestConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        System.out.println("接受到mq了" + s);
    }

}
