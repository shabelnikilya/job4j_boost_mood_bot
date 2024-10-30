package ru.job4j.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.job4j.factory.TgMessageFactory;
import ru.job4j.model.Text;

@Service
public class ReminderServiceImpl implements ReminderService, BeanNameAware {
    /**
     * Постоянная для логирования.
     */
    private static final Logger LOG = LoggerFactory.getLogger(
            ReminderServiceImpl.class
    );

    /**
     * Сервис по работе с пользователями.
     */
    private final UserService userService;

    /**
     * Фабрика для сообщений тг.
     */
    private final TgMessageFactory tgMessageFactory;

    /**
     * Сервис по работе с телеграм апи.
     */
    private final TgRemoteService tgRemoteService;

    /**
     * Конструктор класса.
     *
     * @param userService сервис по работе с пользователями,
     * @param tgMessageFactory фабрика сообщений.
     * @param tgRemoteService сервис для работы с тг апи.
     */
    @Autowired
    public ReminderServiceImpl(
            UserService userService,
            TgMessageFactory tgMessageFactory,
            TgRemoteService tgRemoteService
    ) {
        this.userService = userService;
        this.tgMessageFactory = tgMessageFactory;
        this.tgRemoteService = tgRemoteService;
    }

    /**
     * Метод для отправки сообщения в чат с определенной периодичностью.
     */
    @Scheduled(fixedRateString = "${remind.period}")
    @Override
    public void ping() {
        userService.findAll().stream()
                .forEach(
                        u -> {
                        long chatId = u.getChatId();
                        var message = tgMessageFactory.sendTextByChatId(chatId, Text.PING);
                        tgRemoteService.send(message);
                        }
                );
    }

    /**
     * Интеграция со spring'ом для получения присвоенного имени бина.
     * @param name имя бина.
     */
    @Override
    public void setBeanName(final String name) {
        LOG.info("ReminderServiceImpl(bean name): {}", name);
    }

    /**
     * Метод вызываемый spring'ом при инициализации бина.
     */
    @PostConstruct
    public void init() {
        LOG.info("init method {}", ReminderServiceImpl.class);
    }

    /**
     * Метод вызываемый spring'ом при уничтожении бина.
     */
    @PreDestroy
    public void destroy() {
        LOG.info("destroy method {}", ReminderServiceImpl.class);
    }
}
