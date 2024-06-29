//This will attempt 3 times
===========================================================================================================================================================
Creates:
strange_topic
strange_topic__dlt
strange_topic_0
strange_topic_1
strange_topic_2
[[AFter three attempts, it will be pushed to dead letter topic]]
@RetryableTopic(attempts = "4")
@KafkaListener(topics = "strange-topic", groupId = "sample_group", topicPartitions = {@TopicPartition(topic = "strange-topic", partitions = "2")})
public void consumeEvents(Customer customer){
    log.info("Consumer received message: {} ",customer.toString());
}

DEPENDENCIES REQUIRED FOR TESTING:
===========================================================================================================================================================



<!-- https://mvnrepository.com/artifact/org.testcontainers/testcontainers -->
		<dependency>
			<groupId>org.testcontainers</groupId>
			<artifactId>testcontainers</artifactId>
			<version>1.19.8</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.testcontainers</groupId>
			<artifactId>kafka</artifactId>
			<version>1.19.8</version>
			<scope>test</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.testcontainers/junit-jupiter -->
		<dependency>
			<groupId>org.testcontainers</groupId>
			<artifactId>junit-jupiter</artifactId>
			<version>1.19.8</version>
			<scope>test</scope>
		</dependency>
		<!--This is to make it wait for some time-->
		<!-- https://mvnrepository.com/artifact/org.awaitility/awaitility -->
		<dependency>
			<groupId>org.awaitility</groupId>
			<artifactId>awaitility</artifactId>
			<version>4.2.1</version>
			<scope>test</scope>
		</dependency>
