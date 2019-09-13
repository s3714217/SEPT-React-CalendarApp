package com.sept.rest.webservices.restfulwebservices.Day;

import java.util.*;
import java.util.function.Predicate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sept.rest.webservices.restfulwebservices.Event.Event;

@Entity
@Table(name = "days")
public class Day {
    @Id
    private int number;
    private String name;

    public Day(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getDayNumber() {
        return this.number;
    }

    public String getDayName() {
        return this.name;
    }

}
