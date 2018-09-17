import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String firstName;
    private String lastName;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "\tcustomerDetails: {\n" +
            "\t\tfirstName: " + firstName +
            ",\n\t\tlastName: " + lastName + "\n\t}";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Customer> createCustomers() {
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer("Dan", "Fegan"));
        customers.add(new Customer("Tom", "Jones"));
        customers.add(new Customer("Maynard", "Keenan"));

        return customers;
    }

}
