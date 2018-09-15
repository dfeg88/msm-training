import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Entry {

    private static List<Profile> profiles = new ArrayList<>();

    public static void main (String[] args) {

        writeProfileJsonToTextFile();

    }

    private static void writeProfileJsonToTextFile() {
        createProfiles();

        profiles.forEach(profile -> {
            String FILE_PATH = "./files/" + profile.getCustomer().getFirstName() + profile.getCustomer().getLastName() + ".txt";
            File file = new File(FILE_PATH);
            try {
                if (file.createNewFile()) {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH));
                    bufferedWriter.write(profile.toString());
                    bufferedWriter.close();
                    System.out.println("File created for customer " + profile.getCustomer().getFirstName() + " " + profile.getCustomer().getLastName());
                } else {
                    System.out.println("File for " + profile.getCustomer().getFirstName() + " " + profile.getCustomer().getLastName() +  " already exists..");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    private static void createProfiles() {
        Address addressOne = new Address("test1", "test1", "test1", "test1", "test1");
        Address addressTwo = new Address("test1", "test1", "test1", "test1", "test1");
        Address addressThree = new Address("test1", "test1", "test1", "test1", "test1");

        Customer customerOne = new Customer("Dan", "Fegan");
        Customer customerTwo = new Customer("Tom", "Fegan");
        Customer customerThree = new Customer("Adam", "Fegan");

        Car carOne = new Car("E57 VKD", "Ford", "Focus", 2.4);
        Car carTwo = new Car("FFF FFF", "Toyota", "Kanban", 7.0);
        Car carThree = new Car("GGG GGG", "Jaguar", "JJJ", 4.2);

        profiles.add(new Profile(addressOne, customerOne, carOne));
        profiles.add(new Profile(addressTwo, customerTwo, carTwo));
        profiles.add(new Profile(addressThree, customerThree, carThree));
    }

}
