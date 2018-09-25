package com.moneysupermarket.milestonetwo.util;

import java.io.File;

public class FileUtil {

    public String getCsvFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName + ".csv").getFile());
        return file.toString();
    }
}
