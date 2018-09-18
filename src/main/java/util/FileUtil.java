package util;

public abstract  class FileUtil {
    public static String getCsvFile(String fileName) {
        return "./resources/" + fileName + ".csv";
    }
}
