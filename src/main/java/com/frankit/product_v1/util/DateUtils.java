package com.frankit.product_v1.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class DateUtils {
    public LocalDateTime getStartDate(Date startDate){
        if (startDate != null) {
            ZoneId zoneId = ZoneId.of("Asia/Seoul");
            LocalDate toDateTime = startDate.toInstant().atZone(zoneId).toLocalDate();
            return toDateTime.atStartOfDay();
        }
        return null;
    }

    public LocalDateTime getEndDate(Date endDate){
        if (endDate != null) {
            ZoneId zoneId = ZoneId.of("Asia/Seoul");
            LocalDate toDateTime = endDate.toInstant().atZone(zoneId).toLocalDate();
            return   toDateTime.atTime(23, 59, 59, 0);
        }
        return null;
    }

    public LocalDateTime getDateToLocalDateTime(Date date){
        return getDateToLocalDateTime(date,0,0,0);
    }
    public LocalDateTime getDateToLocalDateTime(Date date,int hour){
        return getDateToLocalDateTime(date,hour,0,0);
    }
    public LocalDateTime getDateToLocalDateTime(Date date,int hour,int minute){
        return getDateToLocalDateTime(date,hour,minute,0);
    }
    public LocalDateTime getDateToLocalDateTime(Date date,int hour,int minute,int second){
        if (date != null) {
            ZoneId zoneId = ZoneId.of("Asia/Seoul");
            LocalDate toDateTime = date.toInstant().atZone(zoneId).toLocalDate();
            return   toDateTime.atTime(hour, minute, second);
        }
        return null;
    }

}