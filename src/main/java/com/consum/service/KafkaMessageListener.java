package com.consum.service;

import com.consum.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;


@Service
public class KafkaMessageListener {

    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "strange-topic", groupId = "sample_group", topicPartitions = {@TopicPartition(topic = "strange-topic", partitions = "2")})
    public void consumeEvents(Customer customer){
        log.info("Consumer received message: {} ",customer.toString());
    }

}
