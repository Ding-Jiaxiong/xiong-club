package com.dingjiaxiong.subject.application.mq;

import com.alibaba.fastjson.JSON;
import com.dingjiaxiong.subject.domain.entity.SubjectLikedBO;
import com.dingjiaxiong.subject.domain.service.SubjectLikedDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@RocketMQMessageListener(topic = "subject-liked", consumerGroup = "subject-liked-consumer")
@Slf4j
public class SubjectLikedConsumer implements RocketMQListener<String> {

    @Resource
    private SubjectLikedDomainService subjectLikedDomainService;

    @Override
    public void onMessage(String s) {
        System.out.println("接受点赞mq,消息为" + s);
        SubjectLikedBO subjectLikedBO = JSON.parseObject(s, SubjectLikedBO.class);
        subjectLikedDomainService.syncLikedByMsg(subjectLikedBO);
    }

}
