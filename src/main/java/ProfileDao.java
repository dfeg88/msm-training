import java.util.List;

public interface ProfileDao<Profile> {
    void save(List<Profile> profiles);
}
