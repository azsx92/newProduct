package com.frankit.product_v1.util;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.BiConsumer;

public final class WherePredicate {
    private BooleanBuilder builder;

    private WherePredicate() {
        this.builder = new BooleanBuilder();
    }

    public static WherePredicate builder() {
        return new WherePredicate();
    }

    public Predicate build() {
        return builder;
    }

    public WherePredicate expression(boolean condition, String[] values, BiConsumer<BooleanBuilder, String[]> func) {
        if (condition) {
            func.accept(builder, values);
        }


        return this;
    }

    public WherePredicate andEqual(StringPath path, String value) {
        if (StringUtils.isNotBlank(value)) {
            builder.and(path.eq(value));
        }

        return this;
    }

    public WherePredicate andNotEqual(StringPath path, String value) {
        if (StringUtils.isNotBlank(value)) {
            builder.and(path.ne(value));
        }

        return this;
    }

    public WherePredicate andEqual(NumberPath<Long> path, Long value) {
        if (value != null) {
            builder.and(path.eq(value));
        }

        return this;
    }


    public WherePredicate andEqual(BooleanPath path, boolean value) {
        if (value) {
            builder.and(path.eq(value));
        }

        return this;
    }

    public WherePredicate andLikeAll(StringPath path, String value) {
        if (StringUtils.isNotBlank(value)) {
            builder.and(path.contains(value));
        }

        return this;
    }

    public WherePredicate orLikeAll(StringPath path, String value) {
        if (StringUtils.isNotBlank(value)) {
            builder.or(path.contains(value));
        }

        return this;
    }

    public WherePredicate andLikeStartWith(StringPath path, String value) {
        if (StringUtils.isNotBlank(value)) {
            builder.and(path.startsWith(value));
        }

        return this;
    }

    public WherePredicate andLikeEndWith(StringPath path, String value) {
        if (StringUtils.isNotBlank(value)) {
            builder.and(path.endsWith(value));
        }

        return this;
    }

    public WherePredicate andIn(StringPath path, String... values) {
        if (StringUtils.isNoneEmpty(values)) {
            builder.and(path.in(values));
        }

        return this;
    }

    public WherePredicate andBetween(StringPath path, String from, String to) {
        if (StringUtils.isNotBlank(from) && StringUtils.isNotBlank(to)) {
            builder.and(path.between(from, to));
        }

        return this;
    }

    public WherePredicate orBetween(StringPath path, String from, String to) {
        if (StringUtils.isNotBlank(from) && StringUtils.isNotBlank(to)) {
            builder.or(path.between(from, to));
        }

        return this;
    }

    public WherePredicate andBetween(StringPath path, boolean condition, String from, String to) {
        if (condition) {
            builder.and(path.between(from, to));
        }

        return this;
    }

    public WherePredicate andBetween(DateTimePath<LocalDateTime> path, String from, String to) {
        if (StringUtils.isNotBlank(from) && StringUtils.isNotBlank(to)) {
            LocalDateTime fromLdt = fromLocalDateTime(from);
            LocalDateTime toLdt = toLocalDateTime(to).plusDays(1);

            builder.and(path.between(fromLdt, toLdt));
        }

        return this;
    }

    public WherePredicate andBetween(DateTimePath<LocalDateTime> path, boolean condition, String from, String to) {
        if (condition) {
            return andBetween(path, from, to);
        }

        return this;
    }

    public static LocalDateTime fromLocalDateTime(String dt) {
        if (dt.length() == 8) {
            return LocalDate.parse(dt, DateTimeFormatter.BASIC_ISO_DATE).atStartOfDay();
        } else if (dt.length() == 6) {
            return LocalDate.parse(dt + "01", DateTimeFormatter.BASIC_ISO_DATE).atStartOfDay();
        } else if (dt.length() == 4) {
            return LocalDate.parse(dt + "0101", DateTimeFormatter.BASIC_ISO_DATE).atStartOfDay();
        } else {
            throw new IllegalArgumentException(String.format("일자형식 오류[%s]", dt));
        }
    }

    public static LocalDateTime toLocalDateTime(String dt) {
        if (dt.length() == 8) {
            return LocalDate.parse(dt, DateTimeFormatter.BASIC_ISO_DATE).atStartOfDay().plusDays(1);
        } else if (dt.length() == 6) {
            return LocalDate.parse(dt + "01", DateTimeFormatter.BASIC_ISO_DATE).atStartOfDay().plusMonths(1);
        } else if (dt.length() == 4) {
            return LocalDate.parse(dt + "0101", DateTimeFormatter.BASIC_ISO_DATE).atStartOfDay().plusYears(1);
        } else {
            throw new IllegalArgumentException(String.format("일자형식 오류[%s]", dt));
        }
    }

}
