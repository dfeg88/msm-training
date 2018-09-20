package dao;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import models.Address;
import models.Car;
import models.Customer;
import models.Profile;
import util.FileUtil;

public class CsvDao {

    private final FileReader fileReader;

    public CsvDao(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public List<Profile> getProfilesFromCSV() throws IOException {
        Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(fileReader);
        List<Profile> profiles = new ArrayList<>();
        records.forEach(record -> profiles.add(new Profile(
            new Address(record.get("houseNumber"), record.get("street"), record.get("town"), record.get("city"), record.get("postcode")),
            new Customer(record.get("firstName"), record.get("lastName")),
            new Car(record.get("carRegistration"), record.get("carMake"), record.get("carModel"), Double.valueOf(record.get("carEngineSize")))
        )));

        return profiles;
    }

}
