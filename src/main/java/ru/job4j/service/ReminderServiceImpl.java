package ru.job4j.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class ReminderServiceImpl implements ReminderService {

    /**
     * Конструктор класса.
     */
    public ReminderServiceImpl() {
        System.out.println(
                "invoke constructor " + ReminderServiceImpl.class
        );
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
