package spike.usecases;

import org.junit.Test;
import spike.domain.User;
import spike.infrastructure.UserRepositoryInMemory;

import java.util.List;

public class GetFrenchUsersTest {
    @Test
    public void getFrenchUsers_should_return_french_users_only() {
        // Given
        var userRepository = new UserRepositoryInMemory();
        var jim = new User("Jim", "USA");
        var bob = new User("Bob", "France");
        var paul = new User("Paul", "France");
        var ringo = new User("Ringo", "England");
        userRepository.saveAll(List.of(jim, bob, paul, ringo));

        var getFrenchUsers = GetFrenchUsers.create(userRepository);

        // When
        var frenchUsers = getFrenchUsers.execute();

        // Then
        assert frenchUsers.size() == 2;
        assert frenchUsers.contains(bob);
        assert frenchUsers.contains(paul);
    }
}