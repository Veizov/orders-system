package com.notificationprovider.ordersapi.property;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class KafkaProperties {

    @Value("${kafka.order.topic.process-order:#{null}}")
    private String processOrderTopic;

    @Value("${kafka.order.bootstrap-servers:#{null}}")
    private String bootstrapServers;

}
