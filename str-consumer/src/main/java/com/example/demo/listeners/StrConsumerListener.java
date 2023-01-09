package com.example.demo.listeners;

import com.example.demo.custom.StrConsumerCustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    @StrConsumerCustomListener(groupId = "1")
    public void listener(String msg){
        log.info("CREATE ::: message = {}", msg);
    }

    @StrConsumerCustomListener(groupId = "1")
    public void log(String msg){
        log.info("LOG ::: Receive message = {}", msg);
    }

    @KafkaListener(groupId = "2", topics ="my-topic", containerFactory = "validMessageContainerFactory")
    public void history(String msg){
        log.info("HISTORY ::: Receive message = {}", msg);
    }

}
