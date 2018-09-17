import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfileWriter {

    private Profile profile = new Profile();
    private List<Profile> profiles = new ArrayList<>();

    public ProfileWriter() {};

    public void writeProfilesToText() {
        profiles = profile.createProfiles();

        profiles.forEach(profile -> {
            String FILE_PATH = "./files/" + profile.getCustomer().getFirstName() + profile.getCustomer().getLastName() + ".txt";
            String customerName = profile.getCustomer().getFirstName() + " " + profile.getCustomer().getLastName();
            File file = new File(FILE_PATH);

            try {
                if (file.createNewFile()) {
                    BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(FILE_PATH));
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
