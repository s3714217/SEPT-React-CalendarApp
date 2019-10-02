package com.sept.rest.webservices.restfulwebservices.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

import com.sept.rest.webservices.restfulwebservices.Day.Day;
import com.sept.rest.webservices.restfulwebservices.Event.Event;

@Component
public class EventService {
    @Autowired
    EventJpaRepository repository;

    public void add(Event event) {
        
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<Event> getEvents() {
        return (List<Event>) repository.findAll();
    }

    public Event getEventById(int id) {
        Optional<Event> optionalEvent = repository.findEvent(id);
        return optionalEvent.orElseThrow();

    }

    public Event getEventByDay(Day day) {
        Optional<Event> optionalEvent = repository.findEvent(day);
        return optionalEvent.orElseThrow();

    }

    private Event toEntity(Event event) {
        Event entity = event;
        entity.setEventID(event.getEventID());
        entity.setEventTitle(event.getEventTitle());
        entity.setDescription(event.getDescription());
        entity.setDateTime(event.getDateTime());
        entity.setEndTime(event.getEndTime());
        entity.setEventDay(event.getEventDay());
        return entity;
    }

}