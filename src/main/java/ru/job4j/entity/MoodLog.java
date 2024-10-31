package ru.job4j.entity;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Фиксирует выбранное пользователем настроение.
 */
@Entity
@Table(name = "mb_mood_log")
public class MoodLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "mood_id")
    private Mood mood;

    @Column(name = "created_at")
    private long createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MoodLog moodLog = (MoodLog) o;
        return createdAt == moodLog.createdAt && Objects.equals(user, moodLog.user) && Objects.equals(mood, moodLog.mood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, mood, createdAt);
    }
}
