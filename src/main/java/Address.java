public class Address {
    private String houseNumber, street, town, city, postcode;

    public Address() {};

    public Address(String houseNumber, String street, String town, String city, String postcode) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.town = town;
        this.city = city;
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return
            "houseNumber:" + houseNumber +
            ", street:" + street +
            ", town:" + town +
            ", city:" + city +
            ", postcode:" + postcode + ", ";
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
