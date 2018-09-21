package models;

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
public class Customer {

    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "\tcustomerDetails: {\n" +
            "\t\tfirstName: " + getFirstName() +
            ",\n\t\tlastName: " + getLastName() + "\n\t}";
    }
}
