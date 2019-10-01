package com.sept.rest.webservices.restfulwebservices.Day;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
 
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController

public class DayController {
	@Autowired
	private DayService dayService;
  
  

    @GetMapping
    public List<Day> getDays() {
        return dayService.getDays();
    }

    @PostMapping
    public void postDays(@RequestBody Day day) {
        dayService.add(day);
    }

    @GetMapping("/{month}/{number}")
    public Day getByNumAndMonth(@PathVariable(required = true) String month, @PathVariable(required = true) int num) {
        return dayService.getDayByNumAndMonth(num, month);
    }

    @DeleteMapping("/{month}/{number}")
    public void delete(@PathVariable(required = true) String month, @PathVariable(required = true) int num) {
        dayService.delete(num, month);
    }
}