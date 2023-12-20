package de.lubowiecki.firststeps;

import jakarta.persistence.*;

import java.time.LocalDateTime;

// POJO - Plain Old Java Object

@Entity
@Table(name = "todos") // Name der Tabelle
public class Todo {

    @Id // Primärschlüssel
    @GeneratedValue // Strategie für die Bereitstellung
    private int id;

    @Column(length = 100)
    private String name;

    private String description;

    private LocalDateTime createdAt;

    private boolean done = false;

    public Todo() {
    }

    public Todo(String name, String description) {
        this.name = name;
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
