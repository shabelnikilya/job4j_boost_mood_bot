package ru.job4j.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.model.User;
import ru.job4j.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    /**
     * Репозиторий пользователей.
     */
    private final UserRepository repository;

    /**
     * Конструктор класса.
     *
     * @param repository репозиторий пользователей.
     */
    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * Сохранение пользователя.
     *
     * @param clientId идентификатор клиента.
     * @param chatId идентификатор чата.
     * @return пользователь.
     */
    @Override
    public User save(long clientId, long chatId) {
        User user = new User(clientId, chatId);
        repository.save(user);
        return user;
    }

    /**
     * Получение пользователя по идентификатору клиента.
     *
     * @param clientId идентификатор клиента.
     * @return пользователь.
     */
    @Override
    public Optional<User> getByClientId(long clientId) {
        return repository.findByClientId(clientId);
    }

    /**
     * Получение всех пользователей.
     *
     * @return список пользователей.
     */
    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
