package com.moneysupermarket.milestonetwo.dao;

import com.moneysupermarket.milestonetwo.models.Address;
import com.moneysupermarket.milestonetwo.models.Car;
import com.moneysupermarket.milestonetwo.models.Customer;
import com.moneysupermarket.milestonetwo.models.Profile;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
