package com.frankit.product_v1.util;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

public class XssUtils {
    public static String clean(String value) {
        return Jsoup.clean(value, Safelist.basic());
    }
}
