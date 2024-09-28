package ru.job4j.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class AchievementServiceImpl implements AchievementService {

    /**
     * Конструктор класса.
     */
    public AchievementServiceImpl() {
        System.out.println(
                "invoke constructor " + AchievementServiceImpl.class
        );
    }

    /**
     * Метод вызываемый spring'ом при инициализации бина.
     */
    @PostConstruct
    public void init() {
        System.out.println("init method " + AchievementServiceImpl.class);
    }

    /**
     * Метод вызываемый spring'ом при уничтожении бина.
     */
    @PreDestroy
    public void destroy() {
        System.out.println("destroy method " + AchievementServiceImpl.class);
    }
}
