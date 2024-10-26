package ru.job4j.recommendation.content;

import ru.job4j.model.Content;

public interface ContentProvider {

    /**
     * Получение контента по настроению.
     *
     * @param chatId идентификатор чата.
     * @param moodId идентификатор настроения.
     * @return контент.
     */
    Content byMood(long chatId, long moodId);

}
