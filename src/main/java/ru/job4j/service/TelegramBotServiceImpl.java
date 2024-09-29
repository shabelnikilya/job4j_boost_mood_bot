package ru.job4j.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;

@Service
public class TelegramBotServiceImpl
        implements TelegramBotService, BeanNameAware {

    /**
     * Конструктор класса.
     */
    public TelegramBotServiceImpl() {
        System.out.println(
                "invoke constructor " + TelegramBotServiceImpl.class
        );
    }

    /**
     * Интеграция со spring'ом для получения присвоенного имени бина.
     * @param name имя бина.
     */
    @Override
    public void setBeanName(final String name) {
        System.out.println("TelegramBotServiceImpl(bean name): " + name);
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
