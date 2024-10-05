package ru.job4j.exception;

/**
 * Общее исключение в приложении.
 */
public class BoostMoodBotException extends RuntimeException {

    /**
     * Конструктор для инициализации исключения с сообщением.
     *
     * @param message сообщение.
     */
    public BoostMoodBotException(String message) {
        super(message);
    }

    /**
     * Конструктор для инициализации исключения с
     * сообщением + изначальным исключением.
     *
     * @param message сообщение.
     * @param cause изначальное исключение.
     */
    public BoostMoodBotException(String message, Throwable cause) {
        super(message, cause);
    }
}
