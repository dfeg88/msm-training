package models;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
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

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getTown() {
        return town;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }
}
