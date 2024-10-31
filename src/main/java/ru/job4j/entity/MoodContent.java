package ru.job4j.entity;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Содержит разнообразные ответы для пользователя на его настроение.
 */
@Entity
@Table(name = "mb_mood_content")
public class MoodContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "mood_id")
    private Mood mood;

    @Column(name = "text")
    private String text;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MoodContent that = (MoodContent) o;
        return Objects.equals(mood, that.mood) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mood, text);
    }
}
