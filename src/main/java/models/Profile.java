package models;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
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
        return "{\n" + getCar() + getAddress() + getCustomer() + "\n}";
    }

    public Car getCar() {
        return car;
    }

    public Address getAddress() {
        return address;
    }

    public Customer getCustomer() {
        return customer;
    }
}
