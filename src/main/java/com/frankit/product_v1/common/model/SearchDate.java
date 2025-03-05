package com.frankit.product_v1.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SearchDate {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
}