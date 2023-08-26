package com.notificationprovider.ordersapi.property;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class KafkaProperties {

    @Value("${kafka.order.topic.published-order.name:#{null}}")
    private String publishedOrderTopic;

    @Value("${kafka.order.topic.published-order.partitions-number:#{1}}")
    private Integer partitionsNumber;

    @Value("${kafka.order.bootstrap-servers:#{null}}")
    private String bootstrapServers;



}
