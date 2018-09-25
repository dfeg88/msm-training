package com.moneysupermarket.milestonetwo.models;

import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String houseNumber, street, town, city, postcode;

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
