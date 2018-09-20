package models;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Car {

    private String registrationNumber, make, model;
    private double engineSize;

    public Car() {};

    public Car(String registrationNumber, String make, String model, double engineSize) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.engineSize = engineSize;
    }

    @Override
    public String toString() {
        return "\tcarDetails {\n" +
            "\t\tregistrationNumber: " + getRegistrationNumber() +
            ",\n\t\tmake: " + getMake() +
            ",\n\t\tmodel: " + getModel() +
            ",\n\t\tengineSize: " + getEngineSize() + "\n\t},\n\t";
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getEngineSize() {
        return engineSize;
    }

}
