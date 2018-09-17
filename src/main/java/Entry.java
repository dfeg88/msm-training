import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Entry {

    private static List<Profile> profiles = new ArrayList<>();

    public static void main (String[] args) {
        Profile profile = new Profile();
        profiles = profile.createProfiles();
        writeProfileJsonToTextFile();
    }

    private static void writeProfileJsonToTextFile() {
        profiles.forEach(profile -> {
            String FILE_PATH = "./files/" + profile.getCustomer().getFirstName() + profile.getCustomer().getLastName() + ".txt";
            String customerName = profile.getCustomer().getFirstName() + " " + profile.getCustomer().getLastName();
            File file = new File(FILE_PATH);

            try {
                if (file.createNewFile()) {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH));
                    bufferedWriter.write(profile.toString());
                    bufferedWriter.close();
                    System.out.println("File created for customer " + customerName);
                } else {
                    System.out.println("File for " + customerName +  " already exists..");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

}
