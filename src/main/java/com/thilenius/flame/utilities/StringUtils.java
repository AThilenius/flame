package com.thilenius.flame.utilities;

public class StringUtils {

    public static String Shrink (String fullString, String secondaryString, String truncateString, int maxSize) {
        if (fullString.length() <= maxSize) {
            return fullString;
        }

        if (secondaryString.length() <= maxSize) {
            return secondaryString;
        }

        if (truncateString.length() <= maxSize) {
            return truncateString;
        }

        return truncateString.substring(0, maxSize - 1);
    }

    public static boolean nullOrEmpty (String str) {
        return str == null || str.isEmpty();

    }

}
