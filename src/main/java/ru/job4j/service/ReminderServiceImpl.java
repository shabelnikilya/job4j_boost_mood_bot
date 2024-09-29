package ru.job4j.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;

@Service
public class ReminderServiceImpl implements ReminderService, BeanNameAware {

    /**
     * Конструктор класса.
     */
    public ReminderServiceImpl() {
        System.out.println(
                "invoke constructor " + ReminderServiceImpl.class
        );
    }

    /**
     * Интеграция со spring'ом для получения присвоенного имени бина.
     * @param name имя бина.
     */
    @Override
    public void setBeanName(final String name) {
        System.out.println("ReminderServiceImpl(bean name): " + name);
    }

    /**
     * Метод вызываемый spring'ом при инициализации бина.
     */
    @PostConstruct
    public void init() {
        System.out.println("init method " + ReminderServiceImpl.class);
    }

    /**
     * Метод вызываемый spring'ом при уничтожении бина.
     */
    @PreDestroy
    public void destroy() {
        System.out.println("destroy method " + ReminderServiceImpl.class);
    }
}
