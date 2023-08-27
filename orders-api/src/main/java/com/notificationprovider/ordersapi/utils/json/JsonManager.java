package com.notificationprovider.ordersapi.utils.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notificationprovider.ordersapi.exception.JsonManagerException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JsonManager implements ApplicationContextAware {

    private static ObjectMapper objectMapper;

    public static <C> C readJson(String json, Class<C> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new JsonManagerException(e);
        }
    }

    public static <T> String createJson(T object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new JsonManagerException(e);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        objectMapper = applicationContext.getBean(ObjectMapper.class);
    }
}
