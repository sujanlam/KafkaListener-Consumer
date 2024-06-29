//This will attempt 3 times


@RetryableTopic(attempts = "4")
@KafkaListener(topics = "strange-topic", groupId = "sample_group", topicPartitions = {@TopicPartition(topic = "strange-topic", partitions = "2")})
public void consumeEvents(Customer customer){
    log.info("Consumer received message: {} ",customer.toString());
}
