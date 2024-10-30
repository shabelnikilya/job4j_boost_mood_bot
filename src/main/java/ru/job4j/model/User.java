package ru.job4j.model;

public class User {

    /**
     * Внутренний идентификатор пользователя.
     */
    private long id;

    /**
     * Идентификатор клиента.
     */
    private long clientId;

    /**
     * Идентификатор чатаю
     */
    private long chatId;

    /**
     * Конструктор класса.
     *
     * @param clientId идентификатор клиента.
     * @param chatId идентификатор чата.
     */
    public User(long clientId, long chatId) {
        this.clientId = clientId;
        this.chatId = chatId;
    }

    /**
     * Установление внутреннего идентификатора.
     * @param id идентификатор.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Получение идентификатора.
     *
     * @return идентификатор.
     */
    public long getId() {
        return id;
    }

    /**
     * Получение клиентского идентификатора.
     *
     * @return клиентский идентификатор.
     */
    public long getClientId() {
        return clientId;
    }

    /**
     * Получение идентификатора чата.
     *
     * @return идентификатор чата.
     */
    public long getChatId() {
        return chatId;
    }

    /**
     * Переопределенное представление объекта строкой.
     * @return объект в виде строки.
     */
    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", clientId=" + clientId
                + ", chatId=" + chatId
                + '}';
    }
}
