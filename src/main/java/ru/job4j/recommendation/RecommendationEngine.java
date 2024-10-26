package ru.job4j.recommendation;

import ru.job4j.model.Content;

public interface RecommendationEngine {

    /**
     * Получение рекомендаций.
     *
     * @param chatId идентификатор чата.
     * @param moodId идентификатор настроения.
     * @return контент.
     */
    Content recommendFor(long chatId, long moodId);
}
