package com.valhalla.utils;

public class Utils {
    public static String removeSpace(String query) {
        if (query == null) {
            throw new IllegalArgumentException("NO INCOMING FORCES!!");
        }
        return query.replaceAll("\\s+", "");
    }
}
