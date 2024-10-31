package ru.job4j.entity;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Типы настроения.
 */
@Entity
@Table(name = "mb_mood")
public class Mood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "text")
    private String text;

    @Column(name = "good")
    private boolean good;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isGood() {
        return good;
    }

    public void setGood(boolean good) {
        this.good = good;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mood mood = (Mood) o;
        return id == mood.id && good == mood.good && Objects.equals(text, mood.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, good);
    }
}
