package com.notificationprovider.ordersapi.config.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notificationprovider.ordersapi.property.KafkaProperties;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaProducerConfig {

    private final KafkaProperties kafkaProperties;
    private final ObjectMapper objectMapper;

    @Bean
    public <K, V> ProducerFactory<K, V> producerFactory(){
        Map<String,Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        return new DefaultKafkaProducerFactory(config, new StringSerializer(), new JsonSerializer(objectMapper));
    }

    @Bean
    public <K, V> KafkaTemplate<K, V> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}