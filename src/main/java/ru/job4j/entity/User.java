package ru.job4j.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mb_user")
public class User {

    /**
     * Внутренний идентификатор пользователя.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Идентификатор клиента.
     */
    @Column(name = "client_id")
    private long clientId;

    /**
     * Идентификатор чатаю
     */
    @Column(name = "chat_id")
    private long chatId;

    /**
     * Конструктор класса без аргументов.
     */
    public User() {
    }

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
     * Метод для установления идентификатора клиента.
     *
     * @param clientId идентификатор клиента.
     */
    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    /**
     * Метод установления идентификатора чата.
     *
     * @param chatId идентификатор чата.
     */
    public void setChatId(long chatId) {
        this.chatId = chatId;
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
