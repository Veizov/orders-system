package com.notificationprovider.ordersconsumer;

import com.notificationprovider.ordersconsumer.utils.appinfo.AppInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OrdersConsumerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(OrdersConsumerApplication.class, args);
        AppInfo.logApplicationInfo(run);
    }

}
