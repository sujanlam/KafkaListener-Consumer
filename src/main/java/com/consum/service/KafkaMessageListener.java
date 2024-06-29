package com.consum.service;

import com.consum.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class KafkaMessageListener {

    @RetryableTopic(attempts = "4", backoff= @Backoff(delay=3000, multiplier=1.5, maxDelay=15000) //This will attempt 3 times
    @KafkaListener(topics = "strange-topic", groupId = "sample_group", topicPartitions = {@TopicPartition(topic = "strange-topic", partitions = "2")})
    public void consumeEvents(Customer customer){
        log.info("Consumer received message: {} ",customer.toString());
    }

}
