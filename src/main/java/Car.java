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
            "\t\tregistrationNumber: " + registrationNumber +
            ",\n\t\tmake: " + make +
            ",\n\t\tmodel: " + model +
            ",\n\t\tengineSize: " + engineSize + "\n\t},\n\t";
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

    private void createCars() {
        Car carOne = new Car("E57 VKD", "Ford", "Focus", 2.4);
        Car carTwo = new Car("FFF FFF", "Toyota", "Kanban", 7.0);
        Car carThree = new Car("GGG GGG", "Jaguar", "JJJ", 4.2);
    }
}
