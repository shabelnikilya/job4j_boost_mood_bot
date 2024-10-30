package ru.job4j.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.job4j.factory.TgMessageFactory;

@Service
public class ButtonCommandHandlerImpl implements BotCommandHandler {

    /**
     * Фабрика для объектов сообщения.
     */
    private final TgMessageFactory messageFactory;

    /**
     * Конструктор класса.
     *
     * @param messageFactory фабрика объектов сообщений тг.
     */
    @Autowired
    public ButtonCommandHandlerImpl(TgMessageFactory messageFactory) {
        this.messageFactory = messageFactory;
    }

    /**
     * Метод для определения обработчика.
     *
     * @param update данные из чата.
     * @return true - если данный обработчик обрабатывает сообщение,
     * false - если нет.
     */
    @Override
    public boolean canHandle(Update update) {
        return update.hasCallbackQuery();
    }

    /**
     * Обработка тг сообщения.
     *
     * @param update данные из тг чата.
     * @return объект для отправки в чат.
     */
    @Override
    public SendMessage handle(Update update) {
        var data = update.getCallbackQuery().getData();
        var chatId = update.getCallbackQuery().getMessage().getChatId();
        return messageFactory.sendTextByChatIdAndData(chatId, data);
    }
}
