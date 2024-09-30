package ru.job4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.job4j.service.TgRemoteService;

@SpringBootApplication
public class TelegramBotApplication {

    /**
     * Точка старта приложения.
     * @param args передаваемые аргументы при запуске java
     */
    public static void main(String[] args) {
        SpringApplication.run(TelegramBotApplication.class);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            ApplicationContext applicationContext
    ) {
        return args -> {
            var tgService = applicationContext.getBean(TgRemoteService.class);
            var telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            try {
                telegramBotsApi.registerBot(tgService);
                System.out.println("Бот успешно зарегестрирован!");
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        };
    }
}
