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
            "\t\tfirstName: " + getFirstName() +
            ",\n\t\tlastName: " + getLastName() + "\n\t}";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
