package ru.job4j.recommendation.content;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import ru.job4j.model.Content;

@Component
public class ContentProviderVideo implements ContentProvider {

    /**
     * Получение видео контента по настроению.
     *
     * @param chatId идентификатор чата.
     * @param moodId идентификатор настроения.
     * @return видео контент.
     */
    @Override
    public Content byMood(long chatId, long moodId) {
        Content content = new Content(chatId);
        content.setVideo(new InputFile("./content/video/shorts.mp4"));
        return content;
    }
}
