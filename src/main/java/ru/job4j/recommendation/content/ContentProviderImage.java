package ru.job4j.recommendation.content;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import ru.job4j.model.Content;

import java.io.File;

@Component
public class ContentProviderImage implements ContentProvider {

    /**
     * Получение контента с изображением по настроению.
     *
     * @param chatId идентификатор чата.
     * @param moodId идентификатор настроения.
     * @return контент с изображением.
     */
    @Override
    public Content byMood(long chatId, long moodId) {
        Content content = new Content(chatId);
        File imageFile = new File("./content/image/log.png");
        content.setPhoto(new InputFile(imageFile));
        return content;
    }
}
