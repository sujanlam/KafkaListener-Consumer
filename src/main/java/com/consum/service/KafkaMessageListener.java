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

    @KafkaListener(topics = "strange-topic", groupId = "test-sample_topic", topicPartitions = {@TopicPartition(topic = "strange-topic", partitions = "2")})
    public void consume(Customer customer){
        log.info("Consumer received message: {} ",customer.toString());
    }

}
