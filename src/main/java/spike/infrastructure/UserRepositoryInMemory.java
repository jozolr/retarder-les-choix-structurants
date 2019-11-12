package spike.infrastructure;

import spike.domain.User;
import spike.domain.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryInMemory implements UserRepository {
    private List<User> users = new ArrayList<>();

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void saveAll(List<User> users) {
        this.users.addAll(users);
    }
}
