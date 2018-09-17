import java.util.ArrayList;
import java.util.List;

public class Entry {

    public static void main (String[] args) {
        ProfileDao profileDao = new ProfileDao();
        List<Profile> profiles = new ArrayList<>();
        createProfiles(profiles);
        profiles.forEach(profile -> profileDao.save(profile));
    }

    private static List<Profile> createProfiles(List<Profile> profiles) {
        profiles.add(new Profile(
            new Address("test1", "test1", "test1", "test1", "test1"),
            new Customer("Dan", "Fegan"),
            new Car("E57 VKD", "Ford", "Focus", 2.4)));

        profiles.add(new Profile(
            new Address("test2", "test2", "test2", "test2", "test2"),
            new Customer("Tom", "Jones"),
            new Car("E57 VKD", "Ford", "Focus", 2.4)));

        profiles.add(new Profile(
            new Address("test3", "test3", "test3", "test3", "test3"),
            new Customer("Stu", "Hayes"),
            new Car("E57 VKD", "Ford", "Focus", 2.4)));

        return profiles;
    }
}
