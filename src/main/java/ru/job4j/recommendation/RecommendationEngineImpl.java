package ru.job4j.recommendation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RecommendationEngineImpl implements RecommendationEngine {
    /**
     * Постоянная для логирования.
     */
    private static final Logger LOG = LoggerFactory.getLogger(
            RecommendationEngineImpl.class
    );

    /**
     * Конструктор класса.
     */
    public RecommendationEngineImpl() {
        LOG.info(
                "invoke constructor {}", RecommendationEngineImpl.class
        );
    }

    /**
     * Метод вызываемый spring'ом при инициализации бина.
     */
    @PostConstruct
    public void init() {
        LOG.info("init method {}", RecommendationEngineImpl.class);
    }

    /**
     * Метод вызываемый spring'ом при уничтожении бина.
     */
    @PreDestroy
    public void destroy() {
        LOG.info("destroy method {}", RecommendationEngineImpl.class);
    }
}
