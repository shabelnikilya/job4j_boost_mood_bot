package ru.job4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.job4j.service.TelegramBotService;

@EnableScheduling
@SpringBootApplication
public class TelegramBotApplication {
    /**
     * Постоянная для логирования.
     */
    private static final Logger LOG = LoggerFactory.getLogger(
            TelegramBotApplication.class
    );

    /**
     * Точка старта приложения.
     * @param args передаваемые аргументы при запуске java
     */
    public static void main(String[] args) {
        SpringApplication.run(TelegramBotApplication.class);
    }

    /**
     * Метод вызываемый после поднятия контекста.
     *
     * @param applicationContext spring контекст.
     * @return реализация функц. yитерфейса.
     */
    @Bean
    public CommandLineRunner commandLineRunner(
            ApplicationContext applicationContext
    ) {
        return args -> {
            var tgService = applicationContext.getBean(
                    TelegramBotService.class
            );
            var telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            try {
                telegramBotsApi.registerBot(tgService);
                LOG.info("Бот успешно зарегестрирован!");
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        };
    }
}
