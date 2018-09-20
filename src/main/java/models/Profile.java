package models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
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

}
