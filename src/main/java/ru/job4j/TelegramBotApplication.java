package ru.job4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TelegramBotApplication {

    /**
     * Точка старта приложения.
     * @param args передаваемые аргументы при запуске java
     */
    public static void main(String[] args) {
        SpringApplication.run(TelegramBotApplication.class);
    }
}
