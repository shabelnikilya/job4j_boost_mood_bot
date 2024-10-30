package ru.job4j.handler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface BotCommandHandler {

    /**
     * Метод для выбора соответствующего обработчика.
     *
     * @param update данные из чата.
     * @return true - если данный обработчик обрабатывает сообщение,
     * false - если нет.
     */
    boolean canHandle(Update update);

    /**
     * Обработка тг сообщения.
     *
     * @param update данные из тг чата.
     * @return объект для отправки в чат.
     */
    SendMessage handle(Update update);
}

