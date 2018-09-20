package models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class Address {
    private String houseNumber, street, town, city, postcode;

    public Address() {};

    public Address(String houseNumber, String street, String town, String city, String postcode) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.town = town;
        this.city = city;
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "addressDetails: {\n" +
            "\t\thouseNumber: " + getHouseNumber() +
            ",\n\t\tstreet: " + getStreet() +
            ",\n\t\ttown: " + getTown() +
            ",\n\t\tcity: " + getCity() +
            ",\n\t\tpostcode: " + getPostcode() + "\n\t},\n";
    }
}
