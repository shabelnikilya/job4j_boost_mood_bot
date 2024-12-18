package ru.job4j.profile;

/**
 * Утилитный класс для профилей приложения.
 */
public final class Profiles {

    /**
     * Название профиля для локального запуска.
     */
    public static final String TEST_PROFILE = "test";

    /**
     * Профиль для бинов не относящихся к test.
     */
    public static final String NOT_TEST_PROFILE = "!test";

    /**
     * Закрытый конструктор утилитного класса.
     */
    private Profiles() {
    }
}
