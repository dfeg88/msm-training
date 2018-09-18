import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProfileDao implements GenericDao<Profile> {

    public ProfileDao() {}

    public void save(Profile profile) {
        ObjectMapper objectMapper = new ObjectMapper();
        String FILE_PATH = "./files/" + profile.getCustomer().getFirstName() + profile.getCustomer().getLastName() + ".json";

        try {
            objectMapper.writeValue(new File(FILE_PATH), profile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Profile> getProfilesFromCSV(List<Profile> profiles) throws IOException {
        Reader csvReader = new FileReader("./resources/MOCK_DATA.csv");
        Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(csvReader);
        records.forEach(record -> {
            profiles.add(new Profile(
                new Address(record.get("houseNumber"), record.get("street"), record.get("town"), record.get("city"), record.get("postcode")),
                new Customer(record.get("firstName"), record.get("lastName")),
                new Car(record.get("carRegistration"), record.get("carMake"), record.get("carModel"), Double.valueOf(record.get("carEngineSize")))
            ));
        });

        return profiles;
    }
}
