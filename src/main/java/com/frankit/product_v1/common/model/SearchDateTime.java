package com.frankit.product_v1.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SearchDateTime{
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    public LocalDateTime getStartDate(){
        if (startDate != null) {
            ZoneId zoneId = ZoneId.of("Asia/Seoul");
            LocalDate toDateTime = startDate.toInstant().atZone(zoneId).toLocalDate();
            return toDateTime.atStartOfDay();
        }
        return null;
    }

    public LocalDateTime getEndDate(){
        if (endDate != null) {
            ZoneId zoneId = ZoneId.of("Asia/Seoul");
            LocalDate toDateTime = endDate.toInstant().atZone(zoneId).toLocalDate();
            return   toDateTime.atTime(23, 59, 59, 999999999);
        }
        return null;
    }
}