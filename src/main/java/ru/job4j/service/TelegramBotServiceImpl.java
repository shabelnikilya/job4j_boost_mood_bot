package ru.job4j.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;

@Service
public class TelegramBotServiceImpl
        implements TelegramBotService, BeanNameAware {
    /**
     * Постоянная для логирования.
     */
    private static final Logger LOG = LoggerFactory.getLogger(
            TelegramBotServiceImpl.class
    );

    /**
     * Конструктор класса.
     */
    public TelegramBotServiceImpl() {
        LOG.info(
                "invoke constructor {}", TelegramBotServiceImpl.class
        );
    }

    /**
     * Интеграция со spring'ом для получения присвоенного имени бина.
     * @param name имя бина.
     */
    @Override
    public void setBeanName(final String name) {
        LOG.info("TelegramBotServiceImpl(bean name): {}", name);
    }

    /**
     * Метод вызываемый spring'ом при инициализации бина.
     */
    @PostConstruct
    public void init() {
        LOG.info("init method {}", TelegramBotServiceImpl.class);
    }

    /**
     * Метод вызываемый spring'ом при уничтожении бина.
     */
    @PreDestroy
    public void destroy() {
        LOG.info("destroy method {}", TelegramBotServiceImpl.class);
    }
}
