package ru.job4j.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class TelegramBotServiceImpl implements TelegramBotService {

    /**
     * Конструктор класса.
     */
    public TelegramBotServiceImpl() {
        System.out.println(
                "invoke constructor " + TelegramBotServiceImpl.class
        );
    }

    /**
     * Метод вызываемый spring'ом при инициализации бина.
     */
    @PostConstruct
    public void init() {
        System.out.println("init method " + TelegramBotServiceImpl.class);
    }

    /**
     * Метод вызываемый spring'ом при уничтожении бина.
     */
    @PreDestroy
    public void destroy() {
        System.out.println("destroy method " + TelegramBotServiceImpl.class);
    }
}
