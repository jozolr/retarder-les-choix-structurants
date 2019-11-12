package spike.domain;

import java.util.List;

public interface UserRepository {
    List<User> getAll();
    void saveAll(List<User> user);
}
