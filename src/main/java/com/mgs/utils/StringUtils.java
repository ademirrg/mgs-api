package com.mgs.utils;

public class StringUtils {

    public static String removeMask(String string) {
        return string == null ? null : string.replaceAll("\\D", "");
    }
}
