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

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

}
