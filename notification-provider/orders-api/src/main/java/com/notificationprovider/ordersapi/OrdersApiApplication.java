package com.notificationprovider.ordersapi;

import com.notificationprovider.ordersapi.utils.appinfo.AppInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OrdersApiApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(OrdersApiApplication.class, args);
        AppInfo.logApplicationInfo(run);
    }

}
