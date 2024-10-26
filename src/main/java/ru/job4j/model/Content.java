package ru.job4j.model;

import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

/**
 * Универсальный контейнер для контента.
 */
public class Content {
    /**
     * Идентификатор чата.
     */
    private final long chatId;

    /**
     * Текст.
     */
    private String text;
    /**
     * Данные фото.
     */
    private InputFile photo;

    /**
     * Встроенная клавиатура в телеграм.
     */
    private InlineKeyboardMarkup markup;

    /**
     * Данные аудио.
     */
    private InputFile audio;

    /**
     * Данные видео.
     */
    private InputFile video;

    /**
     * Конструктор контента.
     *
     * @param chatId идентификатор чата.
     */
    public Content(long chatId) {
        this.chatId = chatId;
    }

    /**
     * Получение идентификатора чата.
     *
     * @return идентификатор чата.
     */
    public long getChatId() {
        return chatId;
    }

    /**
     * Получение текста.
     *
     * @return текст.
     */
    public String getText() {
        return text;
    }

    /**
     * Запись текста в контент.
     *
     * @param text текст.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Получение данных фото.
     *
     * @return фото.
     */
    public InputFile getPhoto() {
        return photo;
    }

    /**
     * Запись данных фото в контент.
     *
     * @param photo фото.
     */
    public void setPhoto(InputFile photo) {
        this.photo = photo;
    }

    /**
     * Получение данных для клавиатуры.
     *
     * @return класс с данными клавиатуры тг.
     */
    public InlineKeyboardMarkup getMarkup() {
        return markup;
    }

    /**
     * Установление данных клавиатуры.
     *
     * @param markup данные клавиатуры тг.
     */
    public void setMarkup(InlineKeyboardMarkup markup) {
        this.markup = markup;
    }

    /**
     * Получени данных аудио.
     *
     * @return данные аудио.
     */
    public InputFile getAudio() {
        return audio;
    }

    /**
     * Установление аудио данных в контент.
     *
     * @param audio данные аудио.
     */
    public void setAudio(InputFile audio) {
        this.audio = audio;
    }

    /**
     * Получение данных видео.
     *
     * @return данные видео.
     */
    public InputFile getVideo() {
        return video;
    }

    /**
     * Установление данных видео в контент.
     *
     * @param video данные видео.
     */
    public void setVideo(InputFile video) {
        this.video = video;
    }
}
