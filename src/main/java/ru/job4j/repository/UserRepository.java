package ru.job4j.repository;

import ru.job4j.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Абстракция для работы с данными пользователей.
 */
public interface UserRepository {

    /**
     * Получение всех пользователей.
     *
     * @return список пользователей.
     */
    List<User> findAll();

    /**
     * Получение пользователя по идентификатору.
     *
     * @param clientId идентификатор клиента.
     * @return обертка {@link Optional} над пользователем.
     */
    Optional<User> findByClientId(long clientId);

    /**
     * Сохранение пользовательских данных.
     *
     * @param user данные пользователя.
     * @return пользователь.
     */
    User save(User user);
}
