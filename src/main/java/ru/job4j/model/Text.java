package ru.job4j.model;

public enum Text {
    HANDLER_NOT_FOUND("Данная команда не поддерживается ботом!"),
    PING("ping user");

    private final String text;

    Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
