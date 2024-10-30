package ru.job4j.handler;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.job4j.factory.TgMessageFactory;
import ru.job4j.model.Button;
import ru.job4j.entity.User;
import ru.job4j.service.UserService;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StartCommandHandlerImpl implements BotCommandHandler {
    /**
     * Постоянная для логирования.
     */
    private static final Logger LOG = LoggerFactory.getLogger(
            StartCommandHandlerImpl.class
    );

    /**
     * Постоянная, которая определяет сообщение для
     * старта общения с ботом.
     */
    private static final String START_TEXT = "/start";

    /**
     * Сервис для работы с пользователями.
     */
    private final UserService userService;

    /**
     * Фабрика сообщений.
     */
    private final TgMessageFactory messageFactory;

    /**
     * Конструктор класса.
     *
     * @param userService сервис по работе с пользователями.
     * @param tgMessageFactory фабрика сообщений.
     */
    @Autowired
    public StartCommandHandlerImpl(
            UserService userService,
            TgMessageFactory tgMessageFactory
            ) {
        this.userService = userService;
        this.messageFactory = tgMessageFactory;
    }

    /**
     * Метод для выбора соответствующего обработчика.
     *
     * @param update данные из чата.
     * @return true - если данный обработчик обрабатывает сообщение,
     * false - если нет.
     */
    @Override
    public boolean canHandle(Update update) {
        return update.hasMessage() && update.getMessage().hasText()
                && START_TEXT.equalsIgnoreCase(update.getMessage().getText());
    }

    /**
     * Обработка тг сообщения.
     *
     * @param update данные из тг чата.
     * @return объект для отправки в чат.
     */
    @Override
    public SendMessage handle(Update update) {
        var message = update.getMessage();
        long chatId = message.getChatId();
        long clientId = message.getFrom().getId();
        boolean userIsNotRegistered = userService.getByClientId(clientId)
                                                            .isEmpty();
        if (userIsNotRegistered) {
            User user = userService.save(clientId, chatId);
            LOG.info("Зарегестрирован пользователь: {}", user);
        }
        Map<String, String> btnNameToData = Stream.of(Button.values())
                .collect(
                        Collectors.toMap(
                                Button::getName,
                                Button::getData
                        )
                );

        return messageFactory.sendButtonsByChatId(
                chatId,
                "Как настроение сегодня ?",
                btnNameToData
        );
    }

    /**
     * метод вызываемый спрингом при инициализации бина.
     */
    @PostConstruct
    public void init() {
        LOG.info("init method {}", StartCommandHandlerImpl.class);
    }

    /**
     * метод вызываемый спрингом при уничтожении бина.
     */
    @PreDestroy
    public void destroy() {
        LOG.info("destroy method {}", StartCommandHandlerImpl.class);
    }
}
