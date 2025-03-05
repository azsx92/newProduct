package com.frankit.product_v1.util;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeHelper {

    private static final DateTimeFormatter YEAR_MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyyMM");
    private static final DateTimeFormatter DAY_FORMATTER = DateTimeFormatter.ofPattern("dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HHmmss");
    private static final DateTimeFormatter TIME_4_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter HALF_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final DateTimeFormatter HANGUL_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
    private static final DateTimeFormatter DASH_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_6_FORMATTER = DateTimeFormatter.ofPattern("yyMMdd");
    private static final DateTimeFormatter DATE_8_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final DateTimeFormatter TIME_HAN_FORMATTER = DateTimeFormatter.ofPattern("HH시 mm분");

    // 포맷 메서드
    public static String formatYearMonth(LocalDateTime dateTime) {
        return dateTime.format(YEAR_MONTH_FORMATTER);
    }

    public static String formatDay(LocalDateTime dateTime) {
        return dateTime.format(DAY_FORMATTER);
    }

    public static String formatTime(LocalDateTime dateTime) {
        return dateTime.format(TIME_FORMATTER);
    }

    public static String format4Time(LocalDateTime dateTime) {
        return dateTime.format(TIME_4_FORMATTER);
    }

    public static String formatHalfDatetime(LocalDateTime dateTime) {
        return dateTime.format(HALF_DATETIME_FORMATTER);
    }

    public static String formatHangulDate(LocalDateTime dateTime) {
        return dateTime.format(HANGUL_DATE_FORMATTER);
    }

    public static String formatDashDatetime(LocalDateTime dateTime) {
        return dateTime.format(DASH_DATETIME_FORMATTER);
    }

    public static String formatDatetime(LocalDateTime dateTime) {
        return dateTime.format(DATETIME_FORMATTER);
    }

    public static String formatDate6(LocalDateTime dateTime) {
        return dateTime.format(DATE_6_FORMATTER);
    }

    public static String formatDate8(LocalDateTime dateTime) {
        return dateTime.format(DATE_8_FORMATTER);
    }

    public static String formatHanTime(LocalDateTime dateTime) {
        return dateTime.format(TIME_HAN_FORMATTER);
    }

    // 파싱 메서드
    public static LocalDateTime parseYearMonth(String text) {
        return LocalDateTime.parse(text, YEAR_MONTH_FORMATTER);
    }

    public static LocalDateTime parseDatetime(String text) {
        return LocalDateTime.parse(text, DATETIME_FORMATTER);
    }

    public static LocalDateTime parseDate8(String text) {
        return LocalDate.parse(text, DATE_8_FORMATTER).atStartOfDay();
    }

    public static LocalDateTime parseHalfDatetime(String text) {
        return LocalDateTime.parse(text, HALF_DATETIME_FORMATTER);
    }

    // Timestamp 관련 메서드
    public static LocalDateTime timestampToDateTime(String timestampStr) {
        long timestamp = Long.parseLong(timestampStr);
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault());
    }

    public static long dateTimeToTimestamp(LocalDateTime dateTime) {
        return dateTime.toEpochSecond(ZoneOffset.UTC);
    }

    // 기타 메서드
    public static LocalDateTime toFirstDate(int year, int month) {
        return LocalDateTime.of(year, month, 1, 0, 0);
    }

    public static LocalDateTime toLastDate(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        return LocalDateTime.of(year, month, yearMonth.lengthOfMonth(), 23, 59, 59);
    }

    public static int getLastDay(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        return yearMonth.lengthOfMonth();
    }

    public static String getCurrentDateTime() {
        return formatDatetime(LocalDateTime.now());
    }

    public static String getCurrentDate() {
        return formatDate8(LocalDateTime.now());
    }

    public static LocalDateTime parseDateWithDash(String text) {
        text = text.replace("\"", ""); // 큰따옴표 제거
        return LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay();
    }

}
