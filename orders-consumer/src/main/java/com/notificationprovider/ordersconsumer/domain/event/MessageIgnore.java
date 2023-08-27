package com.notificationprovider.ordersconsumer.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(staticName = "newInstance")
public class MessageIgnore {

    private boolean ignore;
    private boolean acknowledge;

    public static MessageIgnore ignore() {
        return newInstance(true, false);
    }

    public static MessageIgnore ignoreAndAcknowledge() {
        return newInstance(true, true);
    }

    public static MessageIgnore proceed() {
        return newInstance(false, false);
    }

}