package ru.job4j.recommendation.content;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import ru.job4j.model.Content;

import java.io.File;

@Component
public class ContentProviderAudio implements ContentProvider {

    /**
     * Получение аудио контента по настроению.
     *
     * @param chatId идентификатор чата.
     * @param moodId идентификатор настроения.
     * @return аудио контент.
     */
    @Override
    public Content byMood(long chatId, long moodId) {
        Content content = new Content(chatId);
        content.setAudio(new InputFile(new File("./content/audio/music.mp3")));
        return content;
    }
}
