package com.sept.rest.webservices.restfulwebservices.Event;

import java.time.*;
import javax.persistence.*;

import com.sept.rest.webservices.restfulwebservices.Day.Day;
import com.sept.rest.webservices.restfulwebservices.user.User;

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
    String time;

    @Column(nullable = false)
    String Location;

    LocalDate day;

   String ReferenceUsername;

    public Event(String eventTitle, String description, String time, String Location, LocalDate day, String userName) {

        this.eventTitle = eventTitle;
        this.description = description;
        this.time = time;
        this.Location = Location;
        this.day = day;
        this.ReferenceUsername = userName;
        

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

    public String getDateTime() {
        return time;
    }

    public void setDateTime(String time) {
        this.time = time;
    }

    public String getEventLocation() {
        return this.Location;
    }

    public void setEventLocation(String Location) {
        this.Location = Location;
    }

    public LocalDate getEventDay() {
        return this.day;
    }

    public void setEventDay(LocalDate day) {
        this.day = day;
    }

    public String getUser() {
        return ReferenceUsername;
    }

    public void setUser(String User) {
       this.ReferenceUsername = User;
    }

    public String toString() {
        return "Event Title : " + eventTitle + "/n " + "Event Description: " + description + "/n" + "Event Time : "
                + time + "/n" + "Event Location : " + Location + "/n";
    }

}