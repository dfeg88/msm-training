package com.moneysupermarket.milestonetwo.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private String registrationNumber, make, model;
    private double engineSize;

    @Override
    public String toString() {
        return "\tcarDetails {\n" +
            "\t\tregistrationNumber: " + getRegistrationNumber() +
            ",\n\t\tmake: " + getMake() +
            ",\n\t\tmodel: " + getModel() +
            ",\n\t\tengineSize: " + getEngineSize() + "\n\t},\n\t";
    }
}
