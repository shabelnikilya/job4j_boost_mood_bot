package ru.job4j.handler;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BotCommandHandlerImpl implements BotCommandHandler {
    /**
     * Постоянная для логирования.
     */
    private static final Logger LOG = LoggerFactory.getLogger(
            BotCommandHandlerImpl.class
    );

    /**
     * Конструктор класса.
     */
    public BotCommandHandlerImpl() {
        LOG.info(
                "invoke constructor {}", BotCommandHandlerImpl.class
        );
    }

    /**
     * метод вызываемый спрингом при инициализации бина.
     */
    @PostConstruct
    public void init() {
        LOG.info("init method {}", BotCommandHandlerImpl.class);
    }

    /**
     * метод вызываемый спрингом при уничтожении бина.
     */
    @PreDestroy
    public void destroy() {
        LOG.info("destroy method {}", BotCommandHandlerImpl.class);
    }
}
