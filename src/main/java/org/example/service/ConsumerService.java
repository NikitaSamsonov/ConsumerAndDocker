package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumerService {

    @KafkaListener(topics = "myserver.public.todo",
            groupId = "nodejs-consumer")
    public void consume(Object message) {
       log.info(message.toString());
    }
}
