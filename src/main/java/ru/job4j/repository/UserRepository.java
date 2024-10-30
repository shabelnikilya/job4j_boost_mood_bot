package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.entity.User;
import java.util.Optional;

/**
 * Абстракция для работы с данными пользователей.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Получение данных пользователя по идентификатору клиента.
     *
     * @param clientId идентификатор клиента.
     * @return данные пользователя.
     */
    Optional<User> findByClientId(long clientId);
}
