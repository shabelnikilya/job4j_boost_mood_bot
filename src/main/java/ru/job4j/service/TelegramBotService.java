package ru.job4j.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.job4j.exception.BoostMoodBotException;
import ru.job4j.factory.TgMessageFactory;
import ru.job4j.handler.BotCommandHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.job4j.model.Text;
import java.util.List;
import java.util.Optional;

@Service
public class TelegramBotService extends TelegramLongPollingBot
        implements TgRemoteService {

    /**
     * Постоянная для логирования.
     */
    private static final Logger LOG = LoggerFactory.getLogger(
            TelegramBotService.class
    );

    /**
     * Имя бота.
     */
    private final String botName;

    /**
     * Токен.
     */
    private final String botToken;

    /**
     * Обработчики тг сообщений.
     */
    private final List<BotCommandHandler> handlers;

    /**
     * Фабрика сообщений.
     */
    private TgMessageFactory tgMessageFactory;

    /**
     * Конструктор для инициализации имени и токена бота.
     *
     * @param botName имя бота.
     * @param botToken токен для доступа.
     * @param handlers обработчики сообщений бота.
     * @param tgMessageFactory фабрика сообщений.
     */
    public TelegramBotService(
            @Value("${telegram.bot.name}") String botName,
            @Value("${telegram.bot.token}") String botToken,
            @Autowired List<BotCommandHandler> handlers,
            @Autowired TgMessageFactory tgMessageFactory
    ) {
        this.botName = botName;
        this.botToken = botToken;
        this.handlers = handlers;
        this.tgMessageFactory = tgMessageFactory;
    }

    /**
     * Метод обрабатывающий сообщения отправляемые в чат с ботом.
     *
     * @param update принимаемые данные от телеграмм.
     */
    @Override
    public void onUpdateReceived(Update update) {
        Optional<BotCommandHandler> handler = handlers.stream()
                        .filter(h -> h.canHandle(update))
                        .findFirst();
        SendMessage message;
        if (handler.isPresent()) {
            message = handler.get().handle(update);
        } else {
            LOG.warn("Обработчик для сообщения");
            message = tgMessageFactory.sendTextByChatId(
                    update.getMessage().getChatId(),
                    Text.HANDLER_NOT_FOUND
            );
        }
        send(message);
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
    @Override
    public void send(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            LOG.error(
                    "Error when sending a message to telegram: {}", message, e
            );
            throw new BoostMoodBotException(
                    "Error when sending a message to telegram!", e
            );
        }
    }
}
