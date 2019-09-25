package com.sept.rest.webservices.restfulwebservices.Event;

import java.time.*;
import java.util.*;

import javax.persistence.*;

import com.sept.rest.webservices.restfulwebservices.Day.Day;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue
    private int eventId;

    @Column(nullable = false)
    String eventTitle;

    @Column(nullable = false)
    String description;

    @Column(nullable = false)
    LocalDateTime dateTime;

    @Column(nullable = false)
    LocalDateTime endTime;

    @ManyToOne
    Day day;

    public Event(String eventTitle, String description, LocalDateTime dateTime, LocalDateTime endTime, Day day) {

        this.eventTitle = eventTitle;
        this.description = description;
        this.dateTime = dateTime;
        this.endTime = endTime;
        this.day = day;

    }

    public int getEventID() {
        return this.eventId;
    }

    public void setEventID(int id) {
        this.eventId = id;
    }

    public String getEventTitle() {
        return this.eventTitle;
    }

    public void setEventTitle(String title) {
        this.eventTitle = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Day getEventDay() {
        return this.day;
    }

    public void setEventDay(Day day) {
        this.day = day;
    }

}