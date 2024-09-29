package ru.job4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.job4j.config.AppConfig;

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
    public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
        return args -> {
            AppConfig appConfig = applicationContext.getBean(AppConfig.class);
            System.out.println("Telegram bot name: " + appConfig.getTelegramBotName());
        };
    }
}
