package ru.job4j.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ru.job4j.model.User;
import ru.job4j.profile.Profiles;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
@Profile(Profiles.NOT_TEST_PROFILE)
public class UserRepositoryImpl implements UserRepository {

    /**
     * Получение всех пользователей.
     *
     * @return список пользователей.
     */
    @Override
    public List<User> findAll() {
        return Collections.emptyList();
    }

    /**
     * Получение пользователя по идентификатору.
     *
     * @param clientId идентификатор клиента.
     * @return пользователь.
     */
    @Override
    public Optional<User> findByClientId(long clientId) {
        return Optional.empty();
    }

    /**
     * Сохранение пользователя.
     *
     * @param user данные пользователя.
     * @return пользователь.
     */
    @Override
    public User save(User user) {
        throw new UnsupportedOperationException("Метод не реализован!");
    }
}
