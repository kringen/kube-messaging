package io.kringen.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaAdmin;
//import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;
//import org.springframework.kafka.config.KafkaTopicConfig;
import org.apache.kafka.common.config.TopicConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.Map;


@Configuration
public class KafkaTopicConfig {
    private static final Logger logger = LoggerFactory.getLogger(KafkaTopicConfig.class);
    String kafka_topic = System.getenv("TOPIC_NAME");
    String kafka_server = System.getenv("KAFKA_SERVER");
    String kafka_port = System.getenv("KAFKA_PORT");
    String kafka_connection = String.format("%s:%s", kafka_server, kafka_port);

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafka_connection);
        logger.info(String.format("Creating Admin Context with configs: %s", configs));
        return new KafkaAdmin(configs);
    }
    

    @Bean
    public NewTopic topicOne() {
        logger.info(String.format("Creating topic: %s", kafka_topic));
        return TopicBuilder.name(kafka_topic)
                .partitions(1)
                .replicas(1)
                .config(TopicConfig.COMPRESSION_TYPE_CONFIG, "zstd")
                .build();
    }
}