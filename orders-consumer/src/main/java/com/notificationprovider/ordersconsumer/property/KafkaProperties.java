package com.notificationprovider.ordersconsumer.property;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class KafkaProperties {

    @Value("${kafka.order.bootstrap-servers:#{null}}")
    private String bootstrapServers;

    @Value("${kafka.order.group:#{null}}")
    private String orderGroupId;

    @Value("${kafka.order.topic.created-order.name:#{null}}")
    private String createdOrderTopic;

}
