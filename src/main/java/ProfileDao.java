import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProfileDao implements Dao<Profile> {

    public ProfileDao() {}

    @Override
    public void save(Profile profile) {
        String FILE_PATH = "./files/" + profile.getCustomer().getFirstName() + profile.getCustomer().getLastName() + ".txt";
        File file = new File(FILE_PATH);
        String customerName = profile.getCustomer().getFirstName() + " " + profile.getCustomer().getLastName();

        try {
            if (file.createNewFile()) {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH));
                bufferedWriter.write(profile.toString());
                bufferedWriter.close();
                System.out.println("File created for customer " + customerName);
            } else {
                System.out.println("File for " + customerName + " already exists..");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
