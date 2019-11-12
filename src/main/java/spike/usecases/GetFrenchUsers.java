package spike.usecases;

import spike.domain.User;
import spike.domain.UserRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GetFrenchUsers {
    private final UserRepository userRepository;

    private GetFrenchUsers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static GetFrenchUsers create(UserRepository userRepository) {
        return new GetFrenchUsers(userRepository);
    }

    public List<User> execute() {
        return userRepository.getAll().stream()
                .filter(user -> user.getCountry().equals("France"))
                .collect(toList());
    }
}
