import java.util.ArrayList;
import java.util.List;

public class Profile {
    private Car car = new Car();
    private Address address = new Address();
    private Customer customer = new Customer();

    public Profile() {}

    public Profile(Address address, Customer customer, Car car) {
        this.address = address;
        this.customer = customer;
        this.car = car;
    }

    @Override
    public String toString() {
        return "{\n" + car + address + customer + "\n}";
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Profile> createProfiles() {
        List<Profile> profiles = new ArrayList<>();

        List<Car> cars = car.createCars();
        List<Address> addresses = address.createAddresses();
        List<Customer> customers = customer.createCustomers();

        for (int i = 0; i < 3; i++) {
            profiles.add(0, new Profile(addresses.get(i), customers.get(i), cars.get(i)));
        }

        System.out.print(profiles);

        return profiles;
    }
}
