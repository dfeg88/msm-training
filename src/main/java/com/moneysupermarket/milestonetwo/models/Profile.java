package com.moneysupermarket.milestonetwo.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Profile {
    private Address address;
    private Car car;
    private Customer customer;

    @Override
    public String toString() {
        return "{\n" + getCar() + getAddress() + getCustomer() + "\n}";
    }

}
