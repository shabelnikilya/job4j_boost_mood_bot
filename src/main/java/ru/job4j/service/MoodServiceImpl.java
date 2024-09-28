package ru.job4j.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class MoodServiceImpl implements MoodService {

    /**
     * Конструктор класса.
     */
    public MoodServiceImpl() {
        System.out.println("invoke constructor " + MoodServiceImpl.class);
    }

    /**
     * Метод вызываемый spring'ом при инициализации бина.
     */
    @PostConstruct
    public void init() {
        System.out.println("init method " + MoodServiceImpl.class);
    }

    /**
     * Метод вызываемый spring'ом при уничтожении бина.
     */
    @PreDestroy
    public void destroy() {
        System.out.println("destroy method " + MoodServiceImpl.class);
    }
}
