package ru.job4j.recommendation.content;

import org.springframework.stereotype.Component;
import ru.job4j.model.Content;

@Component
public class ContentProviderText implements ContentProvider {

    /**
     * Получение текстового контента по настроению.
     *
     * @param chatId идентификатор чата.
     * @param moodId идентификатор настроения.
     * @return текстовый контент.
     */
    @Override
    public Content byMood(long chatId, long moodId) {
        Content content = new Content(chatId);
        content.setText("Text");
        return content;
    }
}
