package spring_boot_security.user.infrastructure.database;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring_boot_security.user.domain.User;
import spring_boot_security.user.domain.ports.UserRepository;
import spring_boot_security.user.infrastructure.database.entity.UserEntity;
import spring_boot_security.user.infrastructure.database.mapper.UserEntityMapper;
import spring_boot_security.user.infrastructure.database.repository.QueryUserRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final QueryUserRepository queryUserRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public Optional<User> findByEmail(String email) {
        return queryUserRepository.findByEmail(email).map(userEntityMapper::mapToUser);
    }

    @Override
    public boolean existsByEmail(String email) {
        return queryUserRepository.findByEmail(email).isPresent();
    }

    @Override
    public User upsert(User user) {

        UserEntity userEntity = userEntityMapper.mapToUserEntity(user);
        UserEntity saved = queryUserRepository.save(userEntity);
        return userEntityMapper.mapToUser(saved);
    }
}
