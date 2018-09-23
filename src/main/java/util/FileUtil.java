package util;

public abstract  class FileUtil {
    public static String getCsvFile(String fileName) {
        return "./src/resources/" + fileName + ".csv";
    }

    public static  String createJsonFile(String firstName, String lastName) {
        return "./files/" + firstName + lastName + ".json";
    }
}
