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
        return "{" + car + address + customer + " }";
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
}
