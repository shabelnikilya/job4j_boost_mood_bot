package ru.job4j.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ru.job4j.model.User;
import ru.job4j.profile.Profiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Profile(Profiles.TEST_PROFILE)
@Repository
public class UserFakeRepositoryImpl implements UserRepository {
    /**
     * Мапа с пользователями.
     */
    private final Map<Long, User> userMap = new HashMap<>();

    /**
     * Получение всех пользователей.
     *
     * @return список пользователей.
     */
    @Override
    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }

    /**
     * Получения ползьвателя по идентификатору.
     *
     * @param clientId идентификатор клиента.
     * @return пользователь.
     */
    @Override
    public Optional<User> findByClientId(long clientId) {
        return Optional.ofNullable(userMap.get(clientId));
    }

    /**
     * Сохранения пользователя.
     *
     * @param user данные пользователя.
     * @return пользователь.
     */
    @Override
    public User save(User user) {
        long userId = System.currentTimeMillis();
        user.setId(userId);
        userMap.putIfAbsent(user.getClientId(), user);
        return user;
    }
}
