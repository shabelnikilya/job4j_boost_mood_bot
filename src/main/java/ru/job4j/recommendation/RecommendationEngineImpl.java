package ru.job4j.recommendation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.model.Content;
import ru.job4j.recommendation.content.ContentProvider;

import java.util.List;
import java.util.Random;

@Service
public class RecommendationEngineImpl implements RecommendationEngine {
    /**
     * Постоянная для логирования.
     */
    private static final Logger LOG = LoggerFactory.getLogger(
            RecommendationEngineImpl.class
    );

    /**
     * Постоянная для генерации рандомных значений.
     */
    private static final Random RND = new Random(System.currentTimeMillis());

    /**
     * Контент с которым работает класс рекомендаций.
     */
    private final List<ContentProvider> contentProviders;

    /**
     * Конструктор класса.
     *
     * @param contentProviders поставщики контента.
     */
    @Autowired
    public RecommendationEngineImpl(List<ContentProvider> contentProviders) {
        this.contentProviders = contentProviders;
    }

    /**
     * На данный момент возвращается рандомный контент из доступных.
     * @param chatId идентификатор чата.
     * @param moodId идентификатор настроения.
     * @return контент.
     */
    @Override
    public Content recommendFor(long chatId, long moodId) {
        int index = RND.nextInt(0, contentProviders.size());
        return contentProviders.get(index).byMood(chatId, moodId);
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
