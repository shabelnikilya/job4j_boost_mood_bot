package ru.job4j.recommendation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class RecommendationEngineImpl implements RecommendationEngine {

    /**
     * Конструктор класса.
     */
    public RecommendationEngineImpl() {
        System.out.println(
                "invoke constructor " + RecommendationEngineImpl.class
        );
    }

    /**
     * Метод вызываемый spring'ом при инициализации бина.
     */
    @PostConstruct
    public void init() {
        System.out.println("init method " + RecommendationEngineImpl.class);
    }

    /**
     * Метод вызываемый spring'ом при уничтожении бина.
     */
    @PreDestroy
    public void destroy() {
        System.out.println("destroy method " + RecommendationEngineImpl.class);
    }
}
