package ru.job4j.entity;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Награды, доступные в системе.
 */
@Entity
@Table(name = "mb_award")
public class Award {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "days")
    private int days;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Award award = (Award) o;
        return days == award.days && Objects.equals(title, award.title) && Objects.equals(description, award.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, days);
    }
}
