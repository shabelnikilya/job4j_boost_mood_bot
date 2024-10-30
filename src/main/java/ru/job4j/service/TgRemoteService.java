package ru.job4j.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface TgRemoteService {

    /**
     * Отправка сообщений в тг.
     *
     * @param sendMessage отправляемой сообщение.
     */
    void send(SendMessage sendMessage);
}
