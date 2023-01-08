package com.kafka.strproducer.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class StringProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg){
        kafkaTemplate.send("my-topic", msg).addCallback(
                success -> {
                    if(success != null){
                        log.info("m=sendMessage msg={}", msg);
                        log.info("particion={}, offseat={}", success.getRecordMetadata().partition(), success.getRecordMetadata().offset());
                    }
                },
                error -> log.info("m=sendMessage stage=error msg={}", msg)
        );
    }

}
