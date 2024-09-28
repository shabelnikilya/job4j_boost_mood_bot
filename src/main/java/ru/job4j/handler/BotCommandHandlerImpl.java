package ru.job4j.handler;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class BotCommandHandlerImpl implements BotCommandHandler {

    /**
     * Конструктор класса.
     */
    public BotCommandHandlerImpl() {
        System.out.println(
                "invoke constructor " + BotCommandHandlerImpl.class
        );
    }

    /**
     * метод вызываемый спрингом при инициализации бина.
     */
    @PostConstruct
    public void init() {
        System.out.println("init method " + BotCommandHandlerImpl.class);
    }

    /**
     * метод вызываемый спрингом при уничтожении бина.
     */
    @PreDestroy
    public void destroy() {
        System.out.println("destroy method " + BotCommandHandlerImpl.class);
    }
}
