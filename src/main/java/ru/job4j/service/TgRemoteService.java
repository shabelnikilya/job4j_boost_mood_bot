package ru.job4j.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.job4j.factory.TgMessageFactory;
import ru.job4j.model.Button;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
     * Фабрика сообщений.
     */
    private final TgMessageFactory messageFactory;

    /**
     * Конструктор для инициализации имени и токена бота.
     *
     * @param botName имя бота.
     * @param botToken токен для доступа.
     * @param messageFactory фабрика сообщений для тг.
     */
    public TgRemoteService(
            @Value("${telegram.bot.name}") String botName,
            @Value("${telegram.bot.token}") String botToken,
            @Autowired TgMessageFactory messageFactory
    ) {
        this.botName = botName;
        this.botToken = botToken;
        this.messageFactory = messageFactory;
    }

    /**
     * Метод обрабатывающий сообщения отправляемые в чат с ботом.
     *
     * @param update принимаемые данные от телеграмм.
     */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasCallbackQuery()) {
            var data = update.getCallbackQuery().getData();
            var chatId = update.getCallbackQuery().getMessage().getChatId();
            send(messageFactory.sendTextByChatIdAndData(chatId, data));
        }
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            Map<String, String> btnNameToData = Stream.of(Button.values())
                    .collect(
                            Collectors.toMap(
                                    Button::getName,
                                    Button::getData
                            )
            );
            send(
                    messageFactory.sendButtonsByChatId(
                        chatId,
                        "Как настроение сегодня ?",
                        btnNameToData
                    )
            );
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

    /**
     * Отправка сообщения в тг чат.
     * @param message сообщение.
     */
    private void send(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
