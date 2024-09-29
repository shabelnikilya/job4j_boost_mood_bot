package ru.job4j.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /**
     * Имя телеграм бота из application.yml.
     */
    @Value("${telegram.bot.name}")
    private String telegramBotName;

    /**
     * Метод для получения имени телеграм бота.
     * @return имя телеграм бота.
     */
    public String getTelegramBotName() {
        return telegramBotName;
    }
}

