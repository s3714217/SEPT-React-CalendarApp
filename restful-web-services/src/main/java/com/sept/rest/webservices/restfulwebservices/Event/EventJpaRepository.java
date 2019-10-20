package com.sept.rest.webservices.restfulwebservices.Event;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sept.rest.webservices.restfulwebservices.Day.Day;
import com.sept.rest.webservices.restfulwebservices.user.User;

@Repository
public interface EventJpaRepository extends JpaRepository<Event, Long> {
	
	

}