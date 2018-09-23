package com.moneysupermarket.milestonetwo.util;

public abstract  class FileUtil {
    public static String getCsvFile(String fileName) {
        return "./src/resources/" + fileName + ".csv";
    }
}
