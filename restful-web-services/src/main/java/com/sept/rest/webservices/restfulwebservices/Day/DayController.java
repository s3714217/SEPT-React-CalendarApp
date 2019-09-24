package com.sept.rest.webservices.restfulwebservices.Day;

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
@RequestMapping("/dogs")
public class DayController {
    @Autowired
    DayService service;

    @GetMapping
    public List<Day> getDays() {
        return service.getDays();
    }

    @PostMapping
    public void postDogs(@RequestBody Day day) {
        service.add(day);
    }

    @GetMapping("/{month}/{number}")
    public Day getByNumAndMonth(@PathVariable(required = true) String month, @PathVariable(required = true) int num) {
        return service.getDayByNumAndMonth(num, month);
    }

    @DeleteMapping("/{month}/{number}")
    public void delete(@PathVariable(required = true) String month, @PathVariable(required = true) int num) {
        service.delete(num, month);
    }
}