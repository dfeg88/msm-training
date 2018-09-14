public class Entry {

    private static Profile profileOne;
    private static Profile profileTwo;
    private static Profile profileThree;

    public static void main (String[] args) {

        createProfiles();

        System.out.println(profileOne.toString());
        System.out.println(profileTwo.toString());
        System.out.println(profileThree.toString());

    }

    private static void createProfiles() {
        Address addressOne = new Address("test1", "test1", "test1", "test1", "test1");
        Address addressTwo = new Address("test1", "test1", "test1", "test1", "test1");
        Address addressThree = new Address("test1", "test1", "test1", "test1", "test1");

        Customer customerOne = new Customer("Dan", "Fegan");
        Customer customerTwo = new Customer("Tom", "Fegan");
        Customer customerThree = new Customer("Adam", "Fegan");

        Car carOne = new Car("E57 VKD", "Ford", "Focus", 2.4);
        Car carTwo = new Car("FFF FFF", "Toyota", "Kanban", 7.0);
        Car carThree = new Car("GGG GGG", "Jaguar", "JJJ", 4.2);

        profileOne = new Profile(addressOne, customerOne, carOne);
        profileTwo = new Profile(addressTwo, customerTwo, carTwo);
        profileThree = new Profile(addressThree, customerThree, carThree);
    }

}
