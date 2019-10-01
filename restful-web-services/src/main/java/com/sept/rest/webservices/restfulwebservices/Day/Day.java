package com.sept.rest.webservices.restfulwebservices.Day;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "days")
public class Day {
    @Id
    private int ID;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String month;

    public Day() {
    }

    public Day(int number, String name) {
        this.ID = number;
        this.name = name;
    }

    public int getDayNumber() {
        return this.ID;
    }

    public String getDayName() {
        return this.name;
    }

    public String getDayMonth() {
        return this.month;
    }

    public void setDayNumber(int num) {
        if (num >= 1 || num <= 31) {
            this.ID = num;

        }
    }

    public void setDayName(String name) {
        ArrayList<String> days = new ArrayList<String>();
        days.add("sunday");
        days.add("saturday");
        days.add("monday");
        days.add("tuesday");
        days.add("wednesday");
        days.add("thursday");
        days.add("friday");

        if (days.contains(name)) {
            this.name = name;

        }

    }

    public void setDayMonth(String month) {
        ArrayList<String> months = new ArrayList<String>();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");

        if (months.contains(month)) {
            this.month = month;

        }
    }

}
