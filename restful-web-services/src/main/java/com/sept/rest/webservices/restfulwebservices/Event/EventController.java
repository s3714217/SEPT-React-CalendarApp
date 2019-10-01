package com.sept.rest.webservices.restfulwebservices.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/day/events")
public class EventController {
    @Autowired
    EventService service;

    @GetMapping
    public List<Event> getEvents() {
        return service.getEvents();
    }

    @PostMapping
    public void postEvents(@RequestBody Event event) {
        service.add(event);
    }

    @GetMapping("/{id}")
    public Event getByNumAndMonth(@PathVariable(required = true) int id) {
        return service.getEventById(id);
    }

    @DeleteMapping("/{id}")
    public void delete( @PathVariable(required = true) int id) {
        service.delete(id);
    }
}
