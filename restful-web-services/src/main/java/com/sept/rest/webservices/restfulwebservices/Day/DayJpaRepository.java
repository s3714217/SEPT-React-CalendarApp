package com.sept.rest.webservices.restfulwebservices.Day;

import java.util.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sept.rest.webservices.restfulwebservices.Event.Event;

@Repository
public interface DayJpaRepository extends JpaRepository<Day, Long> {

    Day findDay(int num, String month);
    List<Day> findall();
    void deleteById(int num, String month);
    void Add(Day day);
	void updateDay(Day day);
	
}