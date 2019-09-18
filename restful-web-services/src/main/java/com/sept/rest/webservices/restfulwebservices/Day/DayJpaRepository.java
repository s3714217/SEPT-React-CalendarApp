package com.sept.rest.webservices.restfulwebservices.Day;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayJpaRepository extends JpaRepository<Day, Long> {

    Optional<Day> findDay(int num, String month);
}