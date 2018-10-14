package com.ruoyi.framework.config.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * kafka消息消费者
 */
@Component
public class MsgConsumer {

    @KafkaListener(topics = {"firsttopic"})
    public void processMessage(String content) {
        System.out.println(content+"==============================");
    }
}
