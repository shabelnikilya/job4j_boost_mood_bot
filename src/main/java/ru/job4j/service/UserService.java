package ru.job4j.service;

import ru.job4j.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    /**
     * Сохраненение пользовательских данных.
     *
     * @param clientId идентификатор клиента.
     * @param chatId идентификатор чата.
     * @return пользовательские данные.
     */
    User save(long clientId, long chatId);

    /**
     * Получение пользователя по идентификатору клиента.
     *
     * @param clientId идентификатор клиента.
     * @return пользовательские данные.
     */
    Optional<User> getByClientId(long clientId);

    /**
     * Получение всех пользователей.
     *
     * @return список пользователей.
     */
    List<User> findAll();

}
