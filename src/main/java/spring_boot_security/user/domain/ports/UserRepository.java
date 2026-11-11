package spring_boot_security.user.domain.ports;

import spring_boot_security.user.domain.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    User upsert(User user);
}
