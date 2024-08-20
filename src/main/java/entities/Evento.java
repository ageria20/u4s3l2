package entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="evento")
public class Evento {
    @Id
    @GeneratedValue
    private long id;

    @Column (nullable = false)
    private String title;

    @Column (nullable = false)
    private LocalDate eventDate;

    @Column (nullable = false)
    private String description;

    @Column (nullable = false)
    @Enumerated(EnumType.STRING) // <-- Di default gli enum vengono trattati come numeri interi nella tabella del db
    // Se voglio che essi invece vengano rappresentati come testo devo usare @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column (nullable = false)
    private int maxPersons;

    public Evento() {
    }

    public Evento(String title, LocalDate eventDate, String description, EventType eventType, int maxPersons) {
        this.title = title;
        this.eventDate = eventDate;
        this.description = description;
        this.eventType = eventType;
        this.maxPersons = maxPersons;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getMaxPersons() {
        return maxPersons;
    }

    public void setMaxPersons(int maxPersons) {
        this.maxPersons = maxPersons;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", eventDate=" + eventDate +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", maxPersons=" + maxPersons +
                '}';
    }
}
