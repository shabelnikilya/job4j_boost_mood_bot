package ru.job4j.model;

public enum Button {
    /**
     * Данные для кнопки потери носка.
     */
    LOST_SOCK(
            "Потерял носок \uD83D\uDE22",
            "lost_sock",
            "Носки — это коварные создания."
                    + " Но не волнуйся, второй обязательно найдётся!"
    ),
    /**
     * Данные для кнопки настроения как огурец.
     */
    CUCUMBER(
            "Как огурец на полке \uD83D\uDE10",
            "cucumber",
            "Огурец тоже дело серьёзное!"
                    + " Главное, не мариноваться слишком долго."
    ),
    /**
     * Данные для кнопки - готов к танцам.
     */
    DANCE_READY(
            "Готов к танцам \uD83D\uDE04",
            "dance_ready",
            "Супер! Танцуй, как будто никто не смотрит."
                    + " Или, наоборот, как будто все смотрят!"
    ),
    /**
     * данные для кнопки - где мой кофе.
     */
    NEED_COFEE(
            "Где мой кофе?! \uD83D\uDE23",
            "need_coffee",
            "Кофе уже в пути! Осталось только подождать..."
                    + " И ещё немного подождать..."
    ),
    /**
     * данные для кнопки - слипаются глаза.
     */
    SLEEPY(
            "Слипаются глаза \uD83D\uDE29",
            "sleepy",
            "Пора на боковую!"
                    + " Даже супергерои отдыхают, ты не исключение."
    );

    /**
     * Имя кнопки.
     */
    private final String name;
    /**
     * Данные кнопки.
     */
    private final String data;
    /**
     * Текст ответа.
     */
    private final String responseText;

    /**
     * Конструктор кнопки.
     *
     * @param name имя.
     * @param data данные для тг кнопки.
     * @param responseText текст ответа.
     */
    Button(String name, String data, String responseText) {
        this.name = name;
        this.data = data;
        this.responseText = responseText;
    }

    /**
     * Метод получения имени кнопки.
     * @return имя кнопки.
     */
    public String getName() {
        return name;
    }

    /**
     * Получения данных привязанных к кнопки.
     * @return данные кнопки.
     */
    public String getData() {
        return data;
    }

    /**
     * Получени текста ответа при нажатии на кнопку.
     * @return текст ответа.
     */
    public String getResponseText() {
        return responseText;
    }
}
