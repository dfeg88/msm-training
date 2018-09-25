package com.moneysupermarket.milestonetwo.models;

import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "\tcustomerDetails: {\n" +
            "\t\tfirstName: " + getFirstName() +
            ",\n\t\tlastName: " + getLastName() + "\n\t}";
    }
}
