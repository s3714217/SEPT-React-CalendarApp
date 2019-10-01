package com.sept.rest.webservices.restfulwebservices.Day;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class DayService {
    @Autowired
    DayJpaRepository repository;

    public void add(Day day) {
        repository.save(toEntity(day));
    }

    public void delete(int num, String month) {
        repository.deleteById(num, month);
    }

    public List<Day> getDays() {
        return (List<Day>) repository.findAll();
    }

    public Day getDayByNumAndMonth(int num, String month) {
        Optional<Day> optionalDay = repository.findDay(num, month);
        return optionalDay.orElseThrow();

    }

    private Day toEntity(Day day) {
        Day entity = day;
        entity.setDayNumber(day.getDayNumber());
        entity.setDayName(day.getDayName());
        entity.setDayMonth(day.getDayMonth());
        return entity;
    }

}