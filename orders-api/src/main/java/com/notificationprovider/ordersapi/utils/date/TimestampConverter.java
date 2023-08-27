package com.notificationprovider.ordersapi.utils.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class TimestampConverter {

    public static LocalDateTime toLocalDateTime(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), TimeZone.getDefault().toZoneId());
    }

}
