package com.sept.rest.webservices.restfulwebservices.Event;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sept.rest.webservices.restfulwebservices.Day.Day;

@Repository
public interface EventJpaRepository extends JpaRepository<Event, Long> {

	void deleteById(int id);

	Optional<Event> findEvent(int id);

	Optional<Event> findEvent(Day day);

}
