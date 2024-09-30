package ru.job4j.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class TgRemoteService extends TelegramLongPollingBot {

    /**
     * Имя бота.
     */
    private final String botName;

    /**
     * Токен.
     */
    private final String botToken;

    /**
     * Конструктор для инициализации имени и токена бота.
     *
     * @param botName имя бота.
     * @param botToken токен для доступа.
     */
    public TgRemoteService(
            @Value("${telegram.bot.name}") String botName,
            @Value("${telegram.bot.token}") String botToken
    ) {
        this.botName = botName;
        this.botToken = botToken;
    }

    /**
     * Метод обрабатывающий сообщения отправляемые в чат с ботом.
     *
     * @param update принимаемые данные от телеграмм.
     */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText("Вы написали: " + messageText);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Получение имени бота.
     * @return имя бота.
     */
    @Override
    public String getBotUsername() {
        return botName;
    }

    /**
     * Получение токена.
     *
     * @return токен.
     */
    @Override
    public String getBotToken() {
        return botToken;
    }
}
